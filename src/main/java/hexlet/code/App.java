package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.StringSchema;

public class App {
    public static void main(String[] args) {
        BaseSchema  schema = new StringSchema();

        System.out.println(greetings());
    }

    public static String greetings() {
        return "Hello, World!";
    }
}
