package modelo;

import exception.JugueteException;

public abstract class JugueteMadera extends Juguete{
    private String paisOrigen;
    private int fechaTala;

    public JugueteMadera(String marca, String nombre, double precio, String paisOrigen, int fechaTala) throws JugueteException {
        super(marca, nombre, precio);
        setFechaTala(fechaTala);
        this.paisOrigen = paisOrigen;
    }

    public void setFechaTala(int fechaTala) throws JugueteException {
        if (fechaTala < 1) throw new JugueteException("La fecha de tala no es correcta");
        this.fechaTala = fechaTala;
    }
}
