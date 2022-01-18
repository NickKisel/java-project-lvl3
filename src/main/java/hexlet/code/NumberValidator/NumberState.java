package hexlet.code.NumberValidator;

import hexlet.code.NumberSchema;

public final class NumberState implements NumberValidator {
    private NumberSchema numberSchema;

    public NumberState(NumberSchema schema) {
        this.numberSchema = schema;
    }

    @Override
    public void positive() {
        NumberSchema newSchema = this.numberSchema;
        newSchema.setValidatorState(new PositiveState(newSchema));
    }

    @Override
    public void range(int min, int max) {
        NumberSchema newSchema = this.numberSchema;
        newSchema.setValidatorState(new RangeState(newSchema, min, max));
    }

    @Override
    public void required() {
        NumberSchema newSchema = this.numberSchema;
        newSchema.setValidatorState(new IRequiredState(newSchema));
    }

    @Override
    public boolean isValid(Object object) {
        return object == null;
    }
}
