package Code.Java.Abacus.v1.Rare;

public class ContarImpares {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int contador = 0;
        for (int num : numeros) {
            if (num % 2 != 0) contador++;
        }
        System.out.println("Números impares: " + contador);
    }
}