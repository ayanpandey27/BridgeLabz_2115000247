import java.util.Scanner; // Import Scanner for user input

class Student {
    static String universityName = "ABC University"; // Shared across all students
    static int totalStudents = 0; // Tracks the total number of students

    String name;
    final int rollNumber; // Unique and cannot be changed
    char grade;

    // Constructor using 'this' to initialize instance variables
    Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++; // Increase student count when a new student is created
    }

    // Static method to display total students enrolled
    static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // Method to display student details (using instanceof)
    void displayDetails() {
        if (this instanceof Student) {
            System.out.println("\nUniversity: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
            System.out.println("--------------------");
        }
    }

    // Method to update the grade of a student
    void updateGrade(char newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated successfully for " + name);
        }
    }
}

// Main class for user input and execution
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input

        // Taking input for first student
        System.out.print("Enter student name: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int roll1 = scanner.nextInt();
        System.out.print("Enter grade: ");
        char grade1 = scanner.next().charAt(0);
        scanner.nextLine(); // Consume newline

        Student student1 = new Student(name1, roll1, grade1);

        // Taking input for second student
        System.out.print("\nEnter another student name: ");
        String name2 = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int roll2 = scanner.nextInt();
        System.out.print("Enter grade: ");
        char grade2 = scanner.next().charAt(0);

        Student student2 = new Student(name2, roll2, grade2);

        // Display student details
        student1.displayDetails();
        student2.displayDetails();

        // Display total students
        Student.displayTotalStudents();

        // Updating student grade
        System.out.print("\nEnter new grade for " + student1.name + ": ");
        char newGrade = scanner.next().charAt(0);
        student1.updateGrade(newGrade);

        // Display updated details
        student1.displayDetails();

        scanner.close(); // Close scanner
    }
}

