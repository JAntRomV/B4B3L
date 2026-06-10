package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular el coeficiente de variación.
 */
public class CoeficienteVariacion {

    /**
     * Calcula el coeficiente de variación.
     * @param datos Arreglo de datos
     * @return El coeficiente de variación en porcentaje
     */
    public static double calcular(double[] datos) {
        if (datos == null || datos.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }

        double suma = 0;
        for (double dato : datos) {
            suma += dato;
        }
        double media = suma / datos.length;

        if (media == 0) {
            throw new ArithmeticException("La media no puede ser cero");
        }

        double sumaCuadrados = 0;
        for (double dato : datos) {
            sumaCuadrados += Math.pow(dato - media, 2);
        }

        double desviacion = Math.sqrt(sumaCuadrados / datos.length);
        return (desviacion / media) * 100;
    }

    public static void main(String[] args) {
        double[] datos = {10, 12, 23, 23, 16};
        double cv = calcular(datos);

        System.out.println(String.format("Coeficiente de variación: %.2f%%", cv));
    }
}