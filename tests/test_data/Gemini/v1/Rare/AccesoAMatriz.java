package Code.Gemini.v1.Rare;

public class AccesoAMatriz {
    public static void main(String[] args) {
        String[][] tablero = {
            {"A1", "B1", "C1"},
            {"A2", "B2", "C2"},
            {"A3", "B3", "C3"}
        };

        String centro = tablero[1][1];
        System.out.println("La casilla central del tablero es: " + centro);
    }
}
