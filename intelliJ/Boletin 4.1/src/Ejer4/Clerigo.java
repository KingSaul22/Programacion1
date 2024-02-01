package Ejer4;

public class Clerigo extends Personaje {

    private static final int FUERZA_MIN = 18;
    private static final int INTELIG_MIN = 12, INTELIG_MAX = 16;
    private final int CURACION = 10;
    private final String dios;

    public Clerigo(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMax, String dios) throws PersonajeException {
        super(nombre, raza, fuerza, inteligencia, vidaMax);
        this.dios = dios;
    }

    @Override
    public void setFuerza(int fuerza) throws PersonajeException {

        if (fuerza < FUERZA_MIN) {
            throw new PersonajeException("La fuerza del clérigo no es suficiente.");
        }

        super.setFuerza(fuerza);
    }

    @Override
    public void setInteligencia(int inteligencia) throws PersonajeException {

        if (inteligencia < INTELIG_MIN || inteligencia > INTELIG_MAX) {
            throw new PersonajeException("El nivel de inteligencia no es valido para un clérigo.");
        }

        super.setInteligencia(inteligencia);
    }

    public void lanzaCuracion(Personaje receptor) throws PersonajeException {
        if (this == receptor) throw new PersonajeException("No te puedes curar a ti mismo");
        if (receptor.getVidaActual() == receptor.getVidaMax()) throw new PersonajeException("El personaje que quieres curar no está herido");

        if (receptor.getVidaActual() >= receptor.getVidaMax() + CURACION) {
            receptor.setVidaActual(receptor.getVidaMax());

        } else {
            receptor.setVidaActual(receptor.getVidaActual() + CURACION);
        }
    }

    @Override
    public String toString() {
        return "\nEl clérigo " + getNombre() + " tiene las siguientes caracteristicas:" +
                "\n  · Sirviente de: " + dios +
                "\n  · Raza: " + getRaza() +
                "\n  · Fuerza: " + getFuerza() +
                "\n  · Inteligencia: " + getInteligencia() +
                "\n  · Vida máxima: " + getVidaMax() +
                "\n  · Vida actual: " + getVidaActual();
    }
}
