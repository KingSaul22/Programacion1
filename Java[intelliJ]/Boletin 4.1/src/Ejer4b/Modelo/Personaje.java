package Ejer4b.Modelo;

import Ejer4b.Enums.TRaza;
import Ejer4b.Excepciones.IllegalValueException;

public abstract class Personaje {
    private String nombre;
    private TRaza raza;
    private int fuerza, inteligencia, vidaMax, vidaActual;

    public Personaje(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMax) throws IllegalValueException {
        this.nombre = nombre;
        this.raza = raza;
        setFuerza(fuerza);
        setInteligencia(inteligencia);
        setVidaMax(vidaMax);
    }

    public void setFuerza(int fuerza) throws IllegalValueException {
        if (fuerza < 0 || fuerza > 20) {
            throw new IllegalValueException("El valor de fuerza no está dentro del rango permitido");
        }
        this.fuerza = fuerza;
    }

    public void setInteligencia(int inteligencia) throws IllegalValueException {
        if (inteligencia < 0 || inteligencia > 20) {
            throw new IllegalValueException("El valor de inteligencia no está dentro del rango permitido");
        }
        this.inteligencia = inteligencia;
    }

    public void setVidaMax(int vidaMax) throws IllegalValueException {
        if (vidaMax < 0 || vidaMax > 100) {
            throw new IllegalValueException("El valor de vida máxima no está dentro del rango permitido");
        }
        this.vidaMax = vidaMax;
        this.vidaActual = vidaMax;
    }

    public void setVidaActual(int vidaActual) throws IllegalValueException {
        if (vidaActual < 0 || vidaActual > vidaMax) {
            throw new IllegalValueException("El valor de vida actual no está dentro del rango permitido");
        }
        this.vidaActual = vidaActual;
    }

    public String getNombre() {
        return nombre;
    }

    public TRaza getRaza() {
        return raza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder("El personaje ")
                .append(nombre).append(" tiene las siguientes caracteristicas:")
                .append("\n  · Raza: ").append(raza)
                .append("\n  · Fuerza: ").append(fuerza)
                .append("\n  · Inteligencia: ").append(inteligencia)
                .append("\n  · Vida Máxima: ").append(vidaMax)
                .append("\n  · Vida Actual: ").append(vidaActual);
        return cadena.toString();
    }
}
