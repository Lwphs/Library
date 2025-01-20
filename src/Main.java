import Models.Llibre;

public class Main {
    public static void main(String[] args) {

        Llibre pene = new Llibre(1, "Hola", "Paulo Coelho", 2.13, false);
        int a = pene.getId();

        String b = pene.getTitol();
        pene.setLlogat(true);

        System.out.println(pene.toString() );
    }
}