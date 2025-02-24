import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Application {
    @ImportantMethod
    public void criticalProcess() {
        System.out.println("Executing critical process...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void backupProcess() {
        System.out.println("Executing backup process...");
    }

    public void normalProcess() {
        System.out.println("Executing normal process...");
    }
}

public class Main {
    public static void main(String[] args) {
        Method[] methods = Application.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Importance Level: " + annotation.level());
            }
        }
    }
}

