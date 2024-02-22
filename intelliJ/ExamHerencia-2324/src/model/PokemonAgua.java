package model;

import enums.WeatherCondition;
import exceptions.MuerteException;
import exceptions.RoundStartException;
import exceptions.ValorNoValidoException;
import interfaces.Atacable;

public class PokemonAgua extends Pokemon implements Atacable {
    private static final int HIDRATACION_MINIMA = 5;
    private static final int HIDRATACION_MAXIMA = 50;
    private int nivelHidratacion;

    public PokemonAgua(String nombre, int salud, int nivelAtaque, int nivelDefensa, int nivelHidratacion) throws ValorNoValidoException {
        super(nombre, salud, nivelAtaque, nivelDefensa);
        setNivelHidratacion(nivelHidratacion);
    }

    public void setNivelHidratacion(int nivelHidratacion) throws ValorNoValidoException {
        if (nivelHidratacion < HIDRATACION_MINIMA || nivelHidratacion > HIDRATACION_MAXIMA) {
            throw new ValorNoValidoException("El valor de hidratación no está dentro del rango " +
                    HIDRATACION_MINIMA + ", " + HIDRATACION_MAXIMA + "]");
        }
        this.nivelHidratacion = nivelHidratacion;
    }

    @Override
    public void recibirDamage(int damage, WeatherCondition clima, Pokemon atacante) throws MuerteException {
        damage -= (int) ((double) damage / 100 * getNivelDefensa());
        if (getSalud() <= damage) {
            try {
                setSalud(0);
            } catch (ValorNoValidoException e) {
                //Nunca llegamos aquí
            }
            throw new MuerteException("El pokemon " + getNombre() + " ha muerto");
        }

        try {
            setSalud(getSalud() - damage);
        } catch (ValorNoValidoException e) {
            //Nunca llegamos aquí
        }
    }

    @Override
    public void atacar(Atacable receptor, WeatherCondition clima) throws MuerteException {
        double ataque = getNivelAtaque();
        if (clima == WeatherCondition.LLUVIA) {
            ataque *= Math.random() + 1;
        }
        receptor.recibirDamage((int) ataque, clima, this);
    }

    @Override
    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {
        super.roundStart(weatherCondition);
        if (weatherCondition == WeatherCondition.LLUVIA) {
            curarse();
            throw new RoundStartException("El pokemon " + getNombre() +
                    " ha activado 'Precisión por lluvia'\nGracias a la lluvia se cura " +
                    nivelHidratacion + " puntos de vida y aumenta su daño de ataque");
        }
    }

    private void curarse() {
        try {
            if (getSalud() > SALUD_MAXIMA - nivelHidratacion) {
                setSalud(SALUD_MAXIMA);
            } else {
                setSalud(getSalud() + nivelHidratacion);
            }
        } catch (ValorNoValidoException e) {
            //Nunca llegamos aquí
        }
    }
}
