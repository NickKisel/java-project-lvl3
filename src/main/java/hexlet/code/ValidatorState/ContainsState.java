package hexlet.code.ValidatorState;

import hexlet.code.StringSchema;

public final class ContainsState implements ValidatorState {

    private StringSchema stringSchema;
    private String flagWord;

    public ContainsState(StringSchema schema, String setFlagWord) {
        this.stringSchema = schema;
        this.flagWord = setFlagWord;
    }

    @Override
    public void string() {
        StringSchema newSchema = this.stringSchema;
        stringSchema.setValidatorState(new StringState(newSchema));
    }

    @Override
    public void required() {
        StringSchema newSchema = this.stringSchema;
        stringSchema.setValidatorState(new RequiredState(newSchema));
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

    @Override
    public boolean isValid(String validated) {
        return validated.contains(flagWord);
    }
}
