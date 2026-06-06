package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular el promedio de elementos de un array.
 */
public class PromedioArray {

    /**
     * Calcula el promedio de todos los elementos de un array.
     * @param numeros Arreglo de números
     * @return El promedio de los elementos
     */
    public static double calcular(double[] numeros) {
        if (numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }

        double suma = 0;
        for (double num : numeros) {
            suma += num;
        }
        return suma / numeros.length;
    }

    public static void main(String[] args) {
        double[] numeros = {5.5, 10.2, 15.8, 20.1};
        double promedio = calcular(numeros);

        System.out.println(String.format("Promedio: %.2f", promedio));
    }
}