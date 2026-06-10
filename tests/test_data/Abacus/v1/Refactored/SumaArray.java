package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular la suma de elementos de un array.
 */
public class SumaArray {

    /**
     * Calcula la suma de todos los elementos de un array.
     * @param numeros Arreglo de números
     * @return La suma de los elementos
     */
    public static int calcular(int[] numeros) {
        if (numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }

        int suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        return suma;
    }

    public static void main(String[] args) {
        int[] numeros = {5, 10, 15, 20, 25};
        int suma = calcular(numeros);

        System.out.println("Suma del array: " + suma);
    }
}