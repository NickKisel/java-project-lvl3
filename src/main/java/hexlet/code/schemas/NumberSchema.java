package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {
    private final Predicate<Object> isInteger = object -> object instanceof Integer;

    public void required() {
        addValidation(isInteger);
    }

    public NumberSchema positive() {
        Predicate<Object> isPositive = object -> {
            if (object instanceof Integer) {
                return (Integer) object > 0;
            }
            return object == null;
        };
        addValidation(isPositive);
        return this;
    }

    public void range(int min, int max) {
        Predicate<Object> isInRange = object -> (Integer) object >= min && (Integer) object <= max;
        addValidation(isInteger);
        addValidation(isInRange);
    }
}
