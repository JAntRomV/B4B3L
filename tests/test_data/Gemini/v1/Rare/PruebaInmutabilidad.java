package Code.Gemini.v1.Rare;

final class Mensaje {
    private final String contenido;

    public Mensaje(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }
}

public class PruebaInmutabilidad {
    public static void main(String[] args) {
        Mensaje m = new Mensaje("Este es un mensaje secreto.");
        System.out.println(m.getContenido());
    }
}
