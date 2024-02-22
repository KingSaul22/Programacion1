package model;

import enums.WeatherCondition;
import exceptions.MuerteException;
import exceptions.RoundStartException;
import exceptions.ValorNoValidoException;
import interfaces.Atacable;

public class PokemonFuego extends Pokemon implements Atacable {
    public static final int RESISTENCIA_AGUA_MAXIMO = 10;
    public static final int RESISTENCIA_AGUA_MINIMO = 5;
    private int resistenciaAgua;

    public PokemonFuego(String nombre, int salud, int nivelAtaque, int nivelDefensa, int resistenciaAgua) throws ValorNoValidoException {
        super(nombre, salud, nivelAtaque, nivelDefensa);
        setResistenciaAgua(resistenciaAgua);
    }

    public void setResistenciaAgua(int resistenciaAgua) throws ValorNoValidoException {
        if (resistenciaAgua < RESISTENCIA_AGUA_MINIMO || resistenciaAgua > RESISTENCIA_AGUA_MAXIMO) {
            throw new ValorNoValidoException("El valor de resistencia al agua no está dentro del rango " +
                    RESISTENCIA_AGUA_MINIMO + ", " + RESISTENCIA_AGUA_MAXIMO + "]");
        }
        this.resistenciaAgua = resistenciaAgua;
    }

    @Override
    public void recibirDamage(int damage, WeatherCondition clima, Pokemon atacante) throws MuerteException {
        if (atacante instanceof PokemonAgua) {
            damage -= resistenciaAgua;
        }
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
        if (clima == WeatherCondition.SOLEADO) {
            ataque *= Math.random() + 1;
        }
        receptor.recibirDamage((int) ataque, clima, this);
    }

    @Override
    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {
        super.roundStart(weatherCondition);
        if (weatherCondition == WeatherCondition.SOLEADO) {
            throw new RoundStartException("El pokemon " + getNombre() + " ha activado 'Bonificación por Sol'");
        }
    }
}
