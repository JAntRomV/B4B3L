package Code.Gemini.v1.Rare;

public class EvaluadorLogico {
    public static void main(String[] args) {
        int edad = 25;
        boolean tieneLicencia = true;

        if (edad >= 18 && tieneLicencia) {
            System.out.println("Puede conducir un coche.");
        } else {
            System.out.println("No cumple los requisitos para conducir.");
        }
        
        boolean esEstudiante = false;
        boolean esMayorDe65 = true;
        
        if (esEstudiante || esMayorDe65) {
            System.out.println("Tiene derecho a un descuento.");
        } else {
            System.out.println("No tiene descuento disponible.");
        }
    }
}
