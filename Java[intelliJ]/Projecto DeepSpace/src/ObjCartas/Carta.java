package ObjCartas;

import Excepciones.IllegalValueException;

public abstract class Carta {
    private String nombre;
    private int precio;

    public Carta(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public final String getNombre() {
        return nombre;
    }

    public final int getPrecio() {
        return precio;
    }
}
