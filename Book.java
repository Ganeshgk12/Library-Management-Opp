package librarymanagementsystem;

public class Book {
    private String title;
    private String author;
    private int bookId;
    private static int bookRefId = 1;
    private boolean available;

    public Book(String title,String author) {
        this.title = title;
        this.author = author;
        this.bookId = bookRefId++;
        this.available = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor() {
        return author;
    }



    public void checkOut(){
        if (isAvailable()){
            available = false;
            System.out.println("Book checked out");
        }else {
            System.out.println("Book un available");
        }
    }
    public void returningBook (){
        available = true;
        System.out.println("Book returned");
    }

    public boolean isAvailable() {
        return available;
    }


}
