class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private Student head;

    public void addStudentAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addStudentAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public void addStudentAtPosition(int rollNumber, String name, int age, String grade, int position) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (position == 1) {
            newStudent.next = head;
            head = newStudent;
            return;
        }
        Student temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public void deleteStudentByRollNumber(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student not found!");
            return;
        }
        temp.next = temp.next.next;
    }

    public Student searchStudentByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void updateStudentGrade(int rollNumber, String newGrade) {
        Student student = searchStudentByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
            System.out.println("Grade updated successfully.");
        } else {
            System.out.println("Student not found!");
        }
    }

    public void displayStudents() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();
        
        studentList.addStudentAtBeginning(101, "Alice", 20, "A");
        studentList.addStudentAtEnd(102, "Bob", 21, "B");
        studentList.addStudentAtPosition(103, "Charlie", 22, "C", 2);
        
        System.out.println("All Students:");
        studentList.displayStudents();
        
        System.out.println("Searching for Student with Roll Number 102:");
        Student student = studentList.searchStudentByRollNumber(102);
        if (student != null) {
            System.out.println("Found: " + student.name);
        } else {
            System.out.println("Student not found!");
        }
        
        System.out.println("Updating grade for Roll Number 103:");
        studentList.updateStudentGrade(103, "A+");
        studentList.displayStudents();
        
        System.out.println("Deleting Student with Roll Number 101:");
        studentList.deleteStudentByRollNumber(101);
        studentList.displayStudents();
    }
}

