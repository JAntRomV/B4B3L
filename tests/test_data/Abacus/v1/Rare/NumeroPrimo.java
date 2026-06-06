package Code.Java.Abacus.v1.Rare;

public class NumeroPrimo {
    public static void main(String[] args) {
        int numero = 17;
        boolean esPrimo = true;
        if (numero <= 1) esPrimo = false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                esPrimo = false;
                break;
            }
        }
        System.out.println(numero + (esPrimo ? " es primo" : " no es primo"));
    }
}