package Code.Java.Abacus.v1.Rare;

public class PromedioArray {
    public static void main(String[] args) {
        double[] numeros = {5.5, 10.2, 15.8, 20.1};
        double suma = 0;
        for (double num : numeros) {
            suma += num;
        }
        double promedio = suma / numeros.length;
        System.out.println("Promedio: " + promedio);
    }
}