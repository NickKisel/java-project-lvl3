package hexlet.code.states.StringStates;

import hexlet.code.schemas.StringSchema;
import hexlet.code.states.BaseStates.StatesValidator;

public final class ContainsState implements StringStates {

    private StringSchema stringSchema;
    private String flagWord;

    public ContainsState(StringSchema schema, String setFlagWord) {
        this.stringSchema = schema;
        this.flagWord = setFlagWord;
    }

    @Override
    public void required() {
        StringSchema newSchema = this.stringSchema;
        stringSchema.setValidatorState(new RequiredStringState(newSchema));
    }

    @Override
    public boolean isValid(Object object) {
        return ((String) object).contains(flagWord);
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
