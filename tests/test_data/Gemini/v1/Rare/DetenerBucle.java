package Code.Gemini.v1.Rare;

public class DetenerBucle {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, -1, 40, 50};

        System.out.println("Buscando el número negativo...");
        for (int numero : numeros) {
            if (numero < 0) {
                System.out.println("Número negativo encontrado. Deteniendo el bucle.");
                break;
            }
            System.out.println("Número procesado: " + numero);
        }
    }
}
