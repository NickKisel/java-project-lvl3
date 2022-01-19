package hexlet.code.schemas;

import hexlet.code.states.MapStates.DefaultMapState;
import hexlet.code.states.MapStates.MapStates;

public final class MapSchema extends BaseSchema {
    private MapStates mapState;

    public MapSchema() {
        this.mapState = new DefaultMapState(this);
    }

    public void setValidatorState(MapStates state) {
        this.mapState = state;
    }

    public void sizeOf(int countKeysPairs) {
        this.mapState.sizeOf(countKeysPairs);
    }

    public boolean isValid(Object o) {
        return mapState.isValid(o);
    }

    public void required() {
        this.mapState.required();
    }
}
