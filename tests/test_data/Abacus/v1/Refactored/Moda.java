package Code.Java.Abacus.v1.Refactored;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase para calcular la moda de un conjunto de datos.
 */
public class Moda {

    /**
     * Calcula la moda de un conjunto de datos.
     * @param datos Arreglo de datos
     * @return La moda (valor más frecuente)
     */
    public static int calcular(int[] datos) {
        if (datos == null || datos.length == 0) {
            throw new IllegalArgumentException("El arreglo no puede estar vacío");
        }

        Map<Integer, Integer> frecuencias = new HashMap<>();
        for (int dato : datos) {
            frecuencias.put(dato, frecuencias.getOrDefault(dato, 0) + 1);
        }

        int moda = datos[0];
        int maxFrecuencia = 0;

        for (Map.Entry<Integer, Integer> entry : frecuencias.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                moda = entry.getKey();
            }
        }

        return moda;
    }

    public static void main(String[] args) {
        int[] datos = {1, 2, 2, 3, 3, 3, 4, 5};
        int moda = calcular(datos);

        System.out.println("Moda: " + moda);
    }
}