package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para convertir segundos a horas, minutos y segundos.
 */
public class SegundosAHoras {

    /**
     * Clase interna para almacenar el resultado de la conversión.
     */
    public static class Tiempo {
        public final int horas;
        public final int minutos;
        public final int segundos;

        public Tiempo(int horas, int minutos, int segundos) {
            this.horas = horas;
            this.minutos = minutos;
            this.segundos = segundos;
        }

        @Override
        public String toString() {
            return String.format("%dh %dm %ds", horas, minutos, segundos);
        }
    }

    /**
     * Convierte segundos a formato horas:minutos:segundos.
     * @param segundosTotales Total de segundos
     * @return Objeto Tiempo con la conversión
     */
    public static Tiempo convertir(int segundosTotales) {
        if (segundosTotales < 0) {
            throw new IllegalArgumentException("Los segundos no pueden ser negativos");
        }

        int horas = segundosTotales / 3600;
        int minutos = (segundosTotales % 3600) / 60;
        int segundos = segundosTotales % 60;

        return new Tiempo(horas, minutos, segundos);
    }

    public static void main(String[] args) {
        int segundos = 3665;
        Tiempo tiempo = convertir(segundos);

        System.out.println(String.format("%d segundos = %s", segundos, tiempo));
    }
}