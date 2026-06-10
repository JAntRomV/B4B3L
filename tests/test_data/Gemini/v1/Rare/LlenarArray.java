package Code.Gemini.v1.Rare;

import java.util.Arrays;

public class LlenarArray {
    public static void main(String[] args) {
        int[] potenciasDeDos = new int[5];

        for (int i = 0; i < potenciasDeDos.length; i++) {
            potenciasDeDos[i] = (int) Math.pow(2, i);
        }

        System.out.println("Potencias de 2: " + Arrays.toString(potenciasDeDos));
    }
}
