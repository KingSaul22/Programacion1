package ObjCartas;

import Excepciones.IllegalValueException;

public class CartaConstrEscudo extends Carta{
    public CartaConstrEscudo(String nombre) throws IllegalValueException {
        super(nombre, 5);
    }
}
