package Code.Gemini.v1.Rare;

import java.util.Arrays;

public class ClonarArray {
    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5};
        int[] copia = original.clone();

        copia[0] = 99;

        System.out.println("Array Original: " + Arrays.toString(original));
        System.out.println("Array Copiado y Modificado: " + Arrays.toString(copia));
    }
}
