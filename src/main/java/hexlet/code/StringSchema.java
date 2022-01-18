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

    public ValidatorState getValidatorState() {
        return validatorState;
    }

    public boolean isValid(String validation) {
        return validatorState.isValid(validation);
    }

    public void required() {
        this.validatorState.required();
    }

    public void minLength(int setMinLength) {
        try {
            this.validatorState.minLength(setMinLength);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public StringSchema contains(String setString) {
        try {
            this.validatorState.contains(setString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
}
