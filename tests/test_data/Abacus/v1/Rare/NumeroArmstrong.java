package Code.Java.Abacus.v1.Rare;

public class NumeroArmstrong {
    public static void main(String[] args) {
        int numero = 153;
        int original = numero;
        int suma = 0;
        while (numero != 0) {
            int digito = numero % 10;
            suma += digito * digito * digito;
            numero /= 10;
        }
        System.out.println(original + (suma == original ? " es Armstrong" : " no es Armstrong"));
    }
}