package Code.Java.Abacus.v1.Rare;
import java.util.Arrays;

public class OrdenarArray {
    public static void main(String[] args) {
        int[] numeros = {5, 2, 8, 1, 9};
        Arrays.sort(numeros);
        System.out.print("Array ordenado: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
    }
}