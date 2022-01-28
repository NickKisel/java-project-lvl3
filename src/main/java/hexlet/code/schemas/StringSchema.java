package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
    }

    public StringSchema required() {
        requiredCall();
        addValidation(object -> object instanceof String && !object.equals(""));
        return this;
    }

    public StringSchema contains(String string) {
        addValidation(object -> object instanceof String && ((String) object).contains(string));
        return this;
    }

    public StringSchema minLength(int length) {
        addValidation(object -> object instanceof String && ((String) object).length() >= length);
        return this;
    }
}
