package Code.ChatGPT.v3.Refactored;

public class Programa005 {
private static double promedio(int[] a) {
        long s = 0;
        for (int v : a) s += v;
        return a.length == 0 ? 0.0 : (double) s / a.length;
    }
    public static void main(String[] args) {
        int[] datos = new int[]{6, 10, 4, 8};
        System.out.println("Promedio = " + promedio(datos));
    }
}
