package Base;

import Excepciones.IllegalValueException;
import Interfaces.Lanzable;

public class Dado implements Lanzable {
    private int numCaras;
    private int minValorCara;
    private final int MINIMO_CARAS=4;

    public Dado(int numCaras, int minValorCara) throws IllegalValueException {
        setNumCaras(numCaras);
        setMinValorCara(minValorCara);
    }

    public void setNumCaras(int numCaras) throws IllegalValueException{
        if (numCaras < MINIMO_CARAS) throw new IllegalValueException("El valor introducido no es valido para el número de caras del dado");
        this.numCaras = numCaras;
    }

    public void setMinValorCara(int minValorCara) throws IllegalValueException{
        if (minValorCara < 1) throw new IllegalValueException("El valor introducido no es valido para el minimo de una cara del dado");
        this.minValorCara = minValorCara;
    }

    @Override
    public int lanzar() {
        return (int) (Math.random() * numCaras + minValorCara);
    }

    @Override
    public int getMin() {
        return minValorCara;
    }

    @Override
    public int getMax() {
        return numCaras + minValorCara -1;
    }
}
