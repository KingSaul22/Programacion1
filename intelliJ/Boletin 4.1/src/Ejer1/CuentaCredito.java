package Ejer1;

public class CuentaCredito extends Cuenta {
    public static final double CREDITO_DEFAULT = 100;
    public static final double CREDITO_MAX_DEFAULT = 300;
    private double creditoMaximo;
    private double credito;

    public CuentaCredito(double saldo, double credito) throws CuentaException, CuentaCreditoException {
        super(saldo);
        setCredito(credito);
        creditoMaximo = credito;
    }

    public CuentaCredito(double credito) throws CuentaCreditoException {
        super();
        setCredito(credito);
    }

    public CuentaCredito() {
        super();
        this.credito = CREDITO_DEFAULT;
        this.creditoMaximo = CREDITO_MAX_DEFAULT;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) throws CuentaCreditoException {

        if (credito > creditoMaximo) {
            throw new CuentaCreditoException("Has superado el límimte del credito admitido");

        } else if (credito < 1) {
            throw new CuentaCreditoException("No es  valido introducir un crédito negativo");
        }

        this.credito = credito;
    }

    @Override
    public void ingresarDinero(double dinero) throws CuentaException, CuentaCreditoException {

        if (dinero <= 0) {
            throw new CuentaCreditoException("Introduzca un valor valido");

        //} else if (credito > 0 && dinero >= credito) {
        } else if (dinero > credito) {
            dinero -= credito;
            credito = 0;
            super.ingresarDinero(dinero);

        }

        credito -= dinero;
    }

    @Override
    public void sacarDinero(double dinero) throws CuentaException, CuentaCreditoException {

        /*if (dinero <= 0) {
            throw new CuentaCreditoException("Introduzca un valor valido");
        } else */if (getSaldo() + Math.abs(credito) >= dinero) {
            throw new CuentaCreditoException("Has llegado a tu limite de crédito");

        } else if (dinero > getSaldo()) {
            dinero -= getSaldo();
            //super.sacarDinero(getSaldo());
            credito += dinero;
            dinero = getSaldo();
        }

        super.sacarDinero(dinero);
    }
}
