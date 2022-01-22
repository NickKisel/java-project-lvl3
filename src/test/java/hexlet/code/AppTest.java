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

class AppTest {
    private Validator v;

    @BeforeEach
    void init() {
        v = new Validator();
    }

    @Test
    void testApp() {
        assertThat(App.greetings()).isEqualTo("Hello, World!");
    }

    @Test
    void testStringValidatorComplex() {
        StringSchema stringSchema = v.string();
        assertThat(stringSchema.isValid("")).isTrue();
        assertThat(stringSchema.isValid(null)).isTrue();
        assertThat(stringSchema.isValid("123")).isFalse();

        stringSchema.minLength(2);
        assertThat(stringSchema.isValid("hi")).isTrue();
        assertThat(stringSchema.isValid("1")).isFalse();

        stringSchema.required();
        assertThat(stringSchema.isValid(null)).isFalse();
        assertThat(stringSchema.isValid("123")).isTrue();
//
        assertThat(stringSchema.contains("mix").isValid("fresh mix")).isTrue();
        assertThat(stringSchema.contains("Greet").isValid("fresh mix")).isFalse();
    }

    @Test
    void testNumberValidatorComplex() {
        final int min = 4;
        final int max = 10;
        final int minRangeCheck = 4;
        final int maxRangeCheck = 10;
        final int midRangeCheck = 6;
        final int lessMinRangeCheck = 3;
        final int moreMaxRangeCheck = 11;

        NumberSchema numberSchema = v.number();

        assertThat(numberSchema.isValid(null)).isTrue();
        assertThat(numberSchema.isValid(1)).isFalse();

        assertThat(numberSchema.positive().isValid(1)).isTrue();
        assertThat(numberSchema.isValid(-1)).isFalse();

        numberSchema.required();
        assertThat(numberSchema.isValid(0)).isTrue();
        assertThat(numberSchema.isValid(1)).isTrue();
        assertThat(numberSchema.isValid(-1)).isTrue();
        assertThat(numberSchema.isValid(null)).isFalse();

        numberSchema.range(min, max);
        assertThat(numberSchema.isValid(minRangeCheck)).isTrue();
        assertThat(numberSchema.isValid(midRangeCheck)).isTrue();
        assertThat(numberSchema.isValid(maxRangeCheck)).isTrue();
        assertThat(numberSchema.isValid(lessMinRangeCheck)).isFalse();
        assertThat(numberSchema.isValid(moreMaxRangeCheck)).isFalse();
    }

    @Test
    void testMapValidatorComplex() {
        MapSchema mapSchema = v.map();

        assertThat(mapSchema.isValid(null)).isTrue();
        assertThat(mapSchema.isValid(Map.of(1, "hey"))).isFalse();

        mapSchema.required();

        assertThat(mapSchema.isValid(Map.of(1, "hey"))).isTrue();
        assertThat(mapSchema.isValid(new HashMap<>())).isTrue();
        Map<String, String> mapTest = new LinkedHashMap<>();
        mapTest.put("Hello!", "World!");
        assertThat(mapSchema.isValid(mapTest)).isTrue();

        mapSchema.sizeOf(2);
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
