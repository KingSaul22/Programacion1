package modelo;

import exception.JugueteException;

public abstract class Juguete {
    private String marca;
    private String nombre;
    private double precio;

    public Juguete(String marca, String nombre, double precio) throws JugueteException {
        setPrecio(precio);
        this.marca = marca;
        this.nombre = nombre;
    }

    public void setPrecio(double precio) throws JugueteException {
        if (precio <= 0) throw new JugueteException("No puede tener un precio negativo");
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }
}
