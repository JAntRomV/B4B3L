package Code.Java.Abacus.v1.Rare;

public class SumaMatrices {
    public static void main(String[] args) {
        int[][] matriz1 = {{1, 2}, {3, 4}};
        int[][] matriz2 = {{5, 6}, {7, 8}};
        int[][] suma = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                suma[i][j] = matriz1[i][j] + matriz2[i][j];
                System.out.print(suma[i][j] + " ");
            }
            System.out.println();
        }
    }
}