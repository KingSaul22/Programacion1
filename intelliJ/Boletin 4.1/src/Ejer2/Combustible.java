package Ejer2;

public enum Combustible {
    GASOLINA(3.5), DIESEL(2);

    private double precioCombustibleDia;

    Combustible(double precioCombustibleDia) {
        this.precioCombustibleDia = precioCombustibleDia;
    }

    public double getPrecioCombustibleDia() {
        return precioCombustibleDia;
    }
}
