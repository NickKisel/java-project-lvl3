package hexlet.code;


public class BaseSchema {
    private ValidatorInterface validatorInterface;
    /**
     *
     * @param object can be String or Integer
     * @return result of validation
     */
    public boolean isValid(Object object) {
        return validatorInterface.isValid(object);
    }
}
