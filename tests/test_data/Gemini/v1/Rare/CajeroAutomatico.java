package Code.Gemini.v1.Rare;

class CuentaBancaria {
    private double saldo = 0.0;

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito exitoso. Nuevo saldo: " + saldo);
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Fondos insuficientes o cantidad inválida.");
        }
    }
}

public class CajeroAutomatico {
    public static void main(String[] args) {
        CuentaBancaria miCuenta = new CuentaBancaria();
        miCuenta.depositar(500.0);
        miCuenta.retirar(150.0);
        miCuenta.retirar(400.0);
    }
}
