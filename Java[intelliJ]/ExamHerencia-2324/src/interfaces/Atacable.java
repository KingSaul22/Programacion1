package interfaces;

import enums.WeatherCondition;
import exceptions.MuerteException;
import model.Pokemon;

public interface Atacable {
    /**
     * Este método calculará el daño recibio en función del clima y el tipo de ataque recibido
     * @param damage el valor del ataque
     * @param clima el clima de la ronda actual
     * @param atacante el Pokemon que está atacando
     * @throws MuerteException en caso de que el pokemon muera
     */
    public void recibirDamage(int damage, WeatherCondition clima, Pokemon atacante) throws MuerteException;
}
