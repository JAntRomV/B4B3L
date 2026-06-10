package Code.Java.Abacus.v1.Rare;

public class CalculoPropina {
    public static void main(String[] args) {
        double cuenta = 150;
        double porcentajePropina = 10;
        double propina = cuenta * porcentajePropina / 100;
        double total = cuenta + propina;
        System.out.println("Total a pagar: " + total);
    }
}