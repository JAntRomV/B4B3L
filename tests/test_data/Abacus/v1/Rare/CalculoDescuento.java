package Code.Java.Abacus.v1.Rare;

public class CalculoDescuento {
    public static void main(String[] args) {
        double precioOriginal = 500;
        double descuento = 20; // porcentaje
        double precioFinal = precioOriginal - (precioOriginal * descuento / 100);
        System.out.println("Precio con descuento: " + precioFinal);
    }
}