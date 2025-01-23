import Models.Book;
import Models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    static final Scanner INPUT = new Scanner(System.in);
    private static final ArrayList<Book> BOOKS = new ArrayList<>();
    private static final ArrayList<User> USERS = new ArrayList<>();

    static int idBook = 1;
    static int idUser = 1;


    public static void main(String[] args) {

        initializingBooksAndUsers();

        int option;

        do {
            System.out.println("*** WELCOME TO THE LIBRARY ***");
            System.out.println("1. Show Books");
            System.out.println("2. Add Book");
            System.out.println("3. Rent Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Option: ");
            option = INPUT.nextInt();

            INPUT.nextLine();

            switch (option) {
                case 1:
                    showBooks();
                    break;
                case 2:
                    addBooks();
                    break;
                case 3:
                    rentBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Not a valid option.");
            }
        } while (option != 5);
    }

    private static void initializingBooksAndUsers() {
        BOOKS.add(new Book(idBook++, "Book 1", "Author 1", false));
        BOOKS.add(new Book(idBook++, "Book 2", "Author 2", false));
        BOOKS.add(new Book(idBook++, "Book 3", "Author 3", false));
        BOOKS.add(new Book(idBook++, "Book 4", "Author 4", false));

        USERS.add(new User(idUser++, "Arnau", "Garcia", "Arnau@gmail.com"));
        USERS.add(new User(idUser++, "Marcel", "Feliu", "Marcel@gmail.com"));
        USERS.add(new User(idUser++, "Marcel", "Roquet", "MarcelR@gmail.com"));
        USERS.add(new User(idUser++, "Pau", "Solé", "Pau@gmail.com"));
    }

    private static void showBooks() {
        for (int i = 0; i < BOOKS.size(); i++) {
            System.out.println(BOOKS.get(i));
        }
    }

    private static void rentBook() {
        System.out.print("Who wants to rent? ");
        String name = INPUT.nextLine();

        showBooks();

        String title = INPUT.nextLine();
        for (int i = 0; i < BOOKS.size(); i++) {
            if (BOOKS.get(i).getTitle().equals(title)) {
                BOOKS.get(i).setBooked(true);

                System.out.println(name + " rented " + BOOKS.get(i).getTitle());
            }
        }
    }

    private static void returnBook() {
        System.out.print("Who is returning? ");
        String name = INPUT.nextLine();

        System.out.println("Select a book you want to return: ");

        showBooks();

        String title = INPUT.nextLine();
        for (int i = 0; i < BOOKS.size(); i++) {
            if (BOOKS.get(i).getTitle().equals(title)) {
                BOOKS.get(i).setBooked(false);

                System.out.println(name + " returned " + BOOKS.get(i).getTitle());
            }
        }
    }

    private static void addBooks() {
        System.out.print("Enter book's name: ");
        String title = INPUT.nextLine();

        System.out.print("Enter author's name: ");
        String author = INPUT.nextLine();

        BOOKS.add(new Book(idBook++, title, author, false));

        System.out.println("Bookio addio");
    }
}