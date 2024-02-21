package Ejer4b.Modelo;

import Ejer4b.Enums.TRaza;
import Ejer4b.Excepciones.IllegalValueException;
import Ejer4b.Excepciones.PersonajeException;

public class Mago extends Personaje {
    private static final int DAMAGE_HECHIZO = 10;
    private static final int NUM_MAX_HECHIZOS = 4;
    private String[] hechizos = new String[NUM_MAX_HECHIZOS];

    public Mago(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMax) throws IllegalValueException {
        super(nombre, raza, fuerza, inteligencia, vidaMax);
    }

    @Override
    public void setFuerza(int fuerza) throws IllegalValueException {
        if (fuerza > 15) throw new IllegalValueException("Un mago no puede tener un valor de fuerza superior a 15");
        super.setFuerza(fuerza);
    }

    @Override
    public void setInteligencia(int inteligencia) throws IllegalValueException {
        if (inteligencia < 17)
            throw new IllegalValueException("Un mago no puede tener un valor de inteligencia inferior a 17");
        super.setInteligencia(inteligencia);
    }

    public void aprendeHechizo(String hechizo) throws PersonajeException {
        boolean ok = false;

        for (int i = 0; i < NUM_MAX_HECHIZOS; i++) {
            if (hechizos[i] == null) {
                hechizos[i] = hechizo;
                ok = true;
                break;
            }
        }
        if (!ok) throw new PersonajeException("El mago no puede aprender más habilidades");
    }

    public void lanzaHechizo(Personaje receptor, String hechizo) throws IllegalValueException, PersonajeException {
        if (receptor.getVidaActual() == 0) throw new PersonajeException("No puedes atacar a un no-muerto");

        boolean ok = false;
        for (int i = 0; i < NUM_MAX_HECHIZOS; i++) {
            if (hechizo.equals(hechizos[i])) {
                ok = true;
                hechizos[i] = null;
                break;
            }
        }
        if (!ok) throw new PersonajeException("El hechizo indicado no ha sido aprendido por el mago");

        if (receptor.getVidaActual() >= 10) {
            receptor.setVidaActual(receptor.getVidaActual() - DAMAGE_HECHIZO);
        } else {
            receptor.setVidaActual(0);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + mostrarHechizos();
    }

    private String mostrarHechizos() {
        String base = "  · Sus hechizos son:";
        StringBuilder cadena = new StringBuilder(base);

        for (int i = 0; i < NUM_MAX_HECHIZOS; i++) {
            if (hechizos[i] != null) {
                cadena.append("\n    + ").append(hechizos[i]);
            }
        }

        return base.contentEquals(cadena) ? "  · No conoce ningún hechizo" : cadena.toString();
    }
}
