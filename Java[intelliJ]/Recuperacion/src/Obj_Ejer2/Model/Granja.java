package Obj_Ejer2.Model;

import java.util.ArrayList;
import java.util.List;

public class Granja {
    private String nombre;
    private List<Animal> animales;
    private List<Producto> productos;
    private List<Transaccion> transacciones;

    public Granja(String nombre) {
        this.nombre = nombre;
        this.animales = new ArrayList<>();
        this.productos = new ArrayList<>();
        this.transacciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Producto> getProductosDisponibles() {
        return productos.stream().filter(Producto::isDisponible).toList();
    }
}
