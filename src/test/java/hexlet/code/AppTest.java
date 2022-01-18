package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class AppTest {
    private StringSchema stringSchema;
    private NumberSchema numberSchema;
    @BeforeEach
    void init() {
        Validator s = new Validator();
        stringSchema = s.string();
        Validator n = new Validator();
        numberSchema = n.number();
    }

    @Test
    void testApp() {
        assertThat(App.greetings()).isEqualTo("Hello, World!");
    }

    @Test
    void testStringValidatorComplex() {
        assertThat(stringSchema.isValid("")).isTrue();
        assertThat(stringSchema.isValid(null)).isTrue();
        assertThat(stringSchema.isValid("123")).isFalse();

        stringSchema.minLength(2);
        assertThat(stringSchema.isValid("hi")).isTrue();
        assertThat(stringSchema.isValid("1")).isFalse();

        stringSchema.required();
        assertThat(stringSchema.isValid(null)).isFalse();
        assertThat(stringSchema.isValid("123")).isTrue();

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
}
