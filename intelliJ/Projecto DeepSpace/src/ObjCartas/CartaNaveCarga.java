package ObjCartas;

import Excepciones.IllegalValueException;
import Interfaces.Transportador;

public class CartaNaveCarga extends CartaNave implements Transportador {
    private final int PUNTOS_DEFENSA = 4;
    public CartaNaveCarga(String nombre) throws IllegalValueException {
        super(nombre, 3);
        setPuntosDefensa(PUNTOS_DEFENSA);
    }

    @Override
    public void transportar() {

    }
}
