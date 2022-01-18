package hexlet.code;

import hexlet.code.StringValidator.StringString;
import hexlet.code.StringValidator.StringValidator;

public final class StringSchema extends BaseSchema {
    private StringValidator stringValidator;

    public StringSchema() {
        this.stringValidator = new StringString(this);
    }

    public void setValidatorState(StringValidator state) {
        this.stringValidator = state;
    }

    public boolean isValid(Object o) {
        return stringValidator.isValid(o);
    }

    public void required() {
        this.stringValidator.required();
    }

    public void minLength(int setMinLength) {
        this.stringValidator.minLength(setMinLength);
    }

    public StringSchema contains(String setString) {
        this.stringValidator.contains(setString);
        return this;
    }
}
