package librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String name;
    private int id;
    private static int memRefId = 1;
    List<Book> memberBorrowedBook;

    public Member(String name) {
        this.name = name;
        this.memberBorrowedBook = new ArrayList<>();
        this.id = memRefId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getMemberBorrowedBook() {
        return memberBorrowedBook;
    }

    public void borrowBook(Book book){

        if (book.isAvailable()){
            memberBorrowedBook.add(book);
            book.checkOut();
            System.out.println("Book Borrowed");
        }else {
            System.out.println("Book not available");
        }
    }

    public void returnBook(Book book){
        if (memberBorrowedBook.contains(book)){
            memberBorrowedBook.remove(book);
            book.returningBook();
        }else {
            System.out.println("You did not borrowed this book from here");
        }
    }

    public void displayBorrowedBooks (Member member){
        List<Book> bookList = member.getMemberBorrowedBook();
        if (bookList.isEmpty()) {
            System.out.println("No books borrowed");
        }else {
            for (Book book : bookList){
                System.out.println("Title : " + book.getTitle() + " " + "Author : " + book.getAuthor());
                System.out.println();
            }
        }
    }
}
