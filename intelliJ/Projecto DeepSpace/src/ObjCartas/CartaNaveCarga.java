package ObjCartas;

import Excepciones.IllegalValueException;
import Interfaces.Transportador;

public class CartaNaveCarga extends CartaNave implements Transportador {
    private static final int PRECIO_NAVE_CARGA = 3;
    private final int PUNTOS_DEFENSA = 4;
    public CartaNaveCarga(String nombre){
        super(nombre, PRECIO_NAVE_CARGA);
        setPuntosDefensa(PUNTOS_DEFENSA);
    }

    @Override
    public void transportar() {

    }
}
