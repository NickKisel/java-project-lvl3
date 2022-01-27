package hexlet.code.schemas;

import java.util.Map;
import java.util.Set;

public final class MapSchema extends BaseSchema {

    public void required() {
        addValidation(object -> object instanceof Map);
    }

    public void sizeof(int countKeysPairs) {
        addValidation(object -> object == null || object instanceof Map
                && ((Map<?, ?>) object).size() == countKeysPairs);
    }

    public void shape(Map<String, BaseSchema> map) {
        Set<String> keys = map.keySet();
        for (String key : keys) {
            addValidation(object -> map.get(key).isValid(((Map<?, ?>) object).get(key)));
        }
    }
}
