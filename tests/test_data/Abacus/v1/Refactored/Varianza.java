package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular la varianza de un conjunto de datos.
 */
public class Varianza {

    /**
     * Calcula la media de un conjunto de datos.
     * @param datos Arreglo de datos
     * @return La media
     */
    private static double calcularMedia(double[] datos) {
        double suma = 0;
        for (double dato : datos) {
            suma += dato;
        }
        return suma / datos.length;
    }

    /**
     * Calcula la varianza de un conjunto de datos.
     * @param datos Arreglo de datos
     * @return La varianza
     */
    public static double calcular(double[] datos) {
        if (datos == null || datos.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }

        double media = calcularMedia(datos);
        double sumaCuadrados = 0;

        for (double dato : datos) {
            sumaCuadrados += Math.pow(dato - media, 2);
        }

        return sumaCuadrados / datos.length;
    }

    public static void main(String[] args) {
        double[] datos = {10, 12, 23, 23, 16, 23, 21, 16};
        double varianza = calcular(datos);

        System.out.println(String.format("Varianza: %.2f", varianza));
    }
}