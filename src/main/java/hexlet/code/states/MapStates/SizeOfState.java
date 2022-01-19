package hexlet.code.states.MapStates;

import hexlet.code.schemas.MapSchema;

import java.util.Map;

public class SizeOfState implements MapStates {
    private MapSchema mapSchema;
    private int countKeysPairs;

    public SizeOfState(MapSchema schema, int count) {
        this.mapSchema = schema;
        this.countKeysPairs = count;
    }

    @Override
    public void sizeOf(int countKeyPair) {
        MapSchema newSchema = this.mapSchema;
        newSchema.setValidatorState(new SizeOfState(newSchema, countKeyPair));
    }

    @Override
    public void required() {
        MapSchema newSchema = this.mapSchema;
        newSchema.setValidatorState(new RequiredMapState(mapSchema));
    }

    @Override
    public boolean isValid(Object object) {
        if (object instanceof Map) {
            return ((Map) object).size() == countKeysPairs;
        }
        return false;
    }
}
