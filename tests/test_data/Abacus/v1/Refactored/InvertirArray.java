package Code.Java.Abacus.v1.Refactored;

import java.util.Arrays;

/**
 * Clase para invertir un array.
 */
public class InvertirArray {

    /**
     * Invierte un array (crea una copia invertida).
     * @param numeros Arreglo original
     * @return Arreglo invertido
     */
    public static int[] invertir(int[] numeros) {
        if (numeros == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo");
        }

        int[] invertido = new int[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            invertido[i] = numeros[numeros.length - 1 - i];
        }
        return invertido;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        int[] invertido = invertir(numeros);

        System.out.print("Array invertido: ");
        System.out.println(Arrays.toString(invertido));
    }
}