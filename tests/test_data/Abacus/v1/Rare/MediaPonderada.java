package Code.Java.Abacus.v1.Rare;

public class MediaPonderada {
    public static void main(String[] args) {
        double[] valores = {8, 9, 7};
        double[] pesos = {0.3, 0.5, 0.2};
        double suma = 0;
        for (int i = 0; i < valores.length; i++) {
            suma += valores[i] * pesos[i];
        }
        System.out.println("Media ponderada: " + suma);
    }
}