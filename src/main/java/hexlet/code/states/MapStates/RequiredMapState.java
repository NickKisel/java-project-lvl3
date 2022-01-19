package hexlet.code.states.MapStates;

import hexlet.code.schemas.MapSchema;

import java.util.Map;

public final class RequiredMapState implements MapStates {
    private MapSchema mapSchema;

    public RequiredMapState(MapSchema schema) {
        this.mapSchema = schema;
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
        return object instanceof Map;
    }
}
