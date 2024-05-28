package Obj_Ejer3.Model;

import Obj_Ejer3.Enums.WeatherCondition;
import Obj_Ejer3.Excepciones.RoundStartException;
import Obj_Ejer3.Excepciones.ValorNoValidoException;
import Obj_Ejer3.Interfaces.Atacador;

public abstract class Pokemon implements Atacador {
    static final int SALUD_MIN = 0, SALUD_MAX = 100;
    static final int ATAQUE_MIN = 5, ATAQUE_MAX = 15;
    static final int DEFENSA_MIN = 5, DEFENSA_MAX = 25;

    private String nombre;
    private int puntosSalud;
    private int ataque;
    private int defensa;

    public Pokemon(String nombre, int puntosSalud, int ataque, int defensa) throws ValorNoValidoException {
        this.nombre = nombre;

        if (puntosSalud < SALUD_MIN || puntosSalud > SALUD_MAX)
            throw new ValorNoValidoException("Valor para puntos de vida no validos");
        this.puntosSalud = puntosSalud;

        if (ataque < ATAQUE_MIN || ataque > ATAQUE_MAX)
            throw new ValorNoValidoException("Valor para puntos de ataque no validos");
        this.ataque = ataque;

        if (defensa < DEFENSA_MIN || defensa > DEFENSA_MAX)
            throw new ValorNoValidoException("Valor para puntos de defensa no validos");
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosSalud() {
        return puntosSalud;
    }

    public boolean estaVivo() {
        return puntosSalud > 0;
    }

    public abstract void roundStart(WeatherCondition weatherCondition) throws RoundStartException;
}
