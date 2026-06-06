package Code.Java.Abacus.v1.Refactored;

import java.time.LocalDate;
import java.time.Period;

/**
 * Clase para calcular la edad de una persona.
 */
public class CalculoEdad {

    /**
     * Calcula la edad basándose en el año de nacimiento.
     * @param anioNacimiento Año de nacimiento
     * @param anioActual Año actual
     * @return La edad en años
     */
    public static int calcularEdad(int anioNacimiento, int anioActual) {
        if (anioNacimiento > anioActual) {
            throw new IllegalArgumentException("El año de nacimiento no puede ser mayor al año actual");
        }

        return anioActual - anioNacimiento;
    }

    /**
     * Calcula la edad exacta usando fechas completas.
     * @param fechaNacimiento Fecha de nacimiento
     * @param fechaActual Fecha actual
     * @return Período con años, meses y días
     */
    public static Period calcularEdadExacta(LocalDate fechaNacimiento, LocalDate fechaActual) {
        if (fechaNacimiento.isAfter(fechaActual)) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser posterior a la fecha actual");
        }

        return Period.between(fechaNacimiento, fechaActual);
    }

    public static void main(String[] args) {
        int anioNacimiento = 1990;
        int anioActual = 2025;
        int edad = calcularEdad(anioNacimiento, anioActual);

        System.out.println(String.format("Tu edad es: %d años", edad));
    }
}