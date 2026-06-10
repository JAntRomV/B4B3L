package Code.Java.Abacus.v1.Refactored;

import java.util.Arrays;

/**
 * Clase para extraer la diagonal de una matriz.
 */
public class DiagonalMatriz {

    /**
     * Extrae la diagonal principal de una matriz cuadrada.
     * @param matriz Matriz cuadrada
     * @return Arreglo con los elementos de la diagonal
     */
    public static int[] extraerDiagonal(int[][] matriz) {
        if (matriz == null || matriz.length == 0) {
            throw new IllegalArgumentException("La matriz no puede estar vacía");
        }

        if (matriz.length != matriz[0].length) {
            throw new IllegalArgumentException("La matriz debe ser cuadrada");
        }

        int n = matriz.length;
        int[] diagonal = new int[n];

        for (int i = 0; i < n; i++) {
            diagonal[i] = matriz[i][i];
        }

        return diagonal;
    }

    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] diagonal = extraerDiagonal(matriz);

        System.out.print("Diagonal principal: ");
        System.out.println(Arrays.toString(diagonal));
    }
}