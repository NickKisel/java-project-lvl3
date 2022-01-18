package hexlet.code.StringValidator;

import hexlet.code.ValidatorInterface;

public interface StringValidator extends ValidatorInterface {
    void contains(String string);
    void minLength(int minLength);
}
