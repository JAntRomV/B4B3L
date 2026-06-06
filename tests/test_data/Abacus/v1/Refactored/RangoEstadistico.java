package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular el rango estadístico.
 */
public class RangoEstadistico {

    /**
     * Calcula el rango (diferencia entre máximo y mínimo).
     * @param datos Arreglo de datos
     * @return El rango
     */
    public static double calcular(double[] datos) {
        if (datos == null || datos.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }

        double min = datos[0];
        double max = datos[0];

        for (double dato : datos) {
            if (dato < min) min = dato;
            if (dato > max) max = dato;
        }

        return max - min;
    }

    public static void main(String[] args) {
        double[] datos = {5, 2, 8, 1, 9, 3, 7};
        double rango = calcular(datos);

        System.out.println(String.format("Rango: %.2f", rango));
    }
}