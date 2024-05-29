package Obj_Ejer2.Model;

import Obj_Ejer2.Enums.TAnimales;
import Obj_Ejer2.Enums.TProductos;
import Obj_Ejer2.Enums.TSalud;
import Obj_Ejer2.Excepciones.GranjaException;
import Obj_Ejer2.Excepciones.ValorNoValidoException;

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

    public void aniadirAnimal(TAnimales tipoAnimal, int edad) throws GranjaException {
        try {
            animales.add(new Animal(tipoAnimal, edad));
        } catch (ValorNoValidoException e) {
            throw new GranjaException("La granja " + nombre + " no ha podido crear el animal\nError: " + e.getMessage());
        }
    }

    public void alimentarAnimal(Alimentacion.TAlimentacion tipoAlimentacion, int idAnimal) {
        animales.get(--idAnimal).registrarAlimentacion(tipoAlimentacion);
    }

    public void chequearAnimal(TSalud salud, int idAnimal) {
        animales.get(--idAnimal).registrarChequeoSalud(salud);
    }

    public void registrarProducto(String nombre, double precio, int cantidad, TProductos tipoProducto) throws GranjaException {
        Producto nuevoProducto;
        try {
            nuevoProducto = new Producto(nombre, precio, cantidad, tipoProducto);
        } catch (ValorNoValidoException e) {
            throw new GranjaException("La granja " + nombre + " no ha podido registrar el producto\nError: " + e.getMessage());
        }

        if (productos.contains(nuevoProducto))
            throw new GranjaException("La granja " + nombre + " ya tiene ese producto registrado");
        productos.add(nuevoProducto);
    }

    public void reponerStockProducto(Producto producto, int cantidad) throws GranjaException {
        if (!productos.contains(producto))
            throw new GranjaException("Error NO esperado: El producto a reponer no existe en la lista de la granja");

        try {
            producto.reponerUnidades(cantidad);
        } catch (ValorNoValidoException e) {
            throw new GranjaException("La granja " + nombre + " no ha podido reponer unidades al producto.\nError: " + e.getMessage());
        }

    }

    public void venderProducto(Producto producto, int cantidad) throws GranjaException {
        if (!productos.contains(producto))
            throw new GranjaException("Error NO esperado: El producto a reponer no existe en la lista de la granja");

        try {
            producto.compraUnidades(cantidad);
        } catch (ValorNoValidoException e) {
            throw new GranjaException("La granja " + nombre + " no ha podido vender unidades del producto.\nError: " + e.getMessage());
        }
    }
}
