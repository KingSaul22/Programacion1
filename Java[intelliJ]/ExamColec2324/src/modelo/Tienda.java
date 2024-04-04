package modelo;

import excepciones.TiendaException;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Tienda {
    private String nombre;
    private Set<Categoria> categorias;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.categorias = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Añade una nueva categoría. En caso de que exista, lanza una excepción
     *
     * @param nombre
     * @throws TiendaException
     */
    public void addCategoria(String nombre) throws TiendaException {
        if (!categorias.add(new Categoria(nombre))) {
            throw new TiendaException("Ya existe esa categoria");
        }
    }

    /**
     * Añade un producto a una lista de categorías. Se añadirá a aquellas categorías en las que todavía no exista. En
     * aquellas donde ya exista, no se hará nada.
     *
     * @param p
     * @param categorias
     */
    public void addProducto(Producto p, List<Categoria> categorias) throws TiendaException {
        if (!this.categorias.containsAll(categorias)) throw new TiendaException("No todas las categorias existen");

        this.categorias.stream().filter(categorias::contains).forEach(a -> a.annadirProducto(p));
    }

    /**
     * Devuelve un conjunto con aquellas categorías que contienen algún producto sin stock
     *
     * @return
     */
    public Set<Categoria> categoriasConProductosSinStock() {
        return categorias.stream().filter(Categoria::sinStock).collect(Collectors.toSet());
    }

    /**
     * Devuelve un conjunto con las categorías a las que pertenece un producto determinado
     *
     * @param p
     * @return
     */
    public Set<Categoria> categoriasDeProducto(Producto p) {
        return categorias.stream().filter(a -> !a.haveProducto(p)).collect(Collectors.toSet());
    }

    /**
     * Devuelve un listado con todos los productos de la tienda (sin repetir) ordenados por precio de mayor a menor
     *
     * @return
     */
    public List<Producto> getTodosLosProductosOrdenadosPorPrecio() {
        return categorias.stream().flatMap(a -> a.getProductos().stream())
                .sorted((a, b) -> Double.compare(b.getPrecio(), a.getPrecio()))
                .collect(Collectors.toSet()).stream().toList();
                /*
                Una nota de la API menciona que en Stream.distinct()
                no hay garantias de estabilidad en streams no ordenados.
                .distinct().toList();
                */
    }

    /**
     * Elimina un producto de todas las categorías donde aparezca.
     *
     * @param p
     * @return true si el producto aparecía en alguna categoría
     */
    public boolean eliminaProducto(Producto p) {
        boolean eliminado = false;
        for (Categoria categoria : categoriasDeProducto(p)) {
            if (categoria.eliminarProducto(p)) eliminado = true;
        }
        return eliminado;
    }

    /**
     * Devuelve un conjunto con aquellos productos que han sido añadido en el último año (a partir de la fecha actual)
     *
     * @return
     */
    public Set<Producto> productosUltimoAnno() {
        return getTodosLosProductosOrdenadosPorPrecio().stream()
                .filter(a -> LocalDate.now().isBefore(a.getFechaIncorporacion().plusYears(1)))
                .collect(Collectors.toSet());
    }
}
