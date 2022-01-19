package hexlet.code.schemas;

import hexlet.code.states.StringStates.DefaultStringState;
import hexlet.code.states.StringStates.StringStates;

public final class StringSchema extends BaseSchema {
    private StringStates stringStates;

    public StringSchema() {
        this.stringStates = new DefaultStringState(this);
    }

    public void setValidatorState(StringStates state) {
        this.stringStates = state;
    }

    public boolean isValid(Object o) {
        return stringStates.isValid(o);
    }

    public void required() {
        this.stringStates.required();
    }

    public void minLength(int setMinLength) {
        this.stringStates.minLength(setMinLength);
    }

    public StringSchema contains(String setString) {
        this.stringStates.contains(setString);
        return this;
    }
}
