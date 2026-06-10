package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para encontrar el mínimo de un array.
 */
public class MinimoArray {

    /**
     * Encuentra el valor mínimo en un array.
     * @param numeros Arreglo de números
     * @return El valor mínimo
     */
    public static int encontrar(int[] numeros) {
        if (numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }

        int min = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] < min) {
                min = numeros[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] numeros = {5, 10, 3, 20, 15};
        int min = encontrar(numeros);

        System.out.println("Mínimo: " + min);
    }
}