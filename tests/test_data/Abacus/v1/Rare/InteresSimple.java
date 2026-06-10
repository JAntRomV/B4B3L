package Code.Java.Abacus.v1.Rare;

public class InteresSimple {
    public static void main(String[] args) {
        double capital = 1000;
        double tasa = 5; // porcentaje
        double tiempo = 2; // años
        double interes = (capital * tasa * tiempo) / 100;
        System.out.println("Interés simple: " + interes);
    }
}