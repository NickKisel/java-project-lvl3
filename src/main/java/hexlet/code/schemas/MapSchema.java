package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    public MapSchema() {
        Predicate<Object> isEmpty = object -> object == null;
        super.forValidation.add(isEmpty);
    }

    public void required() {
        super.forValidation.clear();
        Predicate<Object> isMap = object -> object instanceof Map;
        super.forValidation.add(isMap);
    }

    public void sizeOf(int countKeysPairs) {
        required();
        Predicate<Object> isEqualCount = object -> ((Map) object).size() == countKeysPairs;
        super.forValidation.add(isEqualCount);
    }
}
