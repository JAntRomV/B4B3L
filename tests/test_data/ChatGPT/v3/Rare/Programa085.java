package Code.ChatGPT.v3.Rare;

public class Programa085 {
    public static void main(String[] args) {
        int[] datos = new int[]{6, 10, 4, 8};
        int suma = 0;
        for (int x : datos) suma += x;
        double prom = (double) suma / datos.length;
        System.out.println("Promedio = " + prom);
    }
}
