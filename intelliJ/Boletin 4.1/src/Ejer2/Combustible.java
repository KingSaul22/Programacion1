package Ejer2;

public enum Combustible {
    DIESEL(2), GASOLINA(3.5);

    private double precioCombustibleDia;

    Combustible(double precioCombustibleDia) {
        this.precioCombustibleDia = precioCombustibleDia;
    }

    public double getPrecioCombustibleDia() {
        return precioCombustibleDia;
    }
}
