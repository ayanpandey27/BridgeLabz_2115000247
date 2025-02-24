import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

class JsonSerializer {
    public static String serialize(Object obj) {
        Map<String, String> jsonMap = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                try {
                    String jsonKey = field.getAnnotation(JsonField.class).name();
                    String jsonValue = field.get(obj).toString();
                    jsonMap.put(jsonKey, jsonValue);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return jsonMap.toString().replace("=", ": ");
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("Alice", 25);
        String json = JsonSerializer.serialize(user);
        System.out.println(json);
    }
}

