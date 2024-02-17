package ObjCartas;

import Excepciones.IllegalValueException;
import Interfaces.Atacable;
import Interfaces.Atacador;

public class CartaNaveAtaque extends CartaNave implements Atacador {
    private static final int PRECIO_NAVE_ATAQUE = 5;
    private final int PUNTOS_DEFENSA = 7;
    private int puntosAtaque = 3;
    public CartaNaveAtaque(String nombre){
        super(nombre, PRECIO_NAVE_ATAQUE);
        setPuntosDefensa(PUNTOS_DEFENSA);
    }

    @Override
    public void atacar(Atacable objetivo) {
        objetivo.serAtacado(puntosAtaque);
    }
}
