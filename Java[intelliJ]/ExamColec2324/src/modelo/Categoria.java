package modelo;

import java.util.HashSet;
import java.util.Set;

public class Categoria {
    private String nombre;
    private Set<Producto> productos;

    public Categoria(String nombre) {
        this.nombre = nombre;
        productos = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void annadirProducto(Producto p) {
        productos.add(p);
    }

    public boolean eliminarProducto(Producto p) {
        return productos.remove(p);
    }

    public boolean sinStock() {
        for (Producto p : productos) {
            if (p.getStock() == 0) return true;
        }
        return false;
    }

    public boolean haveProducto(Producto p) {
        return productos.contains(p);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Categoria categoria = (Categoria) other;
        return nombre.equals(categoria.nombre);
    }
}
