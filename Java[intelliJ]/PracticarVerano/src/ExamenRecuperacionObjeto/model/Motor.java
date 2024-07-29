package ExamenRecuperacionObjeto.model;

import ExamenRecuperacionObjeto.exceptions.CocheException;

public class Motor {
    public static final int MIN_ACEITE = 0, MAX_ACEITE = 1;
    public static final double MIN_ACEITE_FUNCIONAL = 0.96, MAX_ACEITE_FUNCIONAL = 0.98;
    public static final int MIN_AGUA = 0, MAX_AGUA = 1;
    public static final double MIN_AGUA_FUNCIONAL = 0.70;
    public static final int MIN_TEMPERATURA = 0, MAX_TEMPERATURA = 120;
    public static final int MAX_TEMPERATURA_FUNCIONAL = 95;

    String marcaMotor;
    String modeloMotor;
    String numeroSerie;
    double nivelAceite;
    double nivelAgua;
    double temperatura;
    int kilometraje;


    public boolean isFuncional() throws CocheException {
        StringBuilder fallos = new StringBuilder();
        if (nivelAceite < MIN_ACEITE_FUNCIONAL || nivelAceite > MAX_ACEITE_FUNCIONAL) {
            fallos.append(" ·El nivel de aceite no está en el rango funcional\n");
        }
        if (nivelAgua < MIN_AGUA_FUNCIONAL) {
            fallos.append(" ·El nivel de agua está por debajo del mínimo\n");
        }
        if (temperatura > MAX_TEMPERATURA_FUNCIONAL) {
            fallos.append(" ·La temperatura esta por encima del maximo permitido");
        }


        if (fallos.isEmpty()) return true;
        throw new CocheException("Errores de motor:\n" + fallos);
    }
}
