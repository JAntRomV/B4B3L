package Code.ChatGPT.v3.Rare;

public class Programa096 {
    public static void main(String[] args) {
        int[] a = new int[]{16, 12, 8, 4, 0};
        int min = a[0], max = a[0];
        for (int v : a) {
            if (v < min) min = v;
            if (v > max) max = v;
        }
        System.out.println("Min=" + min + ", Max=" + max);
    }
}
