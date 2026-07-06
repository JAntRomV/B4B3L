package Code.Gemini.v1.Rare;

import java.util.ArrayList;

public class RecorrerArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(100);
        numeros.add(200);
        numeros.add(300);

        System.out.println("Elementos de la lista:");
        for (Integer numero : numeros) {
            System.out.println("- " + numero);
        }
    }
}
