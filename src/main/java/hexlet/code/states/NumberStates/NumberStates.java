package hexlet.code.states.NumberStates;

import hexlet.code.states.BaseStates.StatesValidator;

public interface NumberStates extends StatesValidator {
    void positive();
    void range(int min, int max);
}
