package Code.Gemini.v1.Rare;

public class ContadorConWhile {
    public static void main(String[] args) {
        int contador = 1;
        
        System.out.println("Iniciando conteo...");
        
        while (contador <= 5) {
            System.out.println("Número: " + contador);
            contador++;
        }
        
        System.out.println("Conteo finalizado.");
    }
}
