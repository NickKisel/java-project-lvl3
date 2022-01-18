package hexlet.code.NumberValidator;

import hexlet.code.NumberSchema;

public final class PositiveState implements NumberValidator {
    private NumberSchema numberSchema;

    public PositiveState(NumberSchema schema) {
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
        if (object instanceof Integer) {
            return (int) object >= 0;
        }
        return false;
    }
}
