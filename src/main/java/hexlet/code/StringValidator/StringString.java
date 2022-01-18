package hexlet.code.StringValidator;

import hexlet.code.StringSchema;

public final class StringString implements StringValidator {
    private StringSchema stringSchema;

    public StringString(StringSchema schema) {
        this.stringSchema = schema;
    }

    @Override
    public void required() {
        StringSchema newSchema = this.stringSchema;
        stringSchema.setValidatorState(new RequiredString(newSchema));
    }

    @Override
    public boolean isValid(Object object) {
        return object == null || object.equals("");
    }

    @Override
    public void contains(String string) {
        StringSchema newSchema = this.stringSchema;
        stringSchema.setValidatorState(new ContainsString(newSchema, string));
    }

    @Override
    public void minLength(int minLength) {
        StringSchema newSchema = this.stringSchema;
        stringSchema.setValidatorState(new MinLengthString(newSchema, minLength));
    }
}
