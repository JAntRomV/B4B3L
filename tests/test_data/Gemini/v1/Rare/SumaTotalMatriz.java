package Code.Gemini.v1.Rare;

public class SumaTotalMatriz {
    public static void main(String[] args) {
        int[][] matriz = {{5, 10, 15}, {20, 25, 30}, {35, 40, 45}};
        int suma = 0;

        for (int[] fila : matriz) {
            for (int valor : fila) {
                suma += valor;
            }
        }
        System.out.println("La suma de todos los elementos de la matriz es: " + suma);
    }
}
