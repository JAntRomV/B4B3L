package Code.ChatGPT.v3.Refactored;

public class Programa008 {
private static String tabla(int n) {
        StringBuilder sb = new StringBuilder();
        for (int k = 1; k <= 10; k++) {
            sb.append(n).append(" x ").append(k).append(" = ").append(n*k).append('\n');
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.print(tabla(n));
    }
}
