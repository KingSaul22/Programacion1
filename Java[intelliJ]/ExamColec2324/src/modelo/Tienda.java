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
     * @param nombre de la categoria
     * @throws TiendaException en caso de que ya exista la categoria
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
     * @param p          {@link Producto Producto} a añadir
     * @param categorias Todas las {@link Categoria categorias} donde se incluirá el {@link Producto producto}
     * @throws TiendaException en caso de que no exista alguna categoria
     */
    public void addProducto(Producto p, List<Categoria> categorias) throws TiendaException {
        if (!this.categorias.containsAll(categorias)) throw new TiendaException("No todas las categorias existen");

        this.categorias.stream().filter(categorias::contains).forEach(a -> a.annadirProducto(p));
    }

    /**
     * Devuelve un conjunto con aquellas categorías que contienen algún producto sin stock
     *
     * @return un {@link Set Set} de {@link Producto productos} cuyo stock sea 0
     */
    public Set<Categoria> categoriasConProductosSinStock() {
        return categorias.stream().filter(Categoria::haveProductoSinStock).collect(Collectors.toSet());
    }

    /**
     * Devuelve un conjunto con las {@link Categoria categorías}
     * a las que pertenece un {@link Producto producto} determinado
     *
     * @param p {@link Producto producto} que buscaremos en las categorias
     * @return Las {@link Categoria categorias} que tengan el {@link Producto producto indicado}
     */
    public Set<Categoria> categoriasDeProducto(Producto p) {
        return categorias.stream().filter(a -> !a.haveProducto(p)).collect(Collectors.toSet());
    }

    /**
     * Devuelve un listado con todos los productos de la tienda (sin repetir) ordenados por precio de mayor a menor
     *
     * @return Lista de todos los {@link Producto productos} ordenados por {@link Producto#getPrecio() precio}
     */
    public List<Producto> getTodosLosProductosOrdenadosPorPrecio() {
        return categorias.stream().flatMap(a -> a.getProductos().stream())
                .collect(Collectors.toSet()).stream()
                .sorted((a, b) -> Double.compare(b.getPrecio(), a.getPrecio())).toList();
                /*
                Una nota de la API menciona que en Stream.distinct()
                no hay garantias de estabilidad en streams no ordenados.
                categorias.stream().flatMap([...]).distinct().sorted([...]).toList();
                */
    }

    /**
     * Elimina un producto de todas las categorías donde aparezca.
     *
     * @param p {@link Producto Producto} a eliminar
     * @return true si el producto a sido eliminado en al menos una categoría
     */
    public boolean eliminaProducto(Producto p) {
        boolean eliminado = false;
        for (Categoria categoria : categoriasDeProducto(p)) {
            if (categoria.eliminarProducto(p)) eliminado = true;
        }
        return eliminado;
    }

    /**
     * Devuelve un conjunto con aquellos {@link Producto productos} que han sido añadidos en el último año
     * (a partir de la {@link LocalDate#now() fecha actual})
     *
     * @return Un {@link Set Set} de {@link Producto productos} con una
     * {@link Producto#getFechaIncorporacion() fecha} de antiguedad superior a hace un año
     */
    public Set<Producto> productosUltimoAnno() {
        return getTodosLosProductosOrdenadosPorPrecio().stream()
                .filter(a -> LocalDate.now().isBefore(a.getFechaIncorporacion().plusYears(1)))
                .collect(Collectors.toSet());
    }
}
