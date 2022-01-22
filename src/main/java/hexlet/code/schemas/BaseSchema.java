package hexlet.code.schemas;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    protected List<Predicate<Object>> forValidation = new LinkedList<>();

    /**
     * @param object is the target for validation
     * @return is boolean
     */
    public boolean isValid(Object object) {
        return forValidation.stream()
                .allMatch(x -> x.test(object));
    }
}
