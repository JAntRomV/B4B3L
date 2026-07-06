package Code.Java.Abacus.v1.Refactored;

import java.util.Arrays;

/**
 * Clase para ordenar un array.
 */
public class OrdenarArray {

    /**
     * Ordena un array de forma ascendente (crea una copia).
     * @param numeros Arreglo original
     * @return Arreglo ordenado
     */
    public static int[] ordenar(int[] numeros) {
        if (numeros == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo");
        }

        int[] copia = Arrays.copyOf(numeros, numeros.length);
        Arrays.sort(copia);
        return copia;
    }

    public static void main(String[] args) {
        int[] numeros = {5, 2, 8, 1, 9};
        int[] ordenado = ordenar(numeros);

        System.out.print("Array ordenado: ");
        System.out.println(Arrays.toString(ordenado));
    }
}