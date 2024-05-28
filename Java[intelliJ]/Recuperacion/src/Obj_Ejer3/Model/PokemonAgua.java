package Obj_Ejer3.Model;

import Obj_Ejer3.Enums.WeatherCondition;
import Obj_Ejer3.Excepciones.MuerteException;
import Obj_Ejer3.Excepciones.RoundStartException;
import Obj_Ejer3.Excepciones.ValorNoValidoException;
import Obj_Ejer3.Interfaces.Atacable;

public class PokemonAgua extends Pokemon {
    private static final int HIDRATACION_MIN = 10, HIDRATACION_MAX = 20;
    private int hidratacion;

    public PokemonAgua(String nombre, int puntosSalud, int ataque, int defensa, int hidratacion) throws ValorNoValidoException {
        super(nombre, puntosSalud, ataque, defensa);

        if (hidratacion < HIDRATACION_MIN || hidratacion > HIDRATACION_MAX)
            throw new ValorNoValidoException("Valor para puntos de hidratación no validos");
        this.hidratacion = hidratacion;
    }

    @Override
    public void atacar(Atacable victima, WeatherCondition clima) throws MuerteException {

    }

    @Override
    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {

    }
}
