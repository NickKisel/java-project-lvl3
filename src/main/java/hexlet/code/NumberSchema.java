package hexlet.code;

import hexlet.code.NumberValidator.NumberState;
import hexlet.code.NumberValidator.NumberValidator;

public final class NumberSchema extends BaseSchema {
    private NumberValidator numberValidator;

    public NumberSchema() {
        this.numberValidator = new NumberState(this);
    }

    public void setValidatorState(NumberValidator state) {
        this.numberValidator = state;
    }

    public boolean isValid(Object o) {
        return numberValidator.isValid(o);
    }

    public NumberSchema positive() {
        this.numberValidator.positive();
        return this;
    }

    public void range(int min, int max) {
        this.numberValidator.range(min, max);
    }

    public void required() {
        this.numberValidator.required();
    }
}
