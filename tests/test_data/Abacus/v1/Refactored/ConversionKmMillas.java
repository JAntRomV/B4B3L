package Code.Java.Abacus.v1.Refactored;

/**
 * Clase ConversionKmMillas - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class ConversionKmMillas {
    public static void main(String[] args) {
        double kilometros = 100;
        double millas = kilometros * 0.621371;
        System.out.println(kilometros + " km = " + millas + " millas");
    }
}