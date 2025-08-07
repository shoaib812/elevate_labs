package day_3_task_3;

import java.util.ArrayList;

public class Library {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User registered successfully!");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void viewUsers() {
        if(users.isEmpty()) {
            System.out.println("No registered users.");
            return;
        }
        for (User u : users) {
            System.out.println(u);
        }
    }

    public void issueBook(int bookId) {
        for(Book b : books) {
            if(b.getId() == bookId) {
                if (b.isAvailable()) {
                    b.setAvailable(false);
                    System.out.println("Book issued successfully!");
                }
                else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(int bookId) {
        for (Book b : books) {
            if (b.getId() == bookId) {
                if (!b.isAvailable()) {
                    b.setAvailable(true);
                    System.out.println("Book returned successfully!");
                }
                else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}