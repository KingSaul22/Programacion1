package Ejer3;

import java.util.Arrays;

public class Mago extends Personaje {
    public final int FUERZA_MAX = 15;
    public final int INTELIG_MIN = 17;
    public static final int CAPACIDAD_HECHIZOS = 4;
    public final int DAMAGE_HECHIZO = 10;
    private final String[] hechizos;

    public Mago(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMax) throws PersonajeException {
        super(nombre, raza, fuerza, inteligencia, vidaMax);
        hechizos = new String[CAPACIDAD_HECHIZOS];
    }

    @Override
    public void setFuerza(int fuerza) throws PersonajeException {

        if (fuerza > FUERZA_MAX) {
            throw new PersonajeException("La fuerza del mago no es correcta.");
        }

        super.setFuerza(fuerza);
    }

    @Override
    public void setInteligencia(int inteligencia) throws PersonajeException {

        if (inteligencia < INTELIG_MIN) {
            throw new PersonajeException("El nivel de inteligencia no es valido para un mago.");
        }

        super.setInteligencia(inteligencia);
    }

    public void aprendeHechizo(String hechizo) throws PersonajeException {

        int primerVacio = -1;

        for (int i = 0; i < hechizos.length; i++) {

            if (hechizo.equals(hechizos[i])) throw new PersonajeException("El hechizo ya está aprendido.");
            if (primerVacio == -1 && hechizos[i] == null) primerVacio = i;
        }

        if (primerVacio == -1) throw new PersonajeException("El mago no puede aprender más hechizos");
        hechizos[primerVacio] = hechizo;
    }

    public void lanzaHechizo(String hechizo, Personaje receptor) throws PersonajeException {
        if (this == receptor) throw new PersonajeException("No te puedes atacar a ti mismo");
        if (receptor.getVidaActual() == 0)
            throw new PersonajeException("El personaje que quieres atacar ya esta muerto");

        int primerVacio = -1;
        for (int i = 0; i < hechizos.length && primerVacio == -1; i++) {

            if (hechizo.equals(hechizos[i])) primerVacio = i;
        }

        if (primerVacio == -1) throw new PersonajeException("El hechizo seleccionado no ha sido aprendido por el mago");
        hechizos[primerVacio] = null;

        //Ajustar vida
        if (receptor.getVidaActual() <= DAMAGE_HECHIZO) {
            receptor.setVidaActual(0);

        } else {
            receptor.setVidaActual(receptor.getVidaActual() - DAMAGE_HECHIZO);
        }
    }

    @Override
    public String toString() {
        return "\nEl mago " + getNombre() + " tiene las siguientes caracteristicas:" +
                "\n  · Raza: " + getRaza() +
                "\n  · Fuerza: " + getFuerza() +
                "\n  · Inteligencia: " + getInteligencia() +
                "\n  · Vida máxima: " + getVidaMax() +
                "\n  · Vida actual: " + getVidaActual() +
                "\n  · Hechizos: " + listaHechizos();
    }

    private String listaHechizos() {
        StringBuilder lista = new StringBuilder("[");

        for (String hechizo : hechizos) {

            if (hechizo != null) {

                if (String.valueOf(lista).equals("[")) {
                    lista.append(hechizo);

                } else {
                    lista.append(", ").append(hechizo);
                }
            }
        }
        if (String.valueOf(lista).equals("[")) return "Sin hechizos";

        return String.valueOf(lista.append("]"));
    }
}
