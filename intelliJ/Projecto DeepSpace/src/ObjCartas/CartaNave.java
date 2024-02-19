package ObjCartas;

import Interfaces.Atacable;
import Interfaces.Mejorable;

public abstract class CartaNave extends Carta implements Atacable, Mejorable {
    private int puntosDefensa;

    public CartaNave(String nombre, int precio) {
        super(nombre, precio);
    }

    public void setPuntosDefensa(int puntosDefensa) {
        this.puntosDefensa = puntosDefensa;
    }

    @Override
    public int getPuntosDefensa() {
        return puntosDefensa;
    }

    @Override
    public void serAtacado(int damage) {
        if (puntosDefensa > damage) {
            puntosDefensa -= damage;
        } else {
            puntosDefensa = 0;
        }
    }
}
