package Models;

public class Book {
    private final int id;
    private final String title;
    private final String author;
    private boolean booked;

    public Book(int id,  String title, String author, boolean booked) {
        this.booked = booked;
        this.author = author;
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBooked() {
        return booked;
    }

    public int getId() {
        return id;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    @Override
    public String toString() {
        return "Book" +
                " id: " + id +
                ", author: " + author +
                ", title: " + title +
                ", rented: " + booked;
    }
}
