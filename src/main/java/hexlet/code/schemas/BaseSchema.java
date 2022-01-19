package hexlet.code.schemas;

import hexlet.code.states.BaseStates.StatesValidator;

public class BaseSchema {
    private StatesValidator statesValidator;
    /**
     *
     * @param object can be String or Integer
     * @return result of validation
     */
    public boolean isValid(Object object) {
        return statesValidator.isValid(object);
    }

    /**
     *
     * @param state - set state
     */
    public void setValidatorState(StatesValidator state) {
        this.statesValidator = state;
    }
}
