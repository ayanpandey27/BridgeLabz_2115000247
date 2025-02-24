import java.lang.annotation.*;
import java.lang.reflect.AnnotatedElement;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

// Apply annotation to a class
@Author(name = "John Doe")
class SampleClass {
}

public class AnnotationRetriever {
    public static void main(String[] args) {
        try {
            Class<?> clazz = SampleClass.class;

            if (clazz.isAnnotationPresent(Author.class)) {
                Author author = clazz.getAnnotation(Author.class);
                System.out.println("Author: " + author.name());
            } else {
                System.out.println("No @Author annotation found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

