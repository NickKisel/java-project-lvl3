package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {
    private final Predicate<Object> isInteger = object -> object instanceof Integer;

    public void required() {
        getPredicates().add(isInteger);
    }

    public NumberSchema positive() {
        Predicate<Object> isPositive = object -> {
            if (object instanceof Integer) {
                return (Integer) object > 0;
            }
            return object == null;
        };
        getPredicates().add(isPositive);
        return this;
    }

    public void range(int min, int max) {
        Predicate<Object> isInRange = object -> (Integer) object >= min && (Integer) object <= max;
        getPredicates().add(isInteger);
        getPredicates().add(isInRange);
    }
}
