package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular el IVA y precio final.
 */
public class CalculoIVA {

    private static final double IVA_MEXICO = 0.16;

    /**
     * Calcula el precio con IVA incluido.
     * @param precioBase Precio base sin IVA
     * @param tasaIVA Tasa de IVA (decimal, ej: 0.16 para 16%)
     * @return Precio con IVA
     */
    public static double calcularPrecioConIVA(double precioBase, double tasaIVA) {
        if (precioBase < 0 || tasaIVA < 0) {
            throw new IllegalArgumentException("Los valores no pueden ser negativos");
        }

        return precioBase * (1 + tasaIVA);
    }

    /**
     * Calcula solo el monto del IVA.
     * @param precioBase Precio base sin IVA
     * @param tasaIVA Tasa de IVA
     * @return Monto del IVA
     */
    public static double calcularMontoIVA(double precioBase, double tasaIVA) {
        return precioBase * tasaIVA;
    }

    public static void main(String[] args) {
        double precio = 1000;
        double precioConIVA = calcularPrecioConIVA(precio, IVA_MEXICO);
        double montoIVA = calcularMontoIVA(precio, IVA_MEXICO);

        System.out.println(String.format("Precio base: $%.2f", precio));
        System.out.println(String.format("IVA (16%%): $%.2f", montoIVA));
        System.out.println(String.format("Precio con IVA: $%.2f", precioConIVA));
    }
}