package Code.Java.Abacus.v1.Refactored;

/**
 * Clase para calcular el salario total.
 */
public class CalculoSalario {

    /**
     * Calcula el salario total basado en horas trabajadas.
     * @param salarioPorHora Salario por hora
     * @param horasTrabajadas Horas trabajadas
     * @return Salario total
     */
    public static double calcular(double salarioPorHora, int horasTrabajadas) {
        if (salarioPorHora < 0 || horasTrabajadas < 0) {
            throw new IllegalArgumentException("Los valores no pueden ser negativos");
        }

        return salarioPorHora * horasTrabajadas;
    }

    /**
     * Calcula el salario con horas extras.
     * @param salarioPorHora Salario por hora normal
     * @param horasNormales Horas normales trabajadas
     * @param horasExtras Horas extras trabajadas
     * @param factorExtra Factor multiplicador para horas extras (ej: 1.5)
     * @return Salario total
     */
    public static double calcularConExtras(double salarioPorHora, int horasNormales, 
                                          int horasExtras, double factorExtra) {
        double salarioNormal = calcular(salarioPorHora, horasNormales);
        double salarioExtras = salarioPorHora * factorExtra * horasExtras;

        return salarioNormal + salarioExtras;
    }

    public static void main(String[] args) {
        double salarioPorHora = 50;
        int horasTrabajadas = 160;
        double salarioTotal = calcular(salarioPorHora, horasTrabajadas);

        System.out.println(String.format("Salario total: $%.2f", salarioTotal));
    }
}