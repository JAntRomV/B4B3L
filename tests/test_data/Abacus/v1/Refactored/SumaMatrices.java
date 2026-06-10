package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para sumar dos matrices.
 */
public class SumaMatrices {

    /**
     * Suma dos matrices.
     * @param matriz1 Primera matriz
     * @param matriz2 Segunda matriz
     * @return Matriz resultante de la suma
     */
    public static int[][] sumar(int[][] matriz1, int[][] matriz2) {
        if (matriz1 == null || matriz2 == null) {
            throw new IllegalArgumentException("Las matrices no pueden ser nulas");
        }

        if (matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones");
        }

        int filas = matriz1.length;
        int columnas = matriz1[0].length;
        int[][] suma = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                suma[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        return suma;
    }

    public static void main(String[] args) {
        int[][] matriz1 = {{1, 2}, {3, 4}};
        int[][] matriz2 = {{5, 6}, {7, 8}};

        int[][] suma = sumar(matriz1, matriz2);

        System.out.println("Suma de matrices:");
        for (int[] fila : suma) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }
}