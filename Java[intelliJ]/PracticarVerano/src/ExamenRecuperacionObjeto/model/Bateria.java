package ExamenRecuperacionObjeto.model;

import ExamenRecuperacionObjeto.exceptions.CocheException;
import ExamenRecuperacionObjeto.exceptions.ValorNoValidoException;

public class Bateria {
    public static final int MIN_CAPACIDAD = 40, MAX_CAPCIDAD = 120;
    public static final double MIN_NIVEL_VOLTAJE = 0;
    public static final int MIN_CARGA = 0;
    /**
     * En porcentaje
     */
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

    private void setCapacidadBateria(int capacidadBateria) throws ValorNoValidoException {
        if (capacidadBateria < MIN_CAPACIDAD || capacidadBateria > MAX_CAPCIDAD) {
            throw new ValorNoValidoException("El valor indicado de lal capacidad no esta dentro del rango [" +
                    MIN_CAPACIDAD + "," + MAX_CAPCIDAD + "]");
        }
        this.capacidadBateria = capacidadBateria;
    }

    private void setNivelVoltaje(double nivelVoltaje) throws ValorNoValidoException {
        if (nivelVoltaje < MIN_NIVEL_VOLTAJE) throw new ValorNoValidoException(
                "El nivel de voltaje es incorrecto, no puede ser negativo");
        this.nivelVoltaje = nivelVoltaje;
    }

    private void setCargaActualBateria(double cargaActualBateria) throws ValorNoValidoException {
        if (cargaActualBateria < MIN_CARGA || cargaActualBateria > capacidadBateria) throw new ValorNoValidoException(
                "Valores de carga actual fuera del rango permitido [" + MIN_CARGA + "," + capacidadBateria + "]");
        this.cargaActualBateria = cargaActualBateria;
    }

    public double getNivelVoltaje() {
        return nivelVoltaje;
    }

    public boolean isFuncional() throws CocheException {
        if (cargaActualBateria * 100 / capacidadBateria < MIN_CARGA_FUNCIONAL) {
            throw new CocheException("Error de bateria:\n ·La carga de la bateria se encuentra por debajo del minimo");
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Propiedades de la Bateria:");
        sb.append("\n  ·Capacidad: ").append(capacidadBateria).append("ah")
                .append("\n  ·Voltaje: ").append(nivelVoltaje).append("V")
                .append("\n  ·Carga Actual: ").append(cargaActualBateria).append("ah");
        return sb.toString();
    }
}
