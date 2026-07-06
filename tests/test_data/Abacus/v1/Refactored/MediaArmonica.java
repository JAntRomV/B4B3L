package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular la media armónica.
 */
public class MediaArmonica {

    /**
     * Calcula la media armónica.
     * @param datos Arreglo de datos (deben ser positivos)
     * @return La media armónica
     */
    public static double calcular(double[] datos) {
        if (datos == null || datos.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }

        double sumaRecíprocos = 0;
        for (double dato : datos) {
            if (dato <= 0) {
                throw new IllegalArgumentException("Todos los valores deben ser positivos");
            }
            sumaRecíprocos += 1.0 / dato;
        }

        return datos.length / sumaRecíprocos;
    }

    public static void main(String[] args) {
        double[] datos = {2, 4, 8};
        double mediaArmonica = calcular(datos);

        System.out.println(String.format("Media armónica: %.2f", mediaArmonica));
    }
}