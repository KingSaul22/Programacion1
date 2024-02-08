package modelo;

import exception.JugueteException;
import interfaces.Apilable;

public class FiguraMadera extends JugueteMadera implements Apilable {
    private String color;
    private int numLados;

    public FiguraMadera(String marca, String nombre, double precio, String paisOrigen, int fechaTala, String color, int numLados) throws JugueteException {
        super(marca, nombre, precio, paisOrigen, fechaTala);
        setColor(color);
        setNumLados(numLados);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumLados() {
        return numLados;
    }

    public void setNumLados(int numLados) throws JugueteException {
        if (numLados < 2) throw new JugueteException("Se necesitan un minimo de dos lados");
        this.numLados = numLados;
    }

    @Override
    public void apilar(Juguete juguete) throws JugueteException {
        Apilable.super.apilar(juguete);
        System.out.println("Se ha el juguete " + this.getNombre() + " sobre el juguete " + juguete.getNombre());
    }
}
