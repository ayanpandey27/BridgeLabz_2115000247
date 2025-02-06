import java.util.*;
class Book{
private String title;
private String author;
public Book(String title,String author)
{
this.title=title;
this.author=author;
}
public void displayDetails()
{
System.out.println(&quot;Title is &quot;+title);
System.out.println(&quot;Author is &quot;+author);
return;
}
public String getBookName()
{
return this.title;
}
}
class Library{
String libraryName;
private ArrayList&lt;Book&gt; listBooks;

public Library(String libraryName)
{
this.libraryName=libraryName;
this.listBooks=new ArrayList&lt;Book&gt;();
}
public void addBooks(Book book)
{
listBooks.add(book);return;
}
public void getBookList()
{
for(Book book:listBooks)
{
System.out.print(book.getBookName());
}
return ;
}
}
public class LibraryClass{
public static void main(String[] args)
{
Book book1=new Book(&quot;The mountain&quot;,&quot;Ashish Singh&quot;);
Library library=new Library(&quot;Maharana Pratap&quot;);
library.addBooks(book1);
library.getBookList();

}
}
