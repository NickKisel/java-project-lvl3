package hexlet.code;

import hexlet.code.schemas.BaseSchema;

public class App {
    public static void main(String[] args) {
        Validator v = new Validator();
        BaseSchema b = v.map();
    }

    public static String greetings() {
        return "Hello, World!";
    }
}
