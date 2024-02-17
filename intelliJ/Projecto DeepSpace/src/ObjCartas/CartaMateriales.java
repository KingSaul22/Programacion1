package ObjCartas;

import Enums.TMateriales;
import Excepciones.IllegalValueException;

public class CartaMateriales extends Carta{
    private static final int PRECIO_MATERIAL = 0;
    private final TMateriales MATERIAL;
    public CartaMateriales(String nombre, TMateriales material) {
        super(nombre, PRECIO_MATERIAL);
        this.MATERIAL = material;
    }
}
