class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next, prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagement {
    private Book head = null, tail = null;
    private int bookCount = 0;

    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        bookCount++;
    }

    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        bookCount++;
    }

    public void removeBookById(int bookId) {
        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp == head) head = head.next;
        if (temp == tail) tail = tail.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
        bookCount--;
    }

    public void searchBookByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    public void searchBookByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println("Book Found: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            }
            temp = temp.next;
        }
    }

    public void updateAvailability(int bookId, boolean newStatus) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = newStatus;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayBooksForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    public void displayBooksReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    public void countTotalBooks() {
        System.out.println("Total Books in Library: " + bookCount);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        library.addBookAtBeginning("Harry Potter", "J.K. Rowling", "Fantasy", 101, true);
        library.addBookAtEnd("The Hobbit", "J.R.R. Tolkien", "Fantasy", 102, true);
        library.addBookAtEnd("1984", "George Orwell", "Dystopian", 103, false);

        System.out.println("All Books in Forward Order:");
        library.displayBooksForward();

        System.out.println("All Books in Reverse Order:");
        library.displayBooksReverse();

        System.out.println("Searching for '1984':");
        library.searchBookByTitle("1984");

        System.out.println("Updating Availability of Book ID 103 to True:");
        library.updateAvailability(103, true);
        library.displayBooksForward();

        System.out.println("Total Books Count:");
        library.countTotalBooks();
    }
}
