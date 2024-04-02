package Ejer7.Model;

public class Ingrediente {
    private String nombre;
    private double cantidad;

    public Ingrediente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void addCantidad(double cantidadExtra) {
        cantidad += cantidadExtra;
    }
}
