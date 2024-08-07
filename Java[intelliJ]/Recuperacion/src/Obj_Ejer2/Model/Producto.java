package Obj_Ejer2.Model;

import Obj_Ejer2.Enums.TProductos;
import Obj_Ejer2.Excepciones.ValorNoValidoException;

import java.util.Objects;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;
    private TProductos tipoProducto;
    private boolean disponible;

    public Producto(String nombre, double precio, int cantidad, TProductos tipoProducto) throws ValorNoValidoException {
        this.nombre = nombre;
        setPrecio(precio);
        setCantidad(cantidad);
        this.tipoProducto = tipoProducto;
        this.disponible = true;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public TProductos getTipoProducto() {
        return tipoProducto;
    }

    public boolean isDisponible(int unidadesNecesarias) {
        return disponible && cantidad >= unidadesNecesarias;
    }

    public boolean isDisponible() {
        return isDisponible(1);
    }

    public void setPrecio(double precio) throws ValorNoValidoException {
        if (precio < 0) throw new ValorNoValidoException("El precio no puede ser negativo");
        this.precio = precio;
    }

    public void setCantidad(int cantidad) throws ValorNoValidoException {
        if (cantidad < 0) throw new ValorNoValidoException("La cantidad de un producto no puede ser negativa");
        this.cantidad = cantidad;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void reponerUnidades(int unidadesReponer) throws ValorNoValidoException {
        if (unidadesReponer < 0) throw new ValorNoValidoException("No se puede reponer una cantidad negativa");
        this.cantidad += unidadesReponer;
    }

    public void compraUnidades(int unidadesVender) throws ValorNoValidoException {
        if (unidadesVender < 0) throw new ValorNoValidoException("No se puede comprar una cantidad negativa");
        if (unidadesVender > cantidad) throw new ValorNoValidoException("No hay suficiente stock");
        this.cantidad -= unidadesVender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;
        return Objects.equals(nombre, producto.nombre) && tipoProducto == producto.tipoProducto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, tipoProducto);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Producto{");
        sb.append("  · Nombre: ").append(nombre).append(", categoria: ").append(tipoProducto)
                .append("\n      La granja dispone de ").append(cantidad).append(" unidades")
                .append(" a ").append(precio).append("€ cada una.\n      ")
                .append(disponible ? "Si" : "No").append(" se encuentra disponible para la venta.");
        return sb.toString();
    }
}
