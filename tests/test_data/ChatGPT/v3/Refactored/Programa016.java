package Code.ChatGPT.v3.Refactored;

public class Programa016 {
private static int[] minMax(int[] a) {
        if (a.length == 0) return new int[]{0,0};
        int min = a[0], max = a[0];
        for (int v : a) { if (v < min) min = v; if (v > max) max = v; }
        return new int[]{min, max};
    }
    public static void main(String[] args) {
        int[] datos = new int[]{16, 12, 8, 4, 0};
        int[] mm = minMax(datos);
        System.out.println("Min=" + mm[0] + ", Max=" + mm[1]);
    }
}
