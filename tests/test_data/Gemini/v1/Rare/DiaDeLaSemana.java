package Code.Gemini.v1.Rare;

public class DiaDeLaSemana {
    public static void main(String[] args) {
        int dia = 4;
        String nombreDelDia;

        switch (dia) {
            case 1: nombreDelDia = "Lunes"; break;
            case 2: nombreDelDia = "Martes"; break;
            case 3: nombreDelDia = "Miércoles"; break;
            case 4: nombreDelDia = "Jueves"; break;
            case 5: nombreDelDia = "Viernes"; break;
            default: nombreDelDia = "Fin de semana"; break;
        }
        
        System.out.println("Hoy es " + nombreDelDia);
    }
}
