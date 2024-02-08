package modelo;

import exception.JugueteException;

public abstract class JuguetePlastico extends Juguete{
    private TPlasticos tPlasticos;

    public JuguetePlastico(String marca, String nombre, double precio, TPlasticos tPlasticos) throws JugueteException {
        super(marca, nombre, precio);
        this.tPlasticos = tPlasticos;
    }

    public TPlasticos gettPlasticos() {
        return tPlasticos;
    }
}
