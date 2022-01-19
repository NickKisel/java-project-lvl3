package hexlet.code.states.BaseStates;

public interface StatesValidator {
    void required();
    boolean isValid(Object object);
}
