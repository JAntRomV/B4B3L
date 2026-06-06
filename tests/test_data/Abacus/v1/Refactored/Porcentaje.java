package Code.Java.Abacus.v1.Refactored;

/**
 * Clase Porcentaje - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class Porcentaje {
    public static void main(String[] args) {
        double cantidad = 200;
        double porcentaje = 15;
        double resultado = (cantidad * porcentaje) / 100;
        System.out.println("El " + porcentaje + "% de " + cantidad + " es: " + resultado);
    }
}