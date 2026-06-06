package Code.Gemini.v1.Rare;

public class LanzarDado {
    public static void main(String[] args) {
        int numeroAleatorio = (int)(Math.random() * 6) + 1;
        
        System.out.println("Has lanzado un dado y ha salido: " + numeroAleatorio);
    }
}
