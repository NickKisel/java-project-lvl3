package hexlet.code.schemas;


import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {
    private final Predicate<Object> isString = object -> object instanceof String;

    public StringSchema() {
    }

    public StringSchema required() {
        Predicate<Object> isNotEmptyString = object -> !object.equals("");
        addValidation(isString);
        addValidation(isNotEmptyString);
        return this;
    }

    public StringSchema contains(String string) {
        Predicate<Object> isContains = object -> ((String) object).contains(string);
        addValidation(isString);
        addValidation(isContains);
        return this;

    }

    public void minLength(int length) {
        Predicate<Object> isEqualOrLonger = object -> {
            if (object instanceof String) {
                return object.toString().length() >= length;
            }
            return object == null;
        };
        addValidation(isEqualOrLonger);
    }
}
