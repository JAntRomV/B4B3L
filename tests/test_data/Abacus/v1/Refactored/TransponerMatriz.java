package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para transponer una matriz.
 */
public class TransponerMatriz {

    /**
     * Transpone una matriz.
     * @param matriz Matriz original
     * @return Matriz transpuesta
     */
    public static int[][] transponer(int[][] matriz) {
        if (matriz == null || matriz.length == 0) {
            throw new IllegalArgumentException("La matriz no puede estar vacía");
        }

        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] transpuesta = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }

        return transpuesta;
    }

    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}};
        int[][] transpuesta = transponer(matriz);

        System.out.println("Matriz transpuesta:");
        for (int[] fila : transpuesta) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }
}