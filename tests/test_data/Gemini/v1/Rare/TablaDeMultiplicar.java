package Code.Gemini.v1.Rare;

public class TablaDeMultiplicar {
    public static void main(String[] args) {
        int numeroParaTabla = 7;
        
        System.out.println("Tabla de multiplicar del " + numeroParaTabla + ":");
        
        for (int i = 1; i <= 10; i++) {
            int resultado = numeroParaTabla * i;
            System.out.println(numeroParaTabla + " x " + i + " = " + resultado);
        }
    }
}
