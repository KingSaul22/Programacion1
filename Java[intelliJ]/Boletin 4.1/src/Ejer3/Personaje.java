package Ejer3;

public abstract class Personaje {
    private String nombre;
    private TRaza raza;
    public static final int MAX_VIDA = 100;
    public static final int MAX_FUERZA_INTELIG = 20;
    private int fuerza, inteligencia, vidaMax, vidaActual;


    public Personaje(String nombre, TRaza raza, int fuerza, int inteligencia, int vidaMax) throws PersonajeException {
        this.nombre = nombre;
        this.raza = raza;
        setFuerza(fuerza);
        setInteligencia(inteligencia);
        setVidaMax(vidaMax);
        setVidaActual(vidaMax);
    }

    public void setFuerza(int fuerza) throws PersonajeException {

        if(fuerza < 0 || fuerza > MAX_FUERZA_INTELIG) {
            throw new PersonajeException("La fuerza seleccionada no es valida");
        }

        this.fuerza = fuerza;
    }

    public void setInteligencia(int inteligencia) throws PersonajeException {

        if(inteligencia < 0 || inteligencia > MAX_FUERZA_INTELIG) {
            throw new PersonajeException("El nivel de inteligencia no es valido");
        }

        this.inteligencia = inteligencia;
    }

    public void setVidaMax(int vidaMax) throws PersonajeException {

        if (vidaMax < 0 || vidaMax > MAX_VIDA){

            throw new PersonajeException("La vida máxima seleccionada no es valida.");
        }

        this.vidaMax = vidaMax;
    }

    public void setVidaActual(int vidaActual) throws PersonajeException {

        if (vidaActual < 0 || vidaActual > vidaMax){

            throw new PersonajeException("La vida actual del personaje no es valida");
        }

        this.vidaActual = vidaActual;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public int getVidaMax() {
        return vidaMax;
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

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", raza=" + raza +
                ", fuerza=" + fuerza +
                ", inteligencia=" + inteligencia +
                ", vidaMax=" + vidaMax +
                ", vidaActual=" + vidaActual +
                '}';
    }
}
