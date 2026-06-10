package Code.Gemini.v1.Rare;

public class BuscarDuplicados {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 2, 5, 6, 1};
        
        System.out.println("Elementos duplicados encontrados:");
        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] == numeros[j]) {
                    System.out.println(numeros[j]);
                }
            }
        }
    }
}
