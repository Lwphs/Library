import Models.Book;
import Models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    static final Scanner INPUT = new Scanner(System.in);
    private static final ArrayList<Book> books = new ArrayList<>();
    private static final ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        initializingBooksAndUsers();
        int option;

        do {
            System.out.println("\n *** WELCOME TO THE LIBRARY ***");
            System.out.println("1. Show Books");
            System.out.println("2. Add Book");
            System.out.println("3. Rent Book");
            System.out.println("4. Return Book");
            System.out.println("5. Add User");
            System.out.println("6. Show Users");
            System.out.println("7. Delete User");
            System.out.println("8. Exit");
            System.out.print("Option: ");
            option = readInteger(1, 8);

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
                    addUser();
                    break;
                case 6:
                    showUsers("These are the current users.");
                    break;
                case 7:
                    deleteUser();
                    break;
                case 8:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Not a valid option.");
            }
        } while (option != 8);
    }

    private static void initializingBooksAndUsers() {
        books.add(new Book(1, "Book 1", "Author 1", false));
        books.add(new Book(2, "Book 2", "Author 2", false));
        books.add(new Book(3, "Book 3", "Author 3", false));
        books.add(new Book(4, "Book 4", "Author 4", false));

        users.add(new User(1, "Arnau", "Garcia", "Arnau@gmail.com"));
        users.add(new User(2, "Marcel", "Feliu", "Marcel@gmail.com"));
        users.add(new User(3, "Marcel", "Roquet", "MarcelR@gmail.com"));
        users.add(new User(4, "Pau", "Solé", "Pau@gmail.com"));
    }

    private static void showBooks() {
        for (int i = 0; i < books.size(); i++)
            System.out.println(books.get(i));
    }

    private static void addBooks() {
        System.out.print("Enter book's name: ");
        String title = INPUT.nextLine();

        System.out.print("Enter author's name: ");
        String author = INPUT.nextLine();

        books.add(new Book(books.getLast().getId() + 1, title, author, false));
        System.out.println("Book added successfully!");
    }

    private static void rentBook() {
        int userId, bookId;
        boolean userHasNotRented, validId;

        showUsers("Who wants to rent the book?");

        do {
            System.out.print("Enter the id of the user: ");
            userId = readInteger(1, users.size());
            validId = checkIntroducedUserId(userId);
            userHasNotRented = checkIfUserHasRentedBookAlready(userId);
        } while (!userHasNotRented || !validId);

        showBooks();

        do {
            System.out.print("Enter the id of the book: ");
            bookId = readInteger(1, books.size());
            validId = checkIntroducedBookId(bookId);
            userHasNotRented = checkIfBooksIsNotRentedAlready(bookId);
        } while (!validId || !userHasNotRented);

        books.get(bookId - 1).setBooked(true);
        System.out.println(users.get(userId - 1).getName() + " rented " + books.get(bookId - 1).getTitle());
    }

    private static boolean checkIfBooksIsNotRentedAlready(int id) {
        if (books.get(id - 1).isBooked()) {
            System.out.println("That book is already rented!.");
            return false;
        } else {
            books.get(id - 1).setBooked(true);
            return true;
        }
    }

    private static boolean checkIfUserHasRentedBookAlready(int id) {
        if (users.get(id - 1).isHasRentedBook()) {
            System.out.println("This user already has a rented book.");
            return false;
        }
        else {
            users.get(id - 1).setHasRentedBook(true);
            return true;
        }
    }

    private static boolean checkIntroducedBookId(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                return true;
            }
        }

        System.out.println("Book not found.");
        return false;
    }

    private static boolean checkIntroducedUserId(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                return true;
            }
        }

        System.out.println("User not found.");
        return false;
    }

    private static void returnBook() {
        int userId, bookId;
        boolean valid;

        showUsersThatRented();

        do {
            System.out.print("Enter the id of the user: ");
            userId = readInteger(1, users.size());
            valid = checkIntroducedUserId(userId);
        } while (!valid);

        showRentedBooks();

        do {
            System.out.print("Enter the id of the book: ");
            bookId = readInteger(1, books.size());
            valid = checkIntroducedBookId(bookId);
            if (!books.get(bookId - 1).isBooked()) {
                System.out.println("The book is not rented.");
                valid = false;
            }
        } while (!valid);

        books.get(bookId).setBooked(false);
        System.out.println(users.get(userId - 1).getName() + " returned " + books.get(bookId - 1).getTitle());
    }

    private static void showUsersThatRented() {
        System.out.println("Who wants to return a book?");
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).isHasRentedBook())
                System.out.println(users.get(i));
        }
    }

    private static void showRentedBooks() {
        System.out.println("Select a book you want to return: ");
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isBooked())
                System.out.println(books.get(i));
        }
    }

    private static void addUser() {
        System.out.print("Please enter your name: ");
        String name = INPUT.nextLine();

        System.out.print("Please enter your surname: ");
        String surname = INPUT.nextLine();

        System.out.print("Please enter your email: ");
        String email = INPUT.nextLine();

        users.add(new User(users.getLast().getId() + 1, name, surname, email));
        System.out.println("User added successfully!");
    }

    private static void showUsers(String message) {
        System.out.println(message);

        for (int i = 0; i < users.size(); i++)
            System.out.println(users.get(i));
    }

    private static void deleteUser() {
        int userId;
        boolean validUser;
        User userToDelete;

        showUsers("Select the user you want to delete.");

        do {
            System.out.print("Enter the id of the user: ");
            userId = readInteger(1, users.size());
            validUser = checkIntroducedUserId(userId);
        } while (!validUser);

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == userId) {
                userToDelete = users.get(i);
                System.out.println(userToDelete.getName() + " has been deleted.");
                users.remove(i);
                break;
            }
        }

        updateUserIds();
    }

    private static void updateUserIds() {
        for (int i = 0; i < users.size(); i++) {
            users.get(i).setId(i + 1);
        }
    }

    private static int readInteger(int min, int max) {
        int x = 0;
        boolean correctValue = false;

        do {
            if (INPUT.hasNextInt()) {
                x = INPUT.nextInt();
                INPUT.nextLine();

                if (x < min || x > max)
                    System.out.println("Not a valid option, choose between " + min + " and " + max);
                else
                    correctValue = true;
            } else {
                System.out.println("ERROR: Not an Integer");
                INPUT.nextLine();
            }
        } while (!correctValue);

        return x;
    }
}