package day_3_task_3;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        boolean exit = false;

        System.out.println("=== Library Management System ===");

        while (!exit) {
            System.out.println("\n Menu:");
            System.out.println(" 1. Add Book");
            System.out.println(" 2. Register User");
            System.out.println(" 3. View Books");
            System.out.println(" 4. View Users");
            System.out.println(" 5. Issue Book");
            System.out.println(" 6. Return Book");
            System.out.println(" 7. Exit");
            System.out.print(" Enter choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print(" Enter Book Id : ");
                    int bookId = sc.nextInt();
                    sc.nextLine();
                    System.out.print(" Enter Book Title : ");
                    String title = sc.nextLine();
                    System.out.print(" Enter Book Author : ");
                    String author = sc.nextLine();
                    library.addBook(new Book(bookId, title, author));
                    break;

                case 2:
                    System.out.print(" Enter User ID : ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print(" Enter User Name : ");
                    String userName = sc.nextLine();
                    library.addUser(new User(userId, userName));
                    break;

                case 3:
                    library.viewBooks();
                    break;
                case 4:
                    library.viewUsers();
                    break;
                case 5:
                    System.out.print(" Enter Book ID to issue : ");
                    int issueId = sc.nextInt();
                    library.issueBook(issueId);
                    break;
                case 6:
                    System.out.print(" Enter Book ID to return : ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;
                case 7:
                    exit = true;
                    System.out.print(" Exiting... Thank you!");
                    break;
                default:
                    System.out.print(" Invalid choice.");
            }
        }
        sc.nextLine();
    }
}
