package hexlet.code.schemas;

import hexlet.code.states.NumberStates.DefaultNumberState;
import hexlet.code.states.NumberStates.NumberStates;

public final class NumberSchema extends BaseSchema {
    private NumberStates numberStates;

    public NumberSchema() {
        this.numberStates = new DefaultNumberState(this);
    }

    public void setValidatorState(NumberStates state) {
        this.numberStates = state;
    }

    public boolean isValid(Object o) {
        return numberStates.isValid(o);
    }

    public NumberSchema positive() {
        this.numberStates.positive();
        return this;
    }

    public void range(int min, int max) {
        this.numberStates.range(min, max);
    }

    public void required() {
        this.numberStates.required();
    }
}
