package Ejer1;

public class Cuenta {
    public static final double SALDO_DEFAULT = 0;
    private double saldo;

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    public Cuenta() {
        this.saldo = SALDO_DEFAULT;
    }

    public double getSaldo() {
        return saldo;
    }

    public void ingresarDinero(double dinero) throws CuentaException {

        if (dinero < 1) throw new CuentaException("Introduzca un valor positivo.");

        saldo += dinero;
    }

    public void sacarDinero(double dinero) throws CuentaException {

        if (dinero < 1) {
            throw new CuentaException("Introduzca un valor positivo.");

        } else if (dinero > saldo) {
            throw new CuentaException("No puedes extraer más del saldo disponible: " + saldo);
        }

        saldo += dinero;
    }
}
