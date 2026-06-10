package Code.Gemini.v1.Rare;

public class SumaArray {
    public static void main(String[] args) {
        int[] valores = {10, 20, 30, 40, 50};
        int sumaTotal = 0;

        for (int valor : valores) {
            sumaTotal += valor;
        }

        System.out.println("La suma de los elementos del array es: " + sumaTotal);
    }
}
