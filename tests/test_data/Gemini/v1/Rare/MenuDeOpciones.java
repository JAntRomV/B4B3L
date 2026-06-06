package Code.Gemini.v1.Rare;

public class MenuDeOpciones {
    public static void main(String[] args) {
        String opcion = "Guardar";

        switch (opcion) {
            case "Abrir": System.out.println("Abriendo archivo..."); break;
            case "Guardar": System.out.println("Guardando cambios..."); break;
            case "Cerrar": System.out.println("Cerrando programa..."); break;
            default: System.out.println("Opción no reconocida."); break;
        }
    }
}
