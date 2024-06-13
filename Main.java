package librarymanagementsystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("Java Programming", "James Gosling"));
        library.addBook(new Book("Python", "Mark"));
        library.addBook(new Book("C#", "Elon"));
        library.addBook(new Book("Java Script", "Musk"));
        library.addBook(new Book("C Programming", "Zuck"));

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add Books to the library");
            System.out.println("2. Remove Books from library");
            System.out.println("3. Add Membership");
            System.out.println("4. Close Membership");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.println("Enter your choice");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    Book book;
                    System.out.println("Enter Book Title to add");
                    String title = sc.nextLine();
                    System.out.println("Enter Authour Name of the book");
                    String author = sc.nextLine();
                    book = new Book(title, author);
                    library.addBook(book);
                    break;
                case 2:
                    Book book1;
                    library.displayAllBooks();
                    System.out.println("Enter the book Id to remove");
                    int bookId = sc.nextInt();
                    sc.nextLine();
                    book1 = library.findBook(bookId);
                    if (book1 != null){
                        library.removeBook(book1);
                        System.out.println("Book removed");
                        break;
                    }else {
                        System.out.println("You are Entered Wrong Book Id");
                    }
                    break;

                case 3 :
                    Member member;
                    System.out.println("Enter a name");
                    String memberName = sc.nextLine();
                    member = new Member(memberName);
                    library.addMember(member);
                    break;

                case 4 :
                    Member member1;
                    System.out.println("Enter a member Id");
                    int memId = sc.nextInt();
                    sc.nextLine();
                    member1 = library.findMember(memId);
                    if (member1 != null){
                        library.removeMember(member1);
                        break;
                    }else {
                        System.out.println("Member Not Exist");
                    }
                    break;

                case 5 :
                    System.out.println("Enter a Member Id");
                    int memberId = sc.nextInt();
                    sc.nextLine();
                    Member borrower = library.findMember(memberId);
                    if (borrower != null){
                        System.out.println("Enter a book Tittle for borrow");
                        String tittle = sc.nextLine();
                        Book book2 = library.findBook(tittle);
                        if (book2 != null) {
                            borrower.borrowBook(book2);
                        }else {
                            System.out.println("Your Book Tittle did not matched ! Please enter valid Tittle");
                        }
                        break;
                    }else {
                        System.out.println("You are not a Member of the library");
                    }
                    break;

                case 6 :
                    System.out.println("Enter Member Id");
                    int memberId2 = sc.nextInt();
                    sc.nextLine();
                    Member returner = library.findMember(memberId2);

                    if (returner != null){
                        System.out.println("Enter book Title to return");
                        String returnBookName = sc.nextLine();
                        Book returnedBook = library.findBook(returnBookName);
                        if (returnedBook != null){
                            returner.returnBook(returnedBook);
                        }else {
                            System.out.println("Your Book Tittle did not matched ! Please enter valid Tittle");
                        }
                        break;
                    }else {
                        System.out.println("You are not a Member of the library");
                    }
                    break;

                case 7 :
                    System.out.println("Exited Good Bye !!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } while (true);
    }
}
