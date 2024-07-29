package ExamenRecuperacionObjeto.model;

import ExamenRecuperacionObjeto.enums.ColorCoche;
import ExamenRecuperacionObjeto.exceptions.CocheException;
import ExamenRecuperacionObjeto.exceptions.ValorNoValidoException;
import ExamenRecuperacionObjeto.interfaces.Arrancable;

public class Coche implements Arrancable {
    String marcaCoche;
    String modeloCoche;
    ColorCoche colorCoche;
    double nivelVoltajeDefault;
    Bateria bateria;
    Motor motorCoche;
    CajaCambios cajaCambios;
    DepositoGasolina depositoGasolina;

    public Coche(String marcaCoche, String modeloCoche, ColorCoche colorCoche,
                 double nivelVoltajeDefault, Bateria bateria, Motor motorCoche,
                 CajaCambios cajaCambios, DepositoGasolina depositoGasolina) throws CocheException {
        try {
            setNivelVoltajeDefault(nivelVoltajeDefault);
            setBateria(bateria);
            setMarcaCoche(marcaCoche);
            setModeloCoche(modeloCoche);
        } catch (ValorNoValidoException e) {
            throw new CocheException(e.getMessage());
        }
        this.colorCoche = colorCoche;
        this.motorCoche = motorCoche;
        this.cajaCambios = cajaCambios;
        this.depositoGasolina = depositoGasolina;
    }

    public void setMarcaCoche(String marcaCoche) throws ValorNoValidoException {
        if (marcaCoche.isBlank() || marcaCoche.length() < 3)
            throw new ValorNoValidoException("Nombre de marca no valido");
        this.marcaCoche = marcaCoche;
    }

    public void setModeloCoche(String modeloCoche) throws ValorNoValidoException {
        if (modeloCoche.isBlank() || modeloCoche.length() < 3)
            throw new ValorNoValidoException("Nombre de modelo no valido");
        this.modeloCoche = modeloCoche;
    }

    public void setNivelVoltajeDefault(double nivelVoltajeDefault) throws ValorNoValidoException {
        if (nivelVoltajeDefault <= 0) throw new ValorNoValidoException("El coche necesita un voltaje mayor a cero");
        this.nivelVoltajeDefault = nivelVoltajeDefault;
    }

    public void setBateria(Bateria bateria) throws CocheException {
        if (bateria.getNivelVoltaje() > nivelVoltajeDefault + 0.5 ||
                bateria.getNivelVoltaje() < nivelVoltajeDefault - 0.25) {
            throw new CocheException("El voltaje de la bateria no es valido para el coche actual");
        }
        this.bateria = bateria;
    }


    @Override
    public String arrancar() {
        StringBuilder fallos = new StringBuilder(motorCoche.isFuncional());
        fallos.append(cajaCambios.isFuncional() ? "" : "\nCaja de cambios\n");
        try {
            depositoGasolina.isFuncional();
        } catch (CocheException e) {
            fallos.append(e.getMessage()).append("\n");
        }
        try {
            bateria.isFuncional();
        } catch (CocheException e) {
            fallos.append(e.getMessage());
        }
        return fallos.isEmpty() ? "El coche ha arrancado" : "El coche NO puede arrancar, fallos:\n" + fallos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(marcaCoche).append(", ").append(modeloCoche).append(", ").append(colorCoche)
                .append("\n  ·Voltaje De funcionamiento: ").append(nivelVoltajeDefault).append("V")
                .append("\n").append(bateria)
                .append("\n").append(motorCoche)
                .append("\n").append(cajaCambios)
                .append("\n").append(depositoGasolina);
        return sb.toString();
    }
}
