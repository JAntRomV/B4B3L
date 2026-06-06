package Code.ChatGPT.v3.Rare;

public class Programa086 {
    public static void main(String[] args) {
        int[] a = new int[]{6, 12, 18, 4, 10};
        int min = a[0], max = a[0];
        for (int v : a) {
            if (v < min) min = v;
            if (v > max) max = v;
        }
        System.out.println("Min=" + min + ", Max=" + max);
    }
}
