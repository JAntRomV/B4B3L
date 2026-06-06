package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular la media ponderada.
 */
public class MediaPonderada {

    /**
     * Calcula la media ponderada.
     * @param valores Arreglo de valores
     * @param pesos Arreglo de pesos
     * @return La media ponderada
     */
    public static double calcular(double[] valores, double[] pesos) {
        if (valores == null || pesos == null || valores.length != pesos.length) {
            throw new IllegalArgumentException("Los arreglos deben tener la misma longitud");
        }

        if (valores.length == 0) {
            throw new IllegalArgumentException("Los arreglos no pueden estar vacíos");
        }

        double suma = 0;
        double sumaPesos = 0;

        for (int i = 0; i < valores.length; i++) {
            suma += valores[i] * pesos[i];
            sumaPesos += pesos[i];
        }

        if (sumaPesos == 0) {
            throw new ArithmeticException("La suma de pesos no puede ser cero");
        }

        return suma / sumaPesos;
    }

    public static void main(String[] args) {
        double[] valores = {8, 9, 7};
        double[] pesos = {0.3, 0.5, 0.2};

        double mediaPonderada = calcular(valores, pesos);

        System.out.println(String.format("Media ponderada: %.2f", mediaPonderada));
    }
}