package Obj_Ejer2.Model;

import Obj_Ejer2.Excepciones.ValorNoValidoException;

import java.time.LocalDateTime;

public class Transaccion {
    private LocalDateTime fechaHora;
    private Producto producto;
    private int cantidad;
    private double precio;

    public Transaccion(Producto producto, int cantidad) throws ValorNoValidoException {
        setCantidad(cantidad);
        this.producto = producto;
        this.precio = producto.getPrecio();
        this.fechaHora = LocalDateTime.now();
    }

    public void setCantidad(int cantidad) throws ValorNoValidoException {
        if (cantidad < 1)
            throw new ValorNoValidoException("No se pueden hacer transacciones con cero o menos productos");
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return precio * cantidad;
    }
}
