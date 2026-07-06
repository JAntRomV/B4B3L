package Code.Java.Abacus.v1.Rare;

public class DiagonalMatriz {
    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.print("Diagonal principal: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(matriz[i][i] + " ");
        }
    }
}