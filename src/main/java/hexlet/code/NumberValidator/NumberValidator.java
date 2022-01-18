package hexlet.code.NumberValidator;

import hexlet.code.ValidatorInterface;

public interface NumberValidator extends ValidatorInterface {
    void positive();
    void range(int min, int max);
}
