package Here_Exam2122.model;

import java.time.LocalDateTime;

public abstract class Fichero {
    private String nombre;
    private LocalDateTime fecha_creacion;

    public Fichero(String nombre) {
        this.nombre = nombre;
        this.fecha_creacion = LocalDateTime.now();
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public final void mostrarInfoBasica() {
        System.out.printf("""
                Nombre: %s
                Tamaño: %s
                Fecha de creación: %s
                """, nombre, getTamanio(), fecha_creacion);
    }

    public abstract long getTamanio();
}
