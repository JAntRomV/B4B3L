package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para encontrar el máximo de un array.
 */
public class MaximoArray {

    /**
     * Encuentra el valor máximo en un array.
     * @param numeros Arreglo de números
     * @return El valor máximo
     */
    public static int encontrar(int[] numeros) {
        if (numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }

        int max = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > max) {
                max = numeros[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numeros = {5, 10, 3, 20, 15};
        int max = encontrar(numeros);

        System.out.println("Máximo: " + max);
    }
}