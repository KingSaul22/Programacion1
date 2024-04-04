package modelo;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Producto {
    private String marca;
    private String modelo;
    private String descripcion;
    private double precio;
    private LocalDate fechaIncorporacion;
    private int stock;

    public Producto(String marca, String modelo, String descripcion, double precio, int stock) {
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaIncorporacion = LocalDate.now();
        setStock(stock);
    }

    /**
     * Este método asegura que no se pueda introducir números negativos.
     * En dicho caso se asignara {@link Producto#stock stock} a 0, no se lanzará una excepción.
     *
     * @param stock Número que se desea colocar como {@link Producto#stock stock}
     */
    public void setStock(int stock) {
        /*if (stock <= 0) {
            this.stock = 0;
        } else {
            this.stock = stock;
        }*/

        //this.stock = stock <= 0 ? 0 : stock;

        //El método max devuelve el númereo más grande.
        //En el caso de que introduzcan un número menor o igual que 0, se devuelve 0.
        this.stock = Math.max(stock, 0);
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public int getStock() {
        return stock;
    }

    /**
     * Método que sobrecarga el método {@link Object#equals(Object) equals} y
     * compara ambos {@link Producto productos} en base a su {@link Producto#marca marca}
     * y su {@link Producto#modelo modelo}
     *
     * @param other Objeto a comparar
     * @return True en el caso de que ambos sean {@link Producto productos} y tengan
     * misma {@link Producto#marca marca} y mismo {@link Producto#modelo modelo}
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Producto producto = (Producto) other;
        return marca.equals(producto.marca) && modelo.equals(producto.modelo);
    }
}
