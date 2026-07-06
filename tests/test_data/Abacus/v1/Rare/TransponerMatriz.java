package Code.Java.Abacus.v1.Rare;

public class TransponerMatriz {
    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}};
        int[][] transpuesta = new int[3][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }
        System.out.println("Matriz transpuesta:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(transpuesta[i][j] + " ");
            }
            System.out.println();
        }
    }
}