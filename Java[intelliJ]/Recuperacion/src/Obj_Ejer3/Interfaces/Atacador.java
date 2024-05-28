package Obj_Ejer3.Interfaces;

import Obj_Ejer3.Enums.WeatherCondition;
import Obj_Ejer3.Excepciones.MuerteException;

public interface Atacador {
    void atacar(Atacable victima, WeatherCondition clima) throws MuerteException;
}
