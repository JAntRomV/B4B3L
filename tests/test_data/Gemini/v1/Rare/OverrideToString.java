package Code.Gemini.v1.Rare;

class Coordenada {
    int x, y;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordenada(x=" + x + ", y=" + y + ")";
    }
}

public class OverrideToString {
    public static void main(String[] args) {
        Coordenada punto = new Coordenada(10, 25);
        System.out.println("El objeto es: " + punto);
    }
}
