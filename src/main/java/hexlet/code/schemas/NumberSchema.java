package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public void required() {
        addValidation(object -> object instanceof Integer);
    }

    public NumberSchema positive() {
        addValidation(object -> object == null || object instanceof Integer && ((Integer) object) > 0);
        return this;
    }

    public void range(int min, int max) {
        addValidation(object -> object == null || object instanceof Integer
                && (Integer) object >= min && (Integer) object <= max);
    }
}
