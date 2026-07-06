package Code.Gemini.v1.Rare;

public class EncontrarMaximo {
    public static void main(String[] args) {
        int[] numeros = {45, 88, 12, 105, 3, 99};
        int maximo = numeros[0];

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maximo) {
                maximo = numeros[i];
            }
        }

        System.out.println("El número más grande en el array es: " + maximo);
    }
}
