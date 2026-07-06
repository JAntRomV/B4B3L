package Code.Gemini.v1.Rare;

public class BuscadorDeSubcadena {
    public static void main(String[] args) {
        String textoPrincipal = "El lenguaje de programación Java es muy popular.";
        String subcadena = "Java";

        if (textoPrincipal.contains(subcadena)) {
            System.out.println("El texto contiene la palabra '" + subcadena + "'.");
        } else {
            System.out.println("El texto no contiene la palabra '" + subcadena + "'.");
        }
    }
}
