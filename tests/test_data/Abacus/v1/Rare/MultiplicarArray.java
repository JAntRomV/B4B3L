package Code.Java.Abacus.v1.Rare;

public class MultiplicarArray {
    public static void main(String[] args) {
        int[] numeros = {2, 4, 6, 8, 10};
        int factor = 3;
        System.out.print("Array multiplicado: ");
        for (int num : numeros) {
            System.out.print((num * factor) + " ");
        }
    }
}