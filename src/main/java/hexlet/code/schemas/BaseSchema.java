package hexlet.code.schemas;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    private List<Predicate<Object>> predicates = new LinkedList<>();
    private boolean isRequiredCalled = false;

    protected final void requiredCall() {
        this.isRequiredCalled = true;
    }

    protected final void addValidation(Predicate<Object> predicate) {
        this.predicates.add(predicate);
    }

    public final boolean isValid(Object object) {
        if (!isRequiredCalled && object == null) {
            return true;
        }
        return predicates.stream()
                .allMatch(x -> x.test(object));
    }
}
