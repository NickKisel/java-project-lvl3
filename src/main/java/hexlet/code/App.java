package hexlet.code;

import hexlet.code.schemas.StringSchema;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {
        Validator v = new Validator();
        StringSchema schema = v.string();
        Predicate<Object> isEmpty = object -> object == null || object.equals("");
        System.out.println(isEmpty.test("123"));
        List<Predicate<Object>> list = new LinkedList<>();
        list.add(isEmpty);
        System.out.println(list.stream()
                .allMatch(x -> x.test("123")));
    }

    public static String greetings() {
        return "Hello, World!";
    }
}
