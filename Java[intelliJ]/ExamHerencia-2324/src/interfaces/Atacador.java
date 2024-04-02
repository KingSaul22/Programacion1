package interfaces;

import exceptions.MuerteException;
import enums.WeatherCondition;

public interface Atacador {
    /**
     * Calcula el daño del ataque que se enviará al rececptor usando el metodo recibirDamage()
     * <p>
     * Se tendrá en cuenta la bonificación por clima de ser necesario
     *
     * @param receptor El pokemon que recibira el ataque
     * @param clima    el clima actual
     * @throws MuerteException En caso de que receptor muera
     */
    public void atacar(Atacable receptor, WeatherCondition clima) throws MuerteException;
}
