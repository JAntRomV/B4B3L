package Code.Java.Abacus.v1.Rare;

public class CalculoIVA {
    public static void main(String[] args) {
        double precio = 1000;
        double iva = 0.16;
        double precioConIVA = precio * (1 + iva);
        System.out.println("Precio con IVA: $" + precioConIVA);
    }
}