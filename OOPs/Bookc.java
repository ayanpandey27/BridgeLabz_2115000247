public class Book {
    private String title;
    private String author;
    private double price;

    // Default constructor
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }

    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book information
    public void displayInfo() {
        System.out.printf("Title: %s, Author: %s, Price: $%.2f%n", title, author, price);
    }

    // Example usage
    public static void main(String[] args) {
        Book book1 = new Book(); // Default constructor
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 10.99); // Parameterized constructor

        book1.displayInfo();
        book2.displayInfo();
   

