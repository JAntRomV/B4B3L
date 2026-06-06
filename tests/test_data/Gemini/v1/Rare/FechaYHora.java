package Code.Gemini.v1.Rare;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FechaYHora {
    public static void main(String[] args) {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        
        String fechaFormateada = ahora.format(formato);
        
        System.out.println("La fecha y hora actuales son: " + fechaFormateada);
    }
}
