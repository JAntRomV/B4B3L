package Code.Java.Abacus.v1.Rare;

public class MinimoArray {
    public static void main(String[] args) {
        int[] numeros = {5, 10, 3, 20, 15};
        int min = numeros[0];
        for (int num : numeros) {
            if (num < min) min = num;
        }
        System.out.println("Mínimo: " + min);
    }
}