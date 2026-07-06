package Code.Gemini.v1.Rare;

import java.util.Arrays;

public class DivisorPorComas {
    public static void main(String[] args) {
        String csv = "manzana,banana,naranja,fresa";
        String[] frutas = csv.split(",");
        
        System.out.println("Frutas obtenidas de la cadena:");
        System.out.println(Arrays.toString(frutas));
    }
}
