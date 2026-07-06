package Code.Gemini.v1.Rare;

public class CuentaRegresiva {
    public static void main(String[] args) {
        int contador = 10;
        
        System.out.println("Iniciando cuenta regresiva...");
        while (contador > 0) {
            System.out.println(contador);
            contador--;
        }
        System.out.println("¡Despegue!");
    }
}
