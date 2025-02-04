class Book{
    static String LibraryName ="XYZ Library";
    final int isbn;
    static String title;
    static String author;
    
    Book(String title,String author,int isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    
    static void displayLibraryName(){
        System.out.println("The Library Name is" +" "+LibraryName);
    }
    void displaydetails(){
        if(this instanceof Book){
            System.out.println("The Library Name is"+" "+ LibraryName);
            System.out.println("The title is"+" "+title);
            System.out.println("The author is"+" "+author);
            System.out.println("The isbn is"+" "+isbn);
        }
    }
    public static void main(String [] args){
        Book u1 = new Book("2states","Chetan Bhagat",123);
        Book u2 = new Book("Half Girlfriend","Bhagat Chetan",124);
        u1.displaydetails();
        u2.displaydetails();
        Book.displayLibraryName();
    }
    
}
