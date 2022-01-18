package hexlet.code.NumberValidator;

import hexlet.code.NumberSchema;

public final class RangeState implements NumberValidator {
    private NumberSchema numberSchema;
    private int setMin;
    private int setMax;

    public RangeState(NumberSchema schema, int a, int b) {
        this.numberSchema = schema;
        this.setMin = a;
        this.setMax = b;
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
            int iObject = (Integer) object;
            return iObject > setMin - 1 && iObject < setMax + 1;
        }
        return false;
    }
}
