package Code.Gemini.v1.Refactored;

/**
 * El diseño original ya usaba un método, lo cual es una buena práctica.
 * Se mantiene la estructura por ser adecuada.
 */
public class SaludoConMetodo {

    private static void saludarUsuario(String nombre) {
        System.out.println("¡Hola, " + nombre + "! Bienvenido/a.");
    }

    public static void main(String[] args) {
        saludarUsuario("Ana");
    }
}
