package Ejer2;

public enum Gama {
    BAJA(30), MEDIA(40), ALTA(50);
    private double precioBaseDia;

    Gama(double precioBaseDia) {
        this.precioBaseDia = precioBaseDia;
    }

    public double getPrecioBaseDia() {
        return precioBaseDia;
    }
}
