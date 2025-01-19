package Models;

public class Llibre {

    int id;
    String titol;
    String autor;
    double pes;

    boolean llogat = false;

    public Llibre(int id, String nom, String autor, double pes, boolean llogat) {
        this.id = id;
        this.titol = titol;
        this.autor = autor;
        this.pes = pes;
    }

    public int getId() {
        return id;
    }

    public String getTitol() {
        return titol;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isLlogat() {
        return llogat;
    }

    public void setLlogat() {
        this.llogat = llogat;
    }

    public String toString() {
        return "ID:" + id + ", Títol:" + titol + ", Autor:" + autor + ", Pes:" + pes;
    }
}
