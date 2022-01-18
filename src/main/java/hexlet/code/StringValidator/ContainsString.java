package hexlet.code.StringValidator;

import hexlet.code.StringSchema;

public final class ContainsString implements StringValidator {

    private StringSchema stringSchema;
    private String flagWord;

    public ContainsString(StringSchema schema, String setFlagWord) {
        this.stringSchema = schema;
        this.flagWord = setFlagWord;
    }

    @Override
    public void required() {
        StringSchema newSchema = this.stringSchema;
        stringSchema.setValidatorState(new RequiredString(newSchema));
    }

    @Override
    public boolean isValid(Object object) {
        return ((String) object).contains(flagWord);
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
