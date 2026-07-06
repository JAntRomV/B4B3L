package Code.Gemini.v1.Rare;

public class ValidadorDePassword {
    public static void main(String[] args) {
        String password = "123";
        
        if (password.length() >= 8) {
            System.out.println("La contraseña es segura.");
        } else {
            System.out.println("La contraseña es demasiado corta.");
        }
    }
}
