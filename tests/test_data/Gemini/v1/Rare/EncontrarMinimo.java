package Code.Gemini.v1.Rare;

public class EncontrarMinimo {
    public static void main(String[] args) {
        int[] numeros = {56, 23, 11, 78, 45, 9};
        int minimo = numeros[0];

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] < minimo) {
                minimo = numeros[i];
            }
        }
        System.out.println("El número más pequeño es: " + minimo);
    }
}
