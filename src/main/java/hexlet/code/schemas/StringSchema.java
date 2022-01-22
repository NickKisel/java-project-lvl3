package hexlet.code.schemas;


import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
    }

    public StringSchema required() {
        super.forValidation.clear();
        Predicate<Object> isString = object -> object instanceof String && !object.equals("");
        super.forValidation.add(isString);
        return this;
    }

    public StringSchema contains(String string) {
        required();
        Predicate<Object> isContains = object -> ((String) object).contains(string);
        super.forValidation.add(isContains);
        return this;
    }

    public void minLength(int length) {
        required();
        Predicate<Object> isEqualOrLonger = object -> object.toString().length() >= length;
        super.forValidation.add(isEqualOrLonger);
    }
}
