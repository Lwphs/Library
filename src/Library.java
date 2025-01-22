import Models.Book;
import Models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    static final Scanner INPUT = new Scanner(System.in);
    private static final ArrayList<Book> BOOKS = new ArrayList<>();
    private static final ArrayList<User> USERS = new ArrayList<>();

    static int id = 1;

    public static void main(String[] args) {

        int opcio;

        do {
            System.out.println("\n*** WELCOME TO THE LIBRARY ***");
            System.out.println("1. Show Books");
            System.out.println("2. Show Users");
            System.out.println("3. Add Book");
            System.out.println("4. Rent Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Option: ");
            opcio = INPUT.nextInt();

            INPUT.nextLine();

            switch (opcio) {
                case 1:
                    showBooks();
                    break;
                case 2:
                    showUsers();
                    break;
                case 3:
                    addBooks();
                    break;
                case 4:
                    rentBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Not a valid option.");
            }
        } while (opcio != 6);
    }

    private static void showUsers() {
        for (int i = 0; i < USERS.size(); i++) {
            System.out.println(USERS.get(i));
        }
    }

    private static void showBooks() {
        for (int i = 0; i < BOOKS.size(); i++) {
            System.out.println(BOOKS.get(i));
        }
    }

    private static void rentBook() {
        System.out.println("Select a book:");
        for (int i = 0; i < BOOKS.size(); i++) {
            System.out.println((i + 1) + ".- " + BOOKS.get(i));
        }
    }

    private static void addBooks() {

        System.out.print("Enter book's name: ");
        String title = INPUT.nextLine();

        System.out.print("Enter author's name: ");
        String author = INPUT.nextLine();

        BOOKS.add(new Book(id, title, author));

        id++;

        System.out.println("Bookio addio");
    }

    private static void returnBook() {
    }
}