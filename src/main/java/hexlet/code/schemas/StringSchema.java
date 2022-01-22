package hexlet.code.schemas;


import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {
    private final Predicate<Object> isString = object -> object instanceof String;

    public StringSchema() {
    }

    public StringSchema required() {
        Predicate<Object> isNotEmptyString = object -> !object.equals("");
        super.predicates.add(isString);
        super.predicates.add(isNotEmptyString);
        return this;
    }

    public StringSchema contains(String string) {
        Predicate<Object> isContains = object -> ((String) object).contains(string);
        super.predicates.add(isString);
        super.predicates.add(isContains);
        return this;
    }

    public void minLength(int length) {
        Predicate<Object> isEqualOrLonger = object -> object.toString().length() >= length;
        super.predicates.add(isString);
        super.predicates.add(isEqualOrLonger);
    }
}
