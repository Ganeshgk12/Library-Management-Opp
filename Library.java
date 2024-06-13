package librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Library {

    List<Book> books;
    List<Member> members;

    public Library (){
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    private List<Book> getBooks (){
        return books;
    }

    private List<Member> getMembers() {
        return members;
    }

    public void addBook(Book book){
        if (findBook(book.getBookId()) == null){
            books.add(book);
            System.out.println("Book added");
        }else {
            System.out.println("Book already Exist");
        }
    }

    public void removeBook (Book book){
        books.remove(book);
    }

    public void addMember (Member member){
        if (findMember(member.getId()) == null){
            members.add(member);
            System.out.println("Member " + member.getName() + " Added");
        }else {
            System.out.println("The Member " + member.getName() + " Already Exist");
        }
    }

    public void removeMember (Member member){
        if (! member.getMemberBorrowedBook().isEmpty()){
            System.out.println("The member should return borrowed books");
            member.displayBorrowedBooks(member);
        } else {
            members.remove(member);
            System.out.println("Member " + member.getName() + " removed");
        }
    }

     Member findMember (int id) {
        for (Member member : members){
            if (member.getId() == id){
                return member;
            }
        }
        return null;
    }

    Book findBook (int bookId) {
        for (Book book : books){
            if (book.getBookId() == bookId){
                return book;
            }
        }
        return null;
    }

    Book findBook (String tittle) {
        for (Book book : books) {
            if (book.getTitle().equals(tittle)) {
                return book;
            }
        }
        return null;
    }

    public void displayAllBooks (){
        List<Book> bookList = getBooks();
        System.out.println("               Available Books          ");
        for (Book book : bookList){
            System.out.println("1. Title " + book.getTitle() + " ," + " Author " + book.getAuthor() + " Book Id " + book.getBookId());
            System.out.println();
        }
    }

    public void displayAllMembers () {
        List<Member> memberList = getMembers();
        System.out.println("           Members List       ");
        for (Member member : memberList){
            System.out.println("1." + member.getId() + " " + member.getName());
            System.out.println();
        }
    }
}
