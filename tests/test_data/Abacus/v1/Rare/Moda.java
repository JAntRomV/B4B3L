package Code.Java.Abacus.v1.Rare;

public class Moda {
    public static void main(String[] args) {
        int[] datos = {1, 2, 2, 3, 3, 3, 4, 5};
        int moda = datos[0];
        int maxFrecuencia = 0;
        for (int i = 0; i < datos.length; i++) {
            int frecuencia = 0;
            for (int j = 0; j < datos.length; j++) {
                if (datos[i] == datos[j]) frecuencia++;
            }
            if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
                moda = datos[i];
            }
        }
        System.out.println("Moda: " + moda);
    }
}