package Code.Java.Abacus.v1.Refactored;

import java.util.Arrays;

/**
 * Clase para calcular cuartiles.
 */
public class Cuartiles {

    /**
     * Calcula los tres cuartiles de un conjunto de datos.
     * @param datos Arreglo de datos
     * @return Arreglo con [Q1, Q2, Q3]
     */
    public static double[] calcular(double[] datos) {
        if (datos == null || datos.length < 4) {
            throw new IllegalArgumentException("Se necesitan al menos 4 datos");
        }

        double[] copia = Arrays.copyOf(datos, datos.length);
        Arrays.sort(copia);

        double q1 = calcularPercentil(copia, 25);
        double q2 = calcularPercentil(copia, 50);
        double q3 = calcularPercentil(copia, 75);

        return new double[]{q1, q2, q3};
    }

    private static double calcularPercentil(double[] datosOrdenados, int percentil) {
        double indice = percentil / 100.0 * (datosOrdenados.length - 1);
        int indiceInferior = (int) Math.floor(indice);
        int indiceSuperior = (int) Math.ceil(indice);

        if (indiceInferior == indiceSuperior) {
            return datosOrdenados[indiceInferior];
        }

        double peso = indice - indiceInferior;
        return datosOrdenados[indiceInferior] * (1 - peso) + datosOrdenados[indiceSuperior] * peso;
    }

    public static void main(String[] args) {
        double[] datos = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double[] cuartiles = calcular(datos);

        System.out.println(String.format("Q1: %.2f", cuartiles[0]));
        System.out.println(String.format("Q2 (Mediana): %.2f", cuartiles[1]));
        System.out.println(String.format("Q3: %.2f", cuartiles[2]));
    }
}