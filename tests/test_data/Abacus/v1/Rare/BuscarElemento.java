package Code.Java.Abacus.v1.Rare;

public class BuscarElemento {
    public static void main(String[] args) {
        int[] numeros = {5, 10, 15, 20, 25};
        int buscar = 15;
        boolean encontrado = false;
        for (int num : numeros) {
            if (num == buscar) {
                encontrado = true;
                break;
            }
        }
        System.out.println(buscar + (encontrado ? " encontrado" : " no encontrado"));
    }
}