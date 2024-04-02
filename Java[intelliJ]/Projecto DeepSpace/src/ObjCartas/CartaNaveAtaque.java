package ObjCartas;

import Excepciones.IllegalValueException;
import Interfaces.Atacable;
import Interfaces.Atacador;

public class CartaNaveAtaque extends CartaNave implements Atacador {
    private static final int PRECIO_NAVE_ATAQUE = 5;
    private static final int DAMAGE_DEFAULT = 3;
    private final int PUNTOS_DEFENSA = 7;
    private int puntosAtaque = DAMAGE_DEFAULT;
    public CartaNaveAtaque(String nombre){
        super(nombre, PRECIO_NAVE_ATAQUE);
        setPuntosDefensa(PUNTOS_DEFENSA);
    }

    @Override
    public void mejorar() {
        puntosAtaque += DAMAGE_DEFAULT;
    }

    @Override
    public void atacar(Atacable objetivo) {
        objetivo.serAtacado(puntosAtaque);
    }
}
