package Code.Gemini.v1.Refactored;

/**
 * Refactorizado para separar cada evaluación lógica en su propio
 * método booleano, mejorando la legibilidad.
 */
public class EvaluadorLogico {

    private static boolean puedeConducir(int edad, boolean tieneLicencia) {
        return edad >= 18 && tieneLicencia;
    }

    private static boolean aplicaParaDescuento(boolean esEstudiante, boolean esMayorDe65) {
        return esEstudiante || esMayorDe65;
    }

    public static void main(String[] args) {
        if (puedeConducir(25, true)) {
            System.out.println("Puede conducir un coche.");
        } else {
            System.out.println("No cumple los requisitos para conducir.");
        }
        
        if (aplicaParaDescuento(false, true)) {
            System.out.println("Tiene derecho a un descuento.");
        } else {
            System.out.println("No tiene descuento disponible.");
        }
    }
}
