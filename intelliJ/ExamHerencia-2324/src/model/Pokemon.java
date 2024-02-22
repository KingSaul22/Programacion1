package model;

import enums.WeatherCondition;
import exceptions.MuerteException;
import exceptions.RoundStartException;
import exceptions.ValorNoValidoException;
import interfaces.Atacable;
import interfaces.Atacador;

public abstract class Pokemon implements Atacador {
    public static final int SALUD_MAXIMA = 100;
    public static final int SALUD_MINIMA = 0;
    public static final int ATAQUE_MAXIMA = 15;
    public static final int ATAQUE_MINIMA = 5;
    public static final int DEFENSA_MAXIMA = 25;
    public static final int DEFENSA_MINIMA = 5;
    private String nombre;
    private int salud;
    private int nivelAtaque;
    private int nivelDefensa;

    public Pokemon(String nombre, int salud, int nivelAtaque, int nivelDefensa) throws ValorNoValidoException {
        this.nombre = nombre;
        setSalud(salud);
        setNivelAtaque(nivelAtaque);
        setNivelDefensa(nivelDefensa);
    }

    public void setSalud(int salud) throws ValorNoValidoException {
        if (salud < SALUD_MINIMA || salud > SALUD_MAXIMA) {
            throw new ValorNoValidoException("El valor de salud no está dentro del rango " +
                    SALUD_MINIMA + ", " + SALUD_MAXIMA + "]");
        }
        this.salud = salud;
    }

    public void setNivelAtaque(int nivelAtaque) throws ValorNoValidoException {
        if (nivelAtaque < ATAQUE_MINIMA || nivelAtaque > ATAQUE_MAXIMA) {
            throw new ValorNoValidoException("El nivel de ataque no está dentro del rango [" +
                    ATAQUE_MINIMA + ", " + ATAQUE_MAXIMA + "]");
        }
        this.nivelAtaque = nivelAtaque;
    }

    public void setNivelDefensa(int nivelDefensa) throws ValorNoValidoException {
        if (nivelDefensa < DEFENSA_MINIMA || nivelDefensa > DEFENSA_MAXIMA) {
            throw new ValorNoValidoException("El nivel de defensa no está dentro del rango [" +
                    DEFENSA_MINIMA + ", " + DEFENSA_MAXIMA + "]");
        }
        this.nivelDefensa = nivelDefensa;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getNivelAtaque() {
        return nivelAtaque;
    }

    public int getNivelDefensa() {
        return nivelDefensa;
    }

    /**
     *
     * @return true cuando el pokemon tiene algún punto de vida
     */
    public boolean estaVivo() {
        return salud > 0;
    }

    @Override
    public void atacar(Atacable receptor, WeatherCondition clima) throws MuerteException{
        receptor.recibirDamage(getNivelAtaque(), clima, this);
    }

    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException{
        if (salud == 0) throw new RoundStartException("");
    }
}
