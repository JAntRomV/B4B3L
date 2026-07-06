package Code.Java.Abacus.v1.Refactored;

import java.util.Arrays;

/**
 * Clase para multiplicar elementos de un array por un factor.
 */
public class MultiplicarArray {

    /**
     * Multiplica cada elemento del array por un factor.
     * @param numeros Arreglo original
     * @param factor Factor de multiplicación
     * @return Nuevo arreglo con elementos multiplicados
     */
    public static int[] multiplicar(int[] numeros, int factor) {
        if (numeros == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo");
        }

        int[] resultado = new int[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            resultado[i] = numeros[i] * factor;
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] numeros = {2, 4, 6, 8, 10};
        int factor = 3;
        int[] resultado = multiplicar(numeros, factor);

        System.out.print("Array multiplicado: ");
        System.out.println(Arrays.toString(resultado));
    }
}