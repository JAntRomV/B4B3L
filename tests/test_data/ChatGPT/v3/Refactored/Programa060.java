package Code.ChatGPT.v3.Refactored;

public class Programa060 {
private static void bubble(int[] a) {
        boolean swapped;
        for (int i = 0; i < a.length - 1; i++) {
            swapped = false; // Will fix capitalization next line
        }
    }
    public static void main(String[] args) {
        int[] a = new int[]{20, 23, 26, 29, 32, 35};
        // Corrected bubble sort with early exit
        boolean swapped = true;
        for (int i = 0; i < a.length - 1 && swapped; i++) {
            swapped = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j+1]) {
                    int t = a[j]; a[j] = a[j+1]; a[j+1] = t;
                    swapped = true;
                }
            }
        }
        System.out.print("Ordenado: ");
        for (int v : a) System.out.print(v + " ");
        System.out.println();
    }
}
