package hexlet.code.StringValidator;

import hexlet.code.StringSchema;

public final class MinLengthString implements StringValidator {

    private StringSchema stringSchema;
    private int length;

    public MinLengthString(StringSchema schema, int setLength) {
        this.stringSchema = schema;
        this.length = setLength;
    }

    @Override
    public void required() {
        StringSchema newSchema = this.stringSchema;
        stringSchema.setValidatorState(new RequiredString(newSchema));
    }

    @Override
    public boolean isValid(Object object) {
        return ((String) object).length() >= this.length;
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
