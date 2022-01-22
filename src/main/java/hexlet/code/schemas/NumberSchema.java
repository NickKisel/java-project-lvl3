package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public void required() {
        Predicate<Object> isInteger = object -> object instanceof Integer;
        super.forValidation.add(isInteger);
    }

    public NumberSchema positive() {
        Predicate<Object> isPositive = object -> {
            if (object instanceof Integer) {
                return (Integer) object >= 0;
            }
            return object == null;
        };
        super.forValidation.add(isPositive);
        return this;
    }

    public void range(int min, int max) {
        Predicate<Object> isInRange = object -> (Integer) object >= min && (Integer) object <= max;
        super.forValidation.add(isInRange);
    }


}
