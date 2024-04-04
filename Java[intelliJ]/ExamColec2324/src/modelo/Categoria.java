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

    /**
     * Se añadira el {@link Producto producto} 'p' a {@link Categoria#productos productos} en caso de que no estuviese presente. Si ya se encontraba dentro, se omite
     *
     * @param p {@link Producto Producto} a añadir
     */
    public void annadirProducto(Producto p) {
        if (!haveProducto(p)) productos.add(p);
    }

    /**
     * Eliminará el {@link Producto producto indicado} por parametros del {@link Set set} {@link Categoria#productos}
     *
     * @param p Producto eliminado
     * @return true si el elemento estaba en {@link Categoria#productos}
     */
    public boolean eliminarProducto(Producto p) {
        return productos.remove(p);
    }

    /**
     * Comprueba que el {@link Producto producto indicado} por parametro
     * se encuentre dentro de {@link Categoria#productos productos}
     *
     * @param p {@link Producto Producto} a comprobar
     * @return true en el caso de que esta {@link Categoria categoria} contenga
     * el {@link Producto producto} indicado por parametro
     */
    public boolean haveProducto(Producto p) {
        for (Producto producto : productos){
            if (p.equals(producto)) return true;
        }
        return false;
    }

    /**
     * @return true en el caso de que algún {@link Producto producto} tenga
     * {@link Producto#getStock() stock} igual a 0
     */
    public boolean haveProductoSinStock() {
        for (Producto p : productos) {
            if (p.getStock() == 0) return true;
        }
        return false;
    }

    /**
     * Método que sobrecarga el método {@link Object#equals(Object) equals} y
     * compara ambas {@link Categoria categorias} en base a su {@link Categoria#nombre nombre}
     *
     * @param other el otro objeto a comparar
     * @return true en el caso de que ambos sean {@link Categoria categorias}
     * y tengan en común el {@link Categoria#nombre nombre}
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Categoria categoria = (Categoria) other;
        return nombre.equals(categoria.nombre);
    }
}
