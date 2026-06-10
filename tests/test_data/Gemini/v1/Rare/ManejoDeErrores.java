package Code.Gemini.v1.Rare;

public class ManejoDeErrores {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30};

        try {
            System.out.println("El valor es: " + numeros[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Intentaste acceder a una posición fuera del array.");
        }
        
        System.out.println("El programa continúa después del error.");
    }
}
