package Code.Java.Abacus.v1.Refactored;

/**
 * Clase CalculoIMC - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class CalculoIMC {
    public static void main(String[] args) {
        double peso = 70; // kg
        double altura = 1.75; // metros
        double imc = peso / (altura * altura);
        System.out.println("Tu IMC es: " + imc);
    }
}