package Code.Gemini.v1.Rare;

import java.util.Arrays;

public class UnionDeArrays {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        
        int[] resultado = new int[array1.length + array2.length];
        
        System.arraycopy(array1, 0, resultado, 0, array1.length);
        System.arraycopy(array2, 0, resultado, array1.length, array2.length);
        
        System.out.println("El array combinado es: " + Arrays.toString(resultado));
    }
}
