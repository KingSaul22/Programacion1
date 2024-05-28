package Obj_Ejer3.Model;

import Obj_Ejer3.Enums.WeatherCondition;
import Obj_Ejer3.Excepciones.MuerteException;
import Obj_Ejer3.Excepciones.RoundStartException;
import Obj_Ejer3.Interfaces.Atacable;

public class PokemonFuego extends Pokemon {
    public PokemonFuego(String s, int i, int i1, int i2, int i3) {
        super();
    }

    @Override
    public void atacar(Atacable victima, WeatherCondition clima) throws MuerteException {

    }

    @Override
    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {

    }
}
