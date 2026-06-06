package Code.Gemini.v1.Rare;

public class OperacionesMath {
    public static void main(String[] args) {
        double base = 4;
        double exponente = 3;
        double numero = 64;

        double potencia = Math.pow(base, exponente);
        double raiz = Math.sqrt(numero);

        System.out.println(base + " elevado a " + exponente + " es " + potencia);
        System.out.println("La raíz cuadrada de " + numero + " es " + raiz);
    }
}
