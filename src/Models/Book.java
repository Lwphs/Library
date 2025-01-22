package Models;

public class Book {
    private int id;
    private final String title;
    private final String author;

    private boolean booked = false;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    @Override
    public String toString() {
        return "Llibre{" +
                "llogat=" + booked +
                ", autor='" + author + '\'' +
                ", id=" + id +
                ", titol='" + title + '\'' +
                '}';
    }
}
