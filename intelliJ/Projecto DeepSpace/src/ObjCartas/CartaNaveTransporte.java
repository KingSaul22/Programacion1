package ObjCartas;

import Base.Planeta;
import Excepciones.IllegalValueException;
import Interfaces.Transportable;

public class CartaNaveTransporte extends CartaNave implements Transportable {
    private final int PUNTOS_DEFENSA = 4;

    public CartaNaveTransporte(String nombre) throws IllegalValueException {
        super(nombre, 2);
        setPuntosDefensa(PUNTOS_DEFENSA);
    }

    @Override
    public void transportar(Planeta planetaDestino, int numPersonas) {

    }
}
