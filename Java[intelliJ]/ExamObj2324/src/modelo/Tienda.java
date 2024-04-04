package modelo;

import excepciones.TiendaException;

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
     * @param nombre
     * @throws TiendaException
     */
    public void addCategoria(String nombre) throws TiendaException {

    }

    /**
     * Añade un producto a una lista de categorías. Se añadirá a aquellas categorías en las que todavía no exista. En
     * aquellas donde ya exista, no se hará nada.
     * @param p
     * @param categorias
     */
    public void addProducto(Producto p, List<Categoria> categorias) throws TiendaException {

    }

    /**
     * Devuelve un conjunto con aquellas categorías que contienen algún producto sin stock
     * @return
     */
    public Set<Categoria> categoriasConProductosSinStock() {

    }

    /**
     * Devuelve un conjunto con las categorías a las que pertenece un producto determinado
     * @param p
     * @return
     */
    public Set<Categoria> categoriasDeProducto(Producto p) {

    }

    /**
     * Devuelve un listado con todos los productos de la tienda (sin repetir) ordenados por precio de mayor a menor
     * @return
     */
    public List<Producto> getTodosLosProductosOrdenadosPorPrecio(){

    }

    /**
     * Elimina un producto de todas las categorías donde aparezca.
     * @param p
     * @return true si el producto aparecía en alguna categoría
     */
    public boolean eliminaProducto(Producto p){

    }

    /**
     * Devuelve un conjunto con aquellos productos que han sido añadido en el último año (a partir de la fecha actual)
     * @return
     */
    public Set<Producto> productosUltimoAnno(){

    }
}
