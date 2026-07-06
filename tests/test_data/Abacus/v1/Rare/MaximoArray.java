package Code.Java.Abacus.v1.Rare;

public class MaximoArray {
    public static void main(String[] args) {
        int[] numeros = {5, 10, 3, 20, 15};
        int max = numeros[0];
        for (int num : numeros) {
            if (num > max) max = num;
        }
        System.out.println("Máximo: " + max);
    }
}