package Code.Gemini.v1.Rare;

public class IndiceDeElemento {
    public static void main(String[] args) {
        String[] colores = {"Rojo", "Verde", "Azul", "Amarillo"};
        String colorBuscado = "Azul";
        int indice = -1;

        for (int i = 0; i < colores.length; i++) {
            if (colores[i].equals(colorBuscado)) {
                indice = i;
                break;
            }
        }

        if (indice != -1) {
            System.out.println("El color " + colorBuscado + " está en el índice " + indice + ".");
        } else {
            System.out.println("El color no se encontró en el array.");
        }
    }
}
