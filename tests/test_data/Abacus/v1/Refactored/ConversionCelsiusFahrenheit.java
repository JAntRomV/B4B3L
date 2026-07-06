package Code.Java.Abacus.v1.Refactored;

/**
 * Clase ConversionCelsiusFahrenheit - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class ConversionCelsiusFahrenheit {
    public static void main(String[] args) {
        double celsius = 25;
        double fahrenheit = (celsius * 9/5) + 32;
        System.out.println(celsius + "°C = " + fahrenheit + "°F");
    }
}