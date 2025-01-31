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

class Circle {
    double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    double computeArea() {
        return Math.PI * radius * radius;
    }
    
    double computeCircumference() {
        return 2 * Math.PI * radius;
    }
    
    void displayDetails() {
        System.out.println("Circle Details:\nArea: " + computeArea() + "\nCircumference: " + computeCircumference());
    }
}

class Book {
    String title;
    String author;
    double price;
    
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    void displayDetails() {
        System.out.println("Book Details:\nTitle: " + title + "\nAuthor: " + author + "\nPrice: " + price);
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
        Circle circle = new Circle(radius);
        circle.displayDetails();
        sc.nextLine();  // Consume newline
        
        // Book Details
        System.out.println("Enter Book Title, Author, and Price:");
        String bookTitle = sc.nextLine();
        String bookAuthor = sc.nextLine();
        double bookPrice = sc.nextDouble();
        sc.nextLine();  // Consume newline
        
        Book book = new Book(bookTitle, bookAuthor, bookPrice);
        book.displayDetails();
    }
}

