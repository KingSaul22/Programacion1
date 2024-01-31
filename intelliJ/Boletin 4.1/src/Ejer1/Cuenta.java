package Ejer1;

public class Cuenta {
    public static final double SALDO_DEFAULT = 0;
    private double saldo;

    public Cuenta(double saldo) throws CuentaException{
        setSaldo(saldo);
    }

    public Cuenta() {
        this.saldo = SALDO_DEFAULT;
    }

    public void setSaldo(double saldo) throws CuentaException {

        if (saldo <= 0) throw new CuentaException("Introduzca un valor positivo.");

        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void ingresarDinero(double dinero) throws CuentaException, CuentaCreditoException {

        if (dinero < 1) throw new CuentaException("Introduzca un valor positivo.");

        saldo += dinero;
    }

    public void sacarDinero(double dinero) throws CuentaException, CuentaCreditoException {

        if (dinero < 1) {
            throw new CuentaException("Introduzca un valor positivo.");

        } else if (dinero > saldo) {
            throw new CuentaException("No puedes extraer más del saldo disponible: " + saldo);
        }

        saldo += dinero;
    }
}
