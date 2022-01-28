package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public void required() {
        requiredCall();
        addValidation(object -> object instanceof Integer);
    }

    public NumberSchema positive() {
        addValidation(object -> object instanceof Integer && ((Integer) object) > 0);
        return this;
    }

    public void range(int min, int max) {
        addValidation(object -> object instanceof Integer
                && (Integer) object >= min && (Integer) object <= max);
    }
}
