package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public final class Validator {
    private BaseSchema type;

    public StringSchema string() {
        this.type = new StringSchema();
        return new StringSchema();
    }

    public NumberSchema number() {
        this.type = new NumberSchema();
        return new NumberSchema();
    }

    public MapSchema map() {
        this.type = new MapSchema();
        return new MapSchema();
    }

    public BaseSchema getType() {
        return type;
    }
}
