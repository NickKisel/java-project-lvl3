package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {
    private Validator v;

    @BeforeEach
    void init() {
        v = new Validator();
    }

    @Test
    void testStringValidatorComplex() {
        final int minLength = 5;
        StringSchema stringSchema = v.string();
        assertThat(stringSchema.isValid("")).isTrue();
        assertThat(stringSchema.isValid(null)).isTrue();
        assertThat(stringSchema.isValid("123")).isTrue();

        stringSchema.required();
        assertThat(stringSchema.isValid(null)).isFalse();
        assertThat(stringSchema.isValid("123")).isTrue();

        stringSchema.minLength(minLength);
        assertThat(stringSchema.isValid("hello")).isTrue();
        assertThat(stringSchema.isValid("1")).isFalse();

        assertThat(stringSchema.contains("hi").isValid("hi world")).isTrue();
        assertThat(stringSchema.isValid("hi")).isFalse();
        assertThat(stringSchema.contains("dear").isValid("fresh mix")).isFalse();
        assertThat(stringSchema.isValid("hi, dear friend")).isTrue();
        assertThat(stringSchema.isValid("hi, friend")).isFalse();
        assertThat(stringSchema.isValid("dear friend")).isFalse();
    }

    @Test
    void testNumberValidatorComplex() {
        final int nThree = 3;

        NumberSchema numberSchema = v.number();

        assertThat(numberSchema.isValid(null)).isTrue();
        assertThat(numberSchema.isValid(1)).isTrue();

        assertThat(numberSchema.positive().isValid(1)).isTrue();
        assertThat(numberSchema.positive().isValid(null)).isTrue();
        assertThat(numberSchema.isValid(-1)).isFalse();
        assertThat(numberSchema.isValid(0)).isFalse();

        numberSchema.required();
        assertThat(numberSchema.isValid(null)).isFalse();
        assertThat(numberSchema.isValid("5")).isFalse();
        assertThat(numberSchema.isValid(-1)).isFalse();

        numberSchema.range(-1, 2);
        assertThat(numberSchema.isValid(-1)).isFalse();
        assertThat(numberSchema.isValid(1)).isTrue();
        assertThat(numberSchema.isValid("1")).isFalse();
        assertThat(numberSchema.isValid(1)).isTrue();
        assertThat(numberSchema.isValid(nThree)).isFalse();
    }

    @Test
    void testMapValidatorComplex() {
        MapSchema mapSchema = v.map();

        assertThat(mapSchema.isValid(null)).isTrue();
        assertThat(mapSchema.isValid(Map.of(1, "hey"))).isTrue();

        mapSchema.required();

        assertThat(mapSchema.isValid(Map.of(1, "hey"))).isTrue();
        assertThat(mapSchema.isValid(new HashMap<>())).isTrue();
        Map<String, String> mapTest = new LinkedHashMap<>();
        mapTest.put("Hello!", "World!");
        assertThat(mapSchema.isValid(mapTest)).isTrue();

        mapSchema.sizeof(2);

        assertThat(mapSchema.isValid(mapTest)).isFalse();
        mapTest.put("Hexlet", "project");
        assertThat(mapSchema.isValid(mapTest)).isTrue();
    }

    @Test
    void testMapValidatorShape() {
        final int human1Age = 100;
        final int human4Age = -5;

        MapSchema mapSchema = v.map();
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        mapSchema.shape(schemas);
        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", human1Age);
        assertThat(mapSchema.isValid(human1)).isTrue();

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertThat(mapSchema.isValid(human2)).isTrue();

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertThat(mapSchema.isValid(human3)).isFalse();

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", human4Age);
        assertThat(mapSchema.isValid(human4)).isFalse();
    }
}
