package hexlet.code.ValidatorState;

public interface ValidatorState {
    void string();
    void required();
    void contains(String string) throws Exception;
    void minLength(int minLength) throws Exception;
    boolean isValid(String validated);
}
