package Code.Java.Abacus.v1.Refactored;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Clase para redondear números con diferentes métodos.
 */
public class RedondeoNumero {

    /**
     * Redondea un número al entero más cercano.
     * @param numero Número a redondear
     * @return Número redondeado
     */
    public static long redondear(double numero) {
        return Math.round(numero);
    }

    /**
     * Redondea un número a una cantidad específica de decimales.
     * @param numero Número a redondear
     * @param decimales Cantidad de decimales
     * @return Número redondeado
     */
    public static double redondearDecimales(double numero, int decimales) {
        if (decimales < 0) {
            throw new IllegalArgumentException("Los decimales no pueden ser negativos");
        }

        BigDecimal bd = new BigDecimal(Double.toString(numero));
        bd = bd.setScale(decimales, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     * Redondea hacia arriba.
     * @param numero Número a redondear
     * @return Número redondeado hacia arriba
     */
    public static double redondearArriba(double numero) {
        return Math.ceil(numero);
    }

    /**
     * Redondea hacia abajo.
     * @param numero Número a redondear
     * @return Número redondeado hacia abajo
     */
    public static double redondearAbajo(double numero) {
        return Math.floor(numero);
    }

    public static void main(String[] args) {
        double numero = 3.14159;

        System.out.println(String.format("Número original: %.5f", numero));
        System.out.println(String.format("Redondeado: %d", redondear(numero)));
        System.out.println(String.format("Dos decimales: %.2f", redondearDecimales(numero, 2)));
        System.out.println(String.format("Hacia arriba: %.0f", redondearArriba(numero)));
        System.out.println(String.format("Hacia abajo: %.0f", redondearAbajo(numero)));
    }
}