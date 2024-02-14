package ObjCartas;

import Excepciones.IllegalValueException;

public abstract class Carta {
    private String nombre;
    private int precio;

    public Carta(String nombre, int precio) throws IllegalValueException {
        setNombre(nombre);
        setPrecio(precio);
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setPrecio(int precio) throws IllegalValueException {
        if (precio < 1) throw new IllegalValueException("El precio introducido para la carta no puede ser inferior a 1");
        this.precio = precio;
    }

    public final String getNombre() {
        return nombre;
    }

    public final int getPrecio() {
        return precio;
    }
}
