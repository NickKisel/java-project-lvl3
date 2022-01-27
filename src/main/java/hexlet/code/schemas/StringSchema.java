package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
    }

    public StringSchema required() {
        addValidation(object -> object instanceof String && !object.equals(""));
        return this;
    }

    public StringSchema contains(String string) {
        addValidation(object -> object == null || ((String) object).contains(string));
        return this;
    }

    public StringSchema minLength(int length) {
        addValidation(object -> object == null || object instanceof String && ((String) object).length() >= length);
        return this;
    }
}
