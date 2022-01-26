package hexlet.code.schemas;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {
    private final Predicate<Object> isMap = object -> object instanceof Map;

    public void required() {
        addValidation(isMap);
    }

    public void sizeof(int countKeysPairs) {
        Predicate<Object> isEqualCount = object -> ((Map) object).size() == countKeysPairs;
        addValidation(isMap);
        addValidation(isEqualCount);
    }

    public void shape(Map<String, BaseSchema> map) {
        Set<String> keys = map.keySet();
        for (String key : keys) {
            Predicate<Object> isEqual = object -> map.get(key).isValid(((Map) object).get(key));
            addValidation(isEqual);
        }
    }
}
