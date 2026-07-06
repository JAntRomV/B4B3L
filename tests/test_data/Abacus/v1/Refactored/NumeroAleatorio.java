package Code.Java.Abacus.v1.Refactored;

import java.util.Random;

/**
 * Clase para generar números aleatorios.
 */
public class NumeroAleatorio {

    private static final Random random = new Random();

    /**
     * Genera un número aleatorio en un rango específico.
     * @param min Valor mínimo (inclusivo)
     * @param max Valor máximo (inclusivo)
     * @return Número aleatorio en el rango [min, max]
     */
    public static int generar(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("El mínimo no puede ser mayor que el máximo");
        }

        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Genera un número aleatorio decimal en un rango.
     * @param min Valor mínimo
     * @param max Valor máximo
     * @return Número aleatorio decimal en el rango [min, max)
     */
    public static double generarDecimal(double min, double max) {
        if (min > max) {
            throw new IllegalArgumentException("El mínimo no puede ser mayor que el máximo");
        }

        return min + (max - min) * random.nextDouble();
    }

    public static void main(String[] args) {
        int min = 1, max = 100;
        int aleatorio = generar(min, max);

        System.out.println(String.format("Número aleatorio entre %d y %d: %d", min, max, aleatorio));
    }
}