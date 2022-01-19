package hexlet.code.states.StringStates;

import hexlet.code.states.BaseStates.StatesValidator;

public interface StringStates extends StatesValidator {
    void contains(String string);
    void minLength(int minLength);
}
