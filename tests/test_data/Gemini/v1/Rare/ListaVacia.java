package Code.Gemini.v1.Rare;

import java.util.ArrayList;

public class ListaVacia {
    public static void main(String[] args) {
        ArrayList<String> miLista = new ArrayList<>();

        if (miLista.isEmpty()) {
            System.out.println("La lista está vacía. Añadiendo elementos...");
            miLista.add("Primer Elemento");
        }
        
        System.out.println("Ahora la lista contiene: " + miLista);
    }
}
