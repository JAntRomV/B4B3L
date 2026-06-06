package Code.Gemini.v1.Refactored;

/**
 * Refactorizado para usar un método que encapsula la lógica de unión
 * y utiliza String.format para mayor claridad.
 */
public class UnionDeNombres {

    private static String obtenerNombreCompleto(String nombre, String apellido) {
        return String.format("%s %s", nombre, apellido);
    }

    public static void main(String[] args) {
        String nombre = "Juan";
        String apellido = "Pérez";
        
        String nombreCompleto = obtenerNombreCompleto(nombre, apellido);
        
        System.out.println("El nombre completo es: " + nombreCompleto);
    }
}
