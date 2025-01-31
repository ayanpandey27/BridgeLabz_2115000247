import java.util.*;

class Employee {
    String name;
    int id;
    double salary;
    
    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    
    void displayDetails() {
        System.out.println("Employee Details:\nName: " + name + "\nID: " + id + "\nSalary: " + salary);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Employee Details
        System.out.println("Enter Employee Name, ID, and Salary:");
        String empName = sc.nextLine();
        int empId = sc.nextInt();
        double empSalary = sc.nextDouble();
        sc.nextLine();  // Consume newline
        
        Employee emp = new Employee(empName, empId, empSalary);
        emp.displayDetails();
        
        // Circle Area and Circumference
        System.out.println("Enter Circle Radius:");
        double radius = sc.nextDouble();
        double area = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;
        System.out.println("Circle Details:\nArea: " + area + "\nCircumference: " + circumference);
        sc.nextLine();  // Consume newline
        
        // Book Details
        System.out.println("Enter Book Title, Author, and Price:");
        String bookTitle = sc.nextLine();
        String bookAuthor = sc.nextLine();
        double bookPrice = sc.nextDouble();
        System.out.println("Book Details:\nTitle: " + bookTitle + "\nAuthor: " + bookAuthor + "\nPrice: " + bookPrice);
    }
}

