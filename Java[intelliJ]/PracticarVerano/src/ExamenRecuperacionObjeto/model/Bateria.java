package ExamenRecuperacionObjeto.model;

import ExamenRecuperacionObjeto.exceptions.CocheException;
import ExamenRecuperacionObjeto.exceptions.ValorNoValidoException;

public class Bateria {
    public static final int MIN_CAPACIDAD = 40, MAX_CAPCIDAD = 120;
    public static final double MIN_NIVEL_VOLTAJE = 0;
    public static final double MIN_NIVEL_VOLTAJE_FUNCIONAL = 11.8, MAX_NIVEL_VOLTAJE_FUNCIONAL = 14.5;
    public static final int MIN_CARGA = 0, MAX_CARGA = 100;
    public static final int MIN_CARGA_FUNCIONAL = 5;

    //Capacidad de la batería (medido en amperios/hora ah)
    int capacidadBateria;
    //El nivel de voltaje que otorga (medido en Voltios V)
    double nivelVoltaje;
    //Carga actual de la batería (en ah)
    double cargaActualBateria;

    public Bateria(int capacidadBateria, double nivelVoltaje, double cargaActualBateria) throws ValorNoValidoException {
        setCapacidadBateria(capacidadBateria);
        setNivelVoltaje(nivelVoltaje);
        setCargaActualBateria(cargaActualBateria);
    }

    public void setCapacidadBateria(int capacidadBateria) throws ValorNoValidoException {
        if (capacidadBateria < MIN_CAPACIDAD || capacidadBateria > MAX_CAPCIDAD) {
            throw new ValorNoValidoException(
                    "El valor indicado de lal capacidad no esta dentro del rango [" + MIN_CAPACIDAD + "," + MAX_CAPCIDAD + "]"
            );
        }
        this.capacidadBateria = capacidadBateria;
    }

    public void setNivelVoltaje(double nivelVoltaje) throws ValorNoValidoException {
        if (nivelVoltaje < MIN_NIVEL_VOLTAJE) {
            throw new ValorNoValidoException("El nivel de voltaje es incorrecto, no puede ser negativo");
        }
        this.nivelVoltaje = nivelVoltaje;
    }

    public void setCargaActualBateria(double cargaActualBateria) throws ValorNoValidoException {
        if (cargaActualBateria < MIN_CARGA || cargaActualBateria > MAX_CARGA) {
            throw new ValorNoValidoException(
                    "Valores de carga actual fuera del rango permitido [" + MIN_CARGA + "," + MAX_CARGA + "]"
            );
        }
        this.cargaActualBateria = cargaActualBateria;
    }

    public boolean isFuncional() throws CocheException {
        StringBuilder fallos = new StringBuilder();
        if (nivelVoltaje < MIN_NIVEL_VOLTAJE_FUNCIONAL || nivelVoltaje > MAX_NIVEL_VOLTAJE_FUNCIONAL) {
            fallos.append(" ·El nivel del voltaje es erroneo\n");
        }
        if (cargaActualBateria < MIN_CARGA_FUNCIONAL) {
            fallos.append(" ·La carga de la bateria se encuentra por debajo del minimo");
        }

        if (fallos.isEmpty()) return true;
        throw new CocheException("Errores de bateria:\n" + fallos);
    }
}
