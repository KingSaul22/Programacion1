package model;

import exceptions.ValorNoValidoException;

public class PokemonDivino extends Pokemon {
    public PokemonDivino(String nombre, int salud, int nivelAtaque, int nivelDefensa) throws ValorNoValidoException {
        super(nombre, salud, nivelAtaque, nivelDefensa);
    }
}
