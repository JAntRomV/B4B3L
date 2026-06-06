package Code.Java.Abacus.v1.Rare;

public class FactorialNumero {
    public static void main(String[] args) {
        int numero = 5;
        long factorial = 1;
        for (int i = 1; i <= numero; i++) {
            factorial *= i;
        }
        System.out.println("El factorial de " + numero + "! = " + factorial);
    }
}