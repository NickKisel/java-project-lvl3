package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public void required() {
        super.forValidation.clear();
        Predicate<Object> isInteger = object -> object instanceof Integer;
        super.forValidation.add(isInteger);
    }

    public NumberSchema positive() {
        super.forValidation.clear();
        Predicate<Object> isPositive = object -> {
            if (object instanceof Integer) {
                return (Integer) object >= 0;
            } else {
                return object == null;
            }
        };
        super.forValidation.add(isPositive);
        return this;
    }

    public void range(int min, int max) {
        required();
        Predicate<Object> isInRange = object -> (Integer) object >= min && (Integer) object <= max;
        super.forValidation.add(isInRange);
    }


}
