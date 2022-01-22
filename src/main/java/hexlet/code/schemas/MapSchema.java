package hexlet.code.schemas;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    public void required() {
        Predicate<Object> isMap = object -> object instanceof Map;
        super.forValidation.add(isMap);
    }

    public void sizeof(int countKeysPairs) {
        Predicate<Object> isEqualCount = object -> ((Map) object).size() == countKeysPairs;
        System.out.println(isEqualCount);
        super.forValidation.add(isEqualCount);
    }

    public MapSchema shape(Map<String, BaseSchema> map) {
        List<Predicate<Object>> shape = new LinkedList<>();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            Predicate<Object> isEqual = object -> map.get(key).isValid(((Map) object).get(key));
            shape.add(isEqual);
        }
        super.forValidation.clear();
        super.forValidation.addAll(shape);
        return this;
    }
}
