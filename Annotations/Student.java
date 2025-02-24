import java.lang.reflect.Constructor;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("Student");
            Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);

            Student student = (Student) constructor.newInstance("Alice");
            student.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
