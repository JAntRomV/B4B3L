package Code.Java.Abacus.v1.Rare;

public class NumeroPerfecto {
    public static void main(String[] args) {
        int numero = 28;
        int suma = 0;
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) suma += i;
        }
        System.out.println(numero + (suma == numero ? " es perfecto" : " no es perfecto"));
    }
}