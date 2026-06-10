package Code.Gemini.v1.Refactored;

/**
 * Refactorizado para usar una constante para la mayoría de edad y un
 * método booleano que devuelve un resultado claro.
 */
public class VerificadorDeEdad {

    private static final int MAYORIA_DE_EDAD = 18;

    private static boolean esMayorDeEdad(int edad) {
        return edad >= MAYORIA_DE_EDAD;
    }

    public static void main(String[] args) {
        int edadActual = 21;

        if (esMayorDeEdad(edadActual)) {
            System.out.println("Es mayor de edad.");
        } else {
            System.out.println("Es menor de edad.");
        }
    }
}
