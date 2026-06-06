package Code.Gemini.v1.Rare;

enum Nivel {
    FACIL,
    NORMAL,
    DIFICIL
}

public class SelectorDeDificultad {
    public static void main(String[] args) {
        Nivel dificultadElegida = Nivel.NORMAL;

        switch (dificultadElegida) {
            case FACIL: System.out.println("Has elegido el nivel Fácil."); break;
            case NORMAL: System.out.println("Has elegido el nivel Normal."); break;
            case DIFICIL: System.out.println("Has elegido el nivel Difícil."); break;
        }
    }
}
