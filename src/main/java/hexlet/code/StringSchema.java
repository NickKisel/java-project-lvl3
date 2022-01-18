package hexlet.code;

import hexlet.code.ValidatorState.StringState;
import hexlet.code.ValidatorState.ValidatorState;

public final class StringSchema {
    private ValidatorState validatorState;

    public StringSchema() {
        this.validatorState = new StringState(this);
    }

    public void setValidatorState(ValidatorState state) {
        this.validatorState = state;
    }

    public boolean isValid(String validation) {
        return validatorState.isValid(validation);
    }

    public void required() {
        this.validatorState.required();
    }

    public void minLength(int setMinLength) {
        this.validatorState.minLength(setMinLength);
    }

    public StringSchema contains(String setString) {
        this.validatorState.contains(setString);
        return this;
    }
}
