package Code.Java.Abacus.v1.Refactored;
import java.util.Arrays;

/**
 * Clase Mediana - Versión refactorizada con mejores prácticas.
 * @author Estudiante
 * @version 2.0
 */
public class Mediana {
    public static void main(String[] args) {
        double[] datos = {5, 2, 8, 1, 9, 3, 7};
        Arrays.sort(datos);
        double mediana;
        if (datos.length % 2 == 0) {
            mediana = (datos[datos.length/2 - 1] + datos[datos.length/2]) / 2;
        } else {
            mediana = datos[datos.length/2];
        }
        System.out.println("Mediana: " + mediana);
    }
}