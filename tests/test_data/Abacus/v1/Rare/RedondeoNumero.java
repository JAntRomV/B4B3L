package Code.Java.Abacus.v1.Rare;

public class RedondeoNumero {
    public static void main(String[] args) {
        double numero = 3.14159;
        long redondeado = Math.round(numero);
        double dosDecimales = Math.round(numero * 100.0) / 100.0;
        System.out.println("Redondeado: " + redondeado);
        System.out.println("Dos decimales: " + dosDecimales);
    }
}