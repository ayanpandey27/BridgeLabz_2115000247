import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + "}";
    }
}

public class CSVToStudent {
    public static void main(String[] args) {
        String filePath = "students.csv";
        List<Student> students = readStudentsFromCSV(filePath);
        students.forEach(System.out::println);
    }

    public static List<Student> readStudentsFromCSV(String filePath) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length != 3) continue;

                int id = Integer.parseInt(fields[0].trim());
                String name = fields[1].trim();
                int age = Integer.parseInt(fields[2].trim());

                students.add(new Student(id, name, age));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}

