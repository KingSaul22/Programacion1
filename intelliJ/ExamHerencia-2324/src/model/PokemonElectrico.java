package model;

import enums.WeatherCondition;
import exceptions.MuerteException;
import exceptions.RoundStartException;
import exceptions.ValorNoValidoException;
import interfaces.Atacable;

/**
 * El pokemon electrico obtiene bonus por tormenta electrica o lluvia
 */
public class PokemonElectrico extends Pokemon implements Atacable {
    public static final int RESISTENCIA_LLUVIA_MAXIMO = 15;
    public static final int RESISTENCIA_LLUVIA_MINIMO = 10;
    private int resistenciaLluvia;

    /**
     *
     * @param nombre
     * @param salud salud inicial
     * @param nivelAtaque daño base del ataque
     * @param nivelDefensa defensa base
     * @param resistenciaLluvia en caso de que llueva se usará para reducir el daño recibido
     * @throws ValorNoValidoException cuando se quiera crear un pokemon con  valores inadecuados
     */
    public PokemonElectrico(String nombre, int salud, int nivelAtaque, int nivelDefensa, int resistenciaLluvia) throws ValorNoValidoException {
        super(nombre, salud, nivelAtaque, nivelDefensa);
        setResistenciaLluvia(resistenciaLluvia);
    }

    public void setResistenciaLluvia(int resistenciaLluvia) throws ValorNoValidoException {
        if (resistenciaLluvia < RESISTENCIA_LLUVIA_MINIMO || resistenciaLluvia > RESISTENCIA_LLUVIA_MAXIMO) {
            throw new ValorNoValidoException("El valor de resistencia a la lluvia no está dentro del rango " +
                    RESISTENCIA_LLUVIA_MINIMO + ", " + RESISTENCIA_LLUVIA_MAXIMO + "]");
        }
        this.resistenciaLluvia = resistenciaLluvia;
    }

    @Override
    public void recibirDamage(int damage, WeatherCondition clima, Pokemon atacante) throws MuerteException {
        if (clima == WeatherCondition.LLUVIA) {
            damage -= (int) ((double) damage / 100 * resistenciaLluvia);
        }
        damage -= (int) ((double) damage / 100 * getNivelDefensa());
        if (getSalud() <= damage) {
            //En caso de que el ataque supere a su salud, muere
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
        if (clima == WeatherCondition.TORMENTA_ELECTRICA) {
            ataque *= Math.random() + 1;
        }
        receptor.recibirDamage((int) ataque, clima, this);
    }

    @Override
    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {
        super.roundStart(weatherCondition);
        if (weatherCondition == WeatherCondition.TORMENTA_ELECTRICA) {
            throw new RoundStartException("El pokemon " + getNombre() + " ha activado 'Bonificación por Tormenta Electrica'");
        }
        if (weatherCondition == WeatherCondition.LLUVIA) {
            throw new RoundStartException("El pokemon " + getNombre() + " aumenta su daño gracias a la lluvia");
        }
    }
}
