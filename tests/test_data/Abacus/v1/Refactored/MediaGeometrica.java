package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular la media geométrica.
 */
public class MediaGeometrica {

    /**
     * Calcula la media geométrica.
     * @param datos Arreglo de datos (deben ser positivos)
     * @return La media geométrica
     */
    public static double calcular(double[] datos) {
        if (datos == null || datos.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }

        double producto = 1;
        for (double dato : datos) {
            if (dato <= 0) {
                throw new IllegalArgumentException("Todos los valores deben ser positivos");
            }
            producto *= dato;
        }

        return Math.pow(producto, 1.0 / datos.length);
    }

    public static void main(String[] args) {
        double[] datos = {2, 8, 4};
        double mediaGeometrica = calcular(datos);

        System.out.println(String.format("Media geométrica: %.2f", mediaGeometrica));
    }
}