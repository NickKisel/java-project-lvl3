package hexlet.code.states.StringStates;

import hexlet.code.schemas.StringSchema;

public final class RequiredStringState implements StringStates {

    private StringSchema stringSchema;

    public RequiredStringState(StringSchema schema) {
        this.stringSchema = schema;
    }

    @Override
    public void required() {
        StringSchema newSchema = this.stringSchema;
        stringSchema.setValidatorState(new RequiredStringState(newSchema));
    }

    @Override
    public boolean isValid(Object object) {
        return object != null && !object.equals("");
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
