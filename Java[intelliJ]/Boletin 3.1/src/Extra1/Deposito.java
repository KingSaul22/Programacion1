package Extra1;

public class Deposito {
    protected double capacidadMaxima;
    protected double cantidadActual;

    public Deposito(double capacidadMaxima, double cantidadActual) {
        this.capacidadMaxima = capacidadMaxima;
        setCapacidadActual(cantidadActual);
    }

    private void setCapacidadActual(double capacidadActual) {

        if (capacidadActual < capacidadMaxima && capacidadActual > 0) {

            this.cantidadActual = capacidadActual;
        }

    }

    @Override
    public String toString() {
        return String.valueOf((cantidadActual * 100)/capacidadMaxima);
    }
}
