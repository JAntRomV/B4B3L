package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para convertir días a años y días.
 */
public class DiasAAnios {

    private static final int DIAS_POR_ANIO = 365;

    /**
     * Clase interna para almacenar el resultado.
     */
    public static class Periodo {
        public final int anios;
        public final int dias;

        public Periodo(int anios, int dias) {
            this.anios = anios;
            this.dias = dias;
        }

        @Override
        public String toString() {
            return String.format("%d años y %d días", anios, dias);
        }
    }

    /**
     * Convierte días a años y días restantes.
     * @param diasTotales Total de días
     * @return Objeto Periodo con la conversión
     */
    public static Periodo convertir(int diasTotales) {
        if (diasTotales < 0) {
            throw new IllegalArgumentException("Los días no pueden ser negativos");
        }

        int anios = diasTotales / DIAS_POR_ANIO;
        int dias = diasTotales % DIAS_POR_ANIO;

        return new Periodo(anios, dias);
    }

    public static void main(String[] args) {
        int dias = 730;
        Periodo periodo = convertir(dias);

        System.out.println(String.format("%d días = %s", dias, periodo));
    }
}