package Code.Java.Abacus.v1.Rare;

public class Varianza {
    public static void main(String[] args) {
        double[] datos = {10, 12, 23, 23, 16, 23, 21, 16};
        double suma = 0;
        for (double dato : datos) suma += dato;
        double media = suma / datos.length;
        double sumaCuadrados = 0;
        for (double dato : datos) {
            sumaCuadrados += Math.pow(dato - media, 2);
        }
        double varianza = sumaCuadrados / datos.length;
        System.out.println("Varianza: " + varianza);
    }
}