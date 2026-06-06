package Code.Gemini.v1.Refactored;

/**
 * Clase CuentaBancaria refactorizada para tener un constructor,
 * métodos más robustos y un getter para el saldo.
 */
class CuentaBancaria {
    private double saldo;
    private final String numeroDeCuenta;

    public CuentaBancaria(String numeroDeCuenta, double saldoInicial) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.saldo = saldoInicial;
    }

    public void depositar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad a depositar debe ser positiva.");
            return;
        }
        saldo += cantidad;
        System.out.printf("Depósito de %.2f exitoso. Nuevo saldo: %.2f%n", cantidad, saldo);
    }

    public boolean retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad a retirar debe ser positiva.");
            return false;
        }
        if (cantidad > saldo) {
            System.out.println("Error: Fondos insuficientes.");
            return false;
        }
        saldo -= cantidad;
        System.out.printf("Retiro de %.2f exitoso. Nuevo saldo: %.2f%n", cantidad, saldo);
        return true;
    }
    
    public double getSaldo() {
        return saldo;
    }
}

/**
 * El programa principal simula las operaciones de forma más clara.
 */
public class CajeroAutomatico {
    public static void main(String[] args) {
        CuentaBancaria miCuenta = new CuentaBancaria("ES123456789", 500.0);
        
        miCuenta.depositar(200.0);
        miCuenta.retirar(150.0);
        miCuenta.retirar(600.0); // Esto debería fallar
    }
}
