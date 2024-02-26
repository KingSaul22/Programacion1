package model;

import enums.WeatherCondition;
import exceptions.MuerteException;
import exceptions.RoundStartException;
import exceptions.ValorNoValidoException;
import interfaces.Atacable;

public class PokemonAgua extends Pokemon implements Atacable {
    private static final int HIDRATACION_MINIMA = 10; //Use 5
    private static final int HIDRATACION_MAXIMA = 20; //Use 50
    private int nivelHidratacion;
    //private double bonificacionPorLluvia; ...PorSol;...

    public PokemonAgua(String nombre, int salud, int nivelAtaque, int nivelDefensa, int nivelHidratacion) throws ValorNoValidoException {
        super(nombre, salud, nivelAtaque, nivelDefensa);
        setNivelHidratacion(nivelHidratacion);
        //bonificacionPorLluvia = 1d;
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
        //damage = damage * (1 - getNivelDefensa() / 100);

        damage -= (int) ((double) damage / 100 * getNivelDefensa());
        if (getSalud() <= damage) {
            //En caso de que el ataque supera su salud, muere
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
        //receptor.recibirDamage((int) (ataque * precisionPorLluvia), clima, this);
    }

    @Override
    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {
        super.roundStart(weatherCondition);
        //precisionPorLluvia = 1d;
        if (weatherCondition == WeatherCondition.LLUVIA) {
            //bonificacionPorLluvia += Math.random();
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
