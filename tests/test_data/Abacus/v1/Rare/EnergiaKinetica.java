package Code.Java.Abacus.v1.Rare;

public class EnergiaKinetica {
    public static void main(String[] args) {
        double masa = 10; // kg
        double velocidad = 5; // m/s
        double energia = 0.5 * masa * velocidad * velocidad;
        System.out.println("Energía cinética: " + energia + " J");
    }
}