package hexlet.code.schemas;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {
    private final Predicate<Object> isMap = object -> object instanceof Map;

    public void required() {
        getPredicates().add(isMap);
    }

    public void sizeof(int countKeysPairs) {
        Predicate<Object> isEqualCount = object -> ((Map) object).size() == countKeysPairs;
        getPredicates().add(isMap);
        getPredicates().add(isEqualCount);
    }

    public void shape(Map<String, BaseSchema> map) {
        List<Predicate<Object>> shapePredicates = new LinkedList<>();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            Predicate<Object> isEqual = object -> map.get(key).isValid(((Map) object).get(key));
            shapePredicates.add(isEqual);
        }
        getPredicates().clear();
        getPredicates().addAll(shapePredicates);
    }
}
