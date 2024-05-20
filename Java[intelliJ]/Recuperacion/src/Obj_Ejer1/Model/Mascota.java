package Obj_Ejer1.Model;

import Obj_Ejer1.Enums.TFamilia;

import java.util.Objects;

public class Mascota {
    private TFamilia familia;
    private String nombre;
    private int edad;
    private double precio;
    private boolean disponible;

    public Mascota(String nombre, TFamilia familia, int edad, double precio, boolean disponible) {
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

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mascota mascota = (Mascota) o;
        return edad == mascota.edad && familia == mascota.familia && Objects.equals(nombre, mascota.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familia, nombre, edad);
    }
}
