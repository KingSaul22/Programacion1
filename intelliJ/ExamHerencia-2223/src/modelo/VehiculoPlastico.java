package modelo;

import exception.JugueteException;

public class VehiculoPlastico extends JuguetePlastico{
    private int numRuedas;

    public VehiculoPlastico(String marca, String nombre, double precio, int numRuedas) throws JugueteException {
        super(marca, nombre, precio, TPlasticos.PVC);
        setNumRuedas(numRuedas);
    }

    private void setNumRuedas(int numRuedas) throws JugueteException {
        if (numRuedas < 1) throw new JugueteException("No se admiten vehiculos sin ruedas");
        this.numRuedas = numRuedas;
    }
}
