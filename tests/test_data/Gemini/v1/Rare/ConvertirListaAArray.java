package Code.Gemini.v1.Rare;

import java.util.ArrayList;
import java.util.Arrays;

public class ConvertirListaAArray {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Java");
        lista.add("Python");
        lista.add("C++");

        String[] array = new String[lista.size()];
        lista.toArray(array);

        System.out.println("Array resultante: " + Arrays.toString(array));
    }
}
