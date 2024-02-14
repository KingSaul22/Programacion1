package ObjCartas;

import Excepciones.IllegalValueException;
import Interfaces.Atacable;

public abstract class CartaNave extends Carta implements Atacable{
    private int puntosDefensa;

    public CartaNave(String nombre, int precio) throws IllegalValueException {
        super(nombre, precio);
    }

    public void setPuntosDefensa(int puntosDefensa) {
        this.puntosDefensa = puntosDefensa;
    }

    @Override
    public int getPuntosDefensa() {
        return puntosDefensa;
    }    @Override

    public void serAtacado(int damage) {
        if (puntosDefensa > damage) {
            puntosDefensa -= damage;
        } else {
            puntosDefensa = 0;
        }
    }
}
