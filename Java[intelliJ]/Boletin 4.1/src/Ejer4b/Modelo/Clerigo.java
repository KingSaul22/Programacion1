package Ejer4b.Modelo;

import Ejer4b.Enums.TRaza;
import Ejer4b.Excepciones.IllegalValueException;
import Ejer4b.Excepciones.PersonajeException;

public class Clerigo extends Personaje {
    private static final int CAPACIDAD_CURACION = 10;
    private String dios;

    public Clerigo(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMax, String dios) throws IllegalValueException {
        super(nombre, raza, fuerza, inteligencia, vidaMax);
        this.dios = dios;
    }

    @Override
    public void setFuerza(int fuerza) throws IllegalValueException {
        if (fuerza < 18) throw new IllegalValueException("Un clerigo no puede tener un valor de fuerza inferior a 18");
        super.setFuerza(fuerza);
    }

    @Override
    public void setInteligencia(int inteligencia) throws IllegalValueException {
        if (inteligencia < 13 || inteligencia > 15)
            throw new IllegalValueException("El valor de inteligencia no está dentro del rango permitido");
        super.setInteligencia(inteligencia);
    }

    public void curar(Personaje receptor) throws PersonajeException, IllegalValueException {
        if (receptor.getVidaActual() == receptor.getVidaMax()) {
            throw new PersonajeException("No puedes curar a alguién que ya tiene la vida máxima");
        }

        if (receptor.getVidaActual() > receptor.getVidaMax() - CAPACIDAD_CURACION) {
            receptor.setVidaActual(receptor.getVidaMax());
        } else {
            receptor.setVidaActual(receptor.getVidaActual() + CAPACIDAD_CURACION);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n  · Sirve al dios: " + dios;
    }
}
