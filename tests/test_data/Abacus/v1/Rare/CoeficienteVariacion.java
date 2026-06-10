package Code.Java.Abacus.v1.Rare;

public class CoeficienteVariacion {
    public static void main(String[] args) {
        double[] datos = {10, 12, 23, 23, 16};
        double suma = 0;
        for (double dato : datos) suma += dato;
        double media = suma / datos.length;
        double sumaCuadrados = 0;
        for (double dato : datos) {
            sumaCuadrados += Math.pow(dato - media, 2);
        }
        double desviacion = Math.sqrt(sumaCuadrados / datos.length);
        double cv = (desviacion / media) * 100;
        System.out.println("Coeficiente de variación: " + cv + "%");
    }
}