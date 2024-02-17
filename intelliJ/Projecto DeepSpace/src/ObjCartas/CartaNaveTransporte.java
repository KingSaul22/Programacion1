package ObjCartas;

import Base.Planeta;
import Interfaces.Transportable;

public class CartaNaveTransporte extends CartaNave implements Transportable {
    private static final int PRECIO_NAVE_TRANSPORTE = 2;
    private final int PUNTOS_DEFENSA = 4;

    public CartaNaveTransporte(String nombre){
        super(nombre, PRECIO_NAVE_TRANSPORTE);
        setPuntosDefensa(PUNTOS_DEFENSA);
    }

    @Override
    public void transportar(Planeta planetaDestino, int numPersonas) {

    }
}
