package Code.Java.Abacus.v1.Refactored;

/**
 * Clase TablasMultiplicar - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class TablasMultiplicar {
    public static void main(String[] args) {
        int numero = 7;
        System.out.println("Tabla del " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }
}