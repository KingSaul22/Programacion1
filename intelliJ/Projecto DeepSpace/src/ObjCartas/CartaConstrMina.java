package ObjCartas;

import Enums.TMateriales;
import Excepciones.IllegalValueException;

public class CartaConstrMina extends CartaConstruccion{
    private static final int PRECIO_MINA = 1;
    private TMateriales materiaExtraida;
    private int minadoTurno = 2;
    public CartaConstrMina(String nombre, TMateriales material) {
        super(nombre, PRECIO_MINA);
        materiaExtraida = material;
    }
    public CartaConstrMina(String nombre, TMateriales material, int capacidad) {
        super(nombre, PRECIO_MINA);
        materiaExtraida = material;
        minadoTurno = capacidad;
    }

    public TMateriales getMateriaExtraida() {
        return materiaExtraida;
    }

    public int getMinadoTurno() {
        return minadoTurno;
    }
}
