package Code.Gemini.v1.Rare;

import java.util.Arrays;

public class CompararArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {3, 2, 1};
        
        System.out.println("¿arr1 es igual a arr2? " + Arrays.equals(arr1, arr2));
        System.out.println("¿arr1 es igual a arr3? " + Arrays.equals(arr1, arr3));
    }
}
