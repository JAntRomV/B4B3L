package Code.Gemini.v1.Rare;

public class BuscarLetra {
    public static void main(String[] args) {
        String frase = "La programación es fascinante";
        char letraBuscada = 'f';

        int posicion = frase.indexOf(letraBuscada);

        if (posicion != -1) {
            System.out.println("La letra '" + letraBuscada + "' se encontró en la posición: " + posicion);
        } else {
            System.out.println("La letra '" + letraBuscada + "' no se encontró.");
        }
    }
}
