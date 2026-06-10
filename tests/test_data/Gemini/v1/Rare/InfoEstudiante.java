package Code.Gemini.v1.Rare;

class Estudiante {
    private String nombre = "Carlos";
    private int matricula = 12345;

    public String getNombre() {
        return nombre;
    }

    public int getMatricula() {
        return matricula;
    }
}

public class InfoEstudiante {
    public static void main(String[] args) {
        Estudiante e1 = new Estudiante();
        
        System.out.println("Nombre del estudiante: " + e1.getNombre());
        System.out.println("Matrícula: " + e1.getMatricula());
    }
}
