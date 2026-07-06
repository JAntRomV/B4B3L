package Code.Java.Abacus.v1.Refactored;

/**
 * Clase ConversionFahrenheitCelsius - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class ConversionFahrenheitCelsius {
    public static void main(String[] args) {
        double fahrenheit = 77;
        double celsius = (fahrenheit - 32) * 5/9;
        System.out.println(fahrenheit + "°F = " + celsius + "°C");
    }
}