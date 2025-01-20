package Models;

public class Llibre {
    private int id;
    private String titol;
    private String autor;
    private double pes;

    boolean llogat = false;

    public Llibre(int id, String titol, String autor, double pes, boolean llogat) {
        this.id = id;
        this.titol = titol;
        this.autor = autor;
        this.pes = pes;
    }

    /**
     *
     * @return haha
     */
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

    public double getPes() {
        return pes;
    }

    public void setLlogat(boolean llogat) {
        this.llogat = llogat;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Llibre{" +
                "llogat=" + llogat +
                ", autor='" + autor + '\'' +
                ", pes=" + pes +
                ", id=" + id +
                ", titol='" + titol + '\'' +
                '}';
    }
}
