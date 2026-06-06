package Code.Gemini.v1.Rare;

import java.util.ArrayList;

public class EliminarElemento {
    public static void main(String[] args) {
        ArrayList<String> planetas = new ArrayList<>();
        planetas.add("Mercurio");
        planetas.add("Venus");
        planetas.add("Tierra");
        
        planetas.remove(1);
        
        System.out.println("La lista de planetas actualizada es: " + planetas);
    }
}
