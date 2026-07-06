package Code.Java.Abacus.v1.Refactored;

import java.util.Arrays;

/**
 * Clase para calcular percentiles.
 */
public class Percentil {

    /**
     * Calcula un percentil específico.
     * @param datos Arreglo de datos
     * @param percentil Percentil a calcular (0-100)
     * @return El valor del percentil
     */
    public static double calcular(double[] datos, int percentil) {
        if (datos == null || datos.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }

        if (percentil < 0 || percentil > 100) {
            throw new IllegalArgumentException("El percentil debe estar entre 0 y 100");
        }

        double[] copia = Arrays.copyOf(datos, datos.length);
        Arrays.sort(copia);

        double indice = percentil / 100.0 * (copia.length - 1);
        int indiceInferior = (int) Math.floor(indice);
        int indiceSuperior = (int) Math.ceil(indice);

        if (indiceInferior == indiceSuperior) {
            return copia[indiceInferior];
        }

        double peso = indice - indiceInferior;
        return copia[indiceInferior] * (1 - peso) + copia[indiceSuperior] * peso;
    }

    public static void main(String[] args) {
        double[] datos = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int percentil = 75;

        double resultado = calcular(datos, percentil);

        System.out.println(String.format("Percentil %d: %.2f", percentil, resultado));
    }
}