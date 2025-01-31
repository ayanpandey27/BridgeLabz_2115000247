public class Book {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true; // By default, the book is available
    }

    public Book(Book other) {
        this.title = other.title;
        this.author = other.author;
        this.price = other.price;
        this.isAvailable = other.isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have successfully borrowed the book: " + title);
        } else {
            System.out.println("Sorry, the book is currently unavailable.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("You have successfully returned the book: " + title);
    }

    @Override
    public String toString() {
        return "Book [Title=" + title + ", Author=" + author + ", Price=" + price + ", Available=" + isAvailable + "]";
    }

    public static void main(String[] args) {
        Book book1 = new Book("1984", "George Orwell", 15.99);
        System.out.println(book1);

        book1.borrowBook(); // Borrowing the book
        System.out.println(book1);

        book1.returnBook(); // Returning the book
        System.out.println(book1);
    }
}

