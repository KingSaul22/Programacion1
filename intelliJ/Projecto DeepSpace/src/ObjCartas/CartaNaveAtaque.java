package ObjCartas;

import Excepciones.IllegalValueException;
import Interfaces.Atacable;
import Interfaces.Atacador;

public class CartaNaveAtaque extends CartaNave implements Atacador {
    private final int PUNTOS_DEFENSA = 7;
    private int puntosAtaque = 3;
    public CartaNaveAtaque(String nombre) throws IllegalValueException {
        super(nombre, 5);
        setPuntosDefensa(PUNTOS_DEFENSA);
    }

    @Override
    public void atacar(Atacable objetivo) {
        objetivo.serAtacado(puntosAtaque);
    }
}
