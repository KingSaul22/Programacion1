package modelo;

import exception.JugueteException;

public class InstrumentoMadera extends JugueteMadera{
    private int edadMin;

    public InstrumentoMadera(String marca, String nombre, double precio, String paisOrigen, int fechaTala, int edadMin) throws JugueteException {
        super(marca, nombre, precio, paisOrigen, fechaTala);
        setEdadMin(edadMin);
    }

    private void setEdadMin(int edadMin) throws JugueteException {
        if (edadMin < 1) throw new JugueteException("Edad minima no valida");
        this.edadMin = edadMin;
    }
}
