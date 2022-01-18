package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class AppTest {
    private StringSchema schema;
    @BeforeEach
    void init() {
        Validator v = new Validator();
        schema = v.string();
    }

    @Test
    void testApp() {
        assertThat(App.greetings()).isEqualTo("Hello, World!");
    }

    @Test
    void testValidatorString() {
        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid("123")).isFalse();
    }

    @Test
    void testValidatorMinLength() {
        final int minLength = 5;
        schema.minLength(minLength);
        assertThat(schema.isValid("Hello")).isTrue();
        assertThat(schema.isValid("Bye")).isFalse();
        assertThat(schema.isValid("Hello, world!")).isTrue();
    }

    @Test
    void testValidatorContains() {
        assertThat(schema.contains("Greet").isValid("Greetings")).isTrue();
        assertThat(schema.contains("mix").isValid("fresh mix")).isTrue();
        assertThat(schema.contains("Greet").isValid("fresh mix")).isFalse();
    }

    @Test
    void testValidatorRequired() {
        schema.required();
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("123")).isTrue();
        assertThat(schema.isValid("Hello")).isTrue();
    }

    @Test
    void testValidatorComplex() {
        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid(null)).isTrue();

        schema.minLength(2);
        assertThat(schema.isValid("hi")).isTrue();
        assertThat(schema.isValid("1")).isFalse();

        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("123")).isTrue();

        assertThat(schema.contains("mix").isValid("fresh mix")).isTrue();
        assertThat(schema.contains("Greet").isValid("fresh mix")).isFalse();
    }
}
