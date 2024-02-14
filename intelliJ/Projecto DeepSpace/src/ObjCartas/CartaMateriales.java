package ObjCartas;

import Enums.TMateriales;
import Excepciones.IllegalValueException;

public class CartaMateriales extends Carta{
    private final TMateriales MATERIAL;
    public CartaMateriales(String nombre, TMateriales material) throws IllegalValueException {
        super(nombre, 0);
        this.MATERIAL = material;
    }
}
