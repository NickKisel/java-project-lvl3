package hexlet.code.ValidatorState;

public interface ValidatorState {
    void string();
    void required();
    void contains(String string);
    void minLength(int minLength);
    boolean isValid(String validated);
}
