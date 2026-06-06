package Code.Gemini.v1.Rare;

import java.util.ArrayList;

public class UsoArrayList {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Marta");
        
        System.out.println("El segundo nombre en la lista es: " + nombres.get(1));
        System.out.println("Tamaño de la lista: " + nombres.size());
    }
}
