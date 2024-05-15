package Obj_Ejer1.Model;

import Obj_Ejer1.Enums.TFamilia;

public class Mascota {
    private TFamilia familia;
    private String nombre;
    private int edad;
    private double precio;
    private boolean disponible;

    public Mascota(String nombre, TFamilia familia, int edad, double precio, boolean dissponible) {
        this.familia = familia;
        this.nombre = nombre;
        this.edad = edad;
        this.precio = precio;
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public TFamilia getFamilia() {
        return familia;
    }

    public int getEdad() {
        return edad;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDisponible() {
        return disponible;
    }
}
