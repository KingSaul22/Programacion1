package ObjCartas;

import Excepciones.IllegalValueException;

public class CartaConstrMina extends Carta{
    public CartaConstrMina(String nombre) throws IllegalValueException {
        super(nombre, 1);
    }
}
