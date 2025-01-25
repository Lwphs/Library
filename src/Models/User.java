package Models;

public class User {

    private int id;
    private final String name;
    private final String surname;
    private final String email;
    private boolean hasRentedBook;

    public User(int id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.hasRentedBook = false;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isHasRentedBook() {
        return hasRentedBook;
    }

    public void setHasRentedBook(boolean hasRentedBook) {
        this.hasRentedBook = hasRentedBook;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User " +
                "id: " + id +
                ", name:" + name +
                ", surname: " + surname +
                ", email: " + email;
    }
}
