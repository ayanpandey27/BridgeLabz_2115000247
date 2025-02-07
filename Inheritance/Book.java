class Book {
    protected String title;
    protected int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo() {
        System.out.println("Title: " + title + ", Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + name + ", Bio: " + bio);
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Author book1 = new Author("To Kill a Mockingbird", 1960, "Harper Lee", "American novelist widely known for her novel.");
        Author book2 = new Author("1984", 1949, "George Orwell", "English novelist, essayist, journalist and critic.");
        
        book1.displayInfo();
        System.out.println();
        book2.displayInfo();
    }
}

