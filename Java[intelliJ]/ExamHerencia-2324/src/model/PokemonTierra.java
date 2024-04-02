package model;

import enums.WeatherCondition;
import exceptions.MuerteException;
import exceptions.RoundStartException;
import exceptions.ValorNoValidoException;
import interfaces.Atacable;

public class PokemonTierra extends Pokemon implements Atacable {
    public static final int RESISTENCIA_ELECTRICA_MAXIMO = 9;
    public static final int RESISTENCIA_ELECTRICA_MINIMO = 1;
    private int resistenciaElectrica;
    public PokemonTierra(String nombre, int salud, int nivelAtaque, int nivelDefensa, int resistenciaElectrica) throws ValorNoValidoException {
        super(nombre, salud, nivelAtaque, nivelDefensa);
        setResistenciaElectrica(resistenciaElectrica);
    }

    public void setResistenciaElectrica(int resistenciaElectrica) throws ValorNoValidoException{
        if (resistenciaElectrica < RESISTENCIA_ELECTRICA_MINIMO || resistenciaElectrica > RESISTENCIA_ELECTRICA_MAXIMO) {
            throw new ValorNoValidoException("El valor de resistencia a la electricidad no está dentro del rango " +
                    RESISTENCIA_ELECTRICA_MINIMO + ", " + RESISTENCIA_ELECTRICA_MAXIMO + "]");
        }
        this.resistenciaElectrica = resistenciaElectrica;
    }

    @Override
    public void recibirDamage(int damage, WeatherCondition clima, Pokemon atacante) throws MuerteException {
        //Aumenta defensa al recibir un ataque elctrico
        if (atacante instanceof PokemonElectrico) {
            damage -= (int) ((double) damage / 100 * resistenciaElectrica);
        }

        damage -= (int) ((double) damage / 100 * getNivelDefensa());
        //En caso de que el ataque supera su salud, muere
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
        if (clima == WeatherCondition.TORMENTA_ARENA) {
            ataque *= Math.random() + 1;
        }

        receptor.recibirDamage((int) ataque, clima, this);
    }

    @Override
    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {
        super.roundStart(weatherCondition);
        if (weatherCondition == WeatherCondition.TORMENTA_ARENA) {
            throw new RoundStartException("El pokemon " + getNombre() + " ha activado 'Bonificación por Tormenta de Arena'");
        }
    }
}
