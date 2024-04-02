package modelo;

import exception.JugueteException;
import interfaces.Apilable;

public class PiezaLego extends JuguetePlastico implements Apilable {
    private int longitud;
    private String color;

    public PiezaLego(String marca, String nombre, double precio, int longitud, String color) throws JugueteException {
        super(marca, nombre, precio, TPlasticos.ABS);
        setLongitud(longitud);
        this.color = color;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) throws JugueteException {
        if (longitud < 1) throw new JugueteException("Longitud de pieza incorrecto");
        this.longitud = longitud;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void apilar(Juguete juguete) throws JugueteException {
        Apilable.super.apilar(juguete);
        System.out.println("Se ha el juguete " + this.getNombre() + " sobre el juguete " + juguete.getNombre());
    }
}
