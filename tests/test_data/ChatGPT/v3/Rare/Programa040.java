package Code.ChatGPT.v3.Rare;

public class Programa040 {
    public static void main(String[] args) {
        int[] a = new int[]{30, 33, 36, 39, 42, 45};
        for (int i1 = 0; i1 < a.length-1; i1++) {
            for (int j = 0; j < a.length-1-i1; j++) {
                if (a[j] > a[j+1]) {
                    int tmp = a[j]; a[j] = a[j+1]; a[j+1] = tmp;
                }
            }
        }
        System.out.print("Ordenado: ");
        for (int v : a) System.out.print(v + " ");
        System.out.println();
    }
}
