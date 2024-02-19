package Ejer1;

import java.util.Objects;

public class Alumno {
    private String nombre;
    private String dni;

    public Alumno(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre) && Objects.equals(dni, alumno.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, dni);
    }

    @Override
    public String toString() {
        return "Alumno: " + nombre + " - DNI: " + dni;
    }
}
