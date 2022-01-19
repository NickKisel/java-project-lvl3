package hexlet.code.states.StringStates;

import hexlet.code.schemas.StringSchema;

public final class MinLengthState implements StringStates {

    private StringSchema stringSchema;
    private int length;

    public MinLengthState(StringSchema schema, int setLength) {
        this.stringSchema = schema;
        this.length = setLength;
    }

    @Override
    public void required() {
        StringSchema newSchema = this.stringSchema;
        stringSchema.setValidatorState(new RequiredStringState(newSchema));
    }

    @Override
    public boolean isValid(Object object) {
        return ((String) object).length() >= this.length;
    }

    @Override
    public void contains(String string) {
        StringSchema newSchema = this.stringSchema;
        stringSchema.setValidatorState(new ContainsState(newSchema, string));
    }

    @Override
    public void minLength(int minLength) {
        StringSchema newSchema = this.stringSchema;
        stringSchema.setValidatorState(new MinLengthState(newSchema, minLength));
    }
}
