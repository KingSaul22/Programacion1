package ExamenRecuperacionObjeto.model;

import ExamenRecuperacionObjeto.exceptions.CocheException;
import ExamenRecuperacionObjeto.exceptions.ValorNoValidoException;

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

    public Motor(String marcaMotor, String modeloMotor, String numeroSerie, double nivelAceite, double nivelAgua,
                 double temperatura, int kilometraje) throws ValorNoValidoException {
        setMarcaMotor(marcaMotor);
        setModeloMotor(modeloMotor);
        setNumeroSerie(numeroSerie);
        setNivelAceite(nivelAceite);
        setNivelAgua(nivelAgua);
        setTemperatura(temperatura);
        setKilometraje(kilometraje);
    }

    private void setMarcaMotor(String marcaMotor) throws ValorNoValidoException {
        if (marcaMotor.isBlank() || marcaMotor.length() < 3)
            throw new ValorNoValidoException("Nombre de marca no valido");
        this.marcaMotor = marcaMotor;
    }

    private void setModeloMotor(String modeloMotor) throws ValorNoValidoException {
        if (modeloMotor.isBlank() || modeloMotor.length() < 3)
            throw new ValorNoValidoException("Nombre de modelo no valido");
        this.modeloMotor = modeloMotor;
    }

    private void setNumeroSerie(String numeroSerie) throws ValorNoValidoException {
        if (marcaMotor.isBlank() || marcaMotor.length() < 5)
            throw new ValorNoValidoException("Número de serie no valido");
        this.numeroSerie = numeroSerie;
    }

    private void setNivelAceite(double nivelAceite) throws ValorNoValidoException {
        if (nivelAceite < MIN_ACEITE || nivelAceite > MAX_ACEITE)
            throw new ValorNoValidoException("El valor para el nivel de aceite no está dentro del rango permitido[" +
                    MIN_ACEITE + "," + MAX_ACEITE + "]");
        this.nivelAceite = nivelAceite;
    }

    private void setTemperatura(double temperatura) throws ValorNoValidoException {
        if (temperatura < MIN_TEMPERATURA || temperatura > MAX_TEMPERATURA)
            throw new ValorNoValidoException("El valor para la temperatura no está dentro del rango permitido[" +
                    MIN_TEMPERATURA + "," + MAX_TEMPERATURA + "]");
        this.temperatura = temperatura;
    }

    private void setNivelAgua(double nivelAgua) throws ValorNoValidoException {
        if (nivelAgua < MIN_AGUA || nivelAgua > MAX_AGUA)
            throw new ValorNoValidoException("El valor para el nivel de agua no está dentro del rango permitido[" +
                    MIN_AGUA + "," + MAX_AGUA + "]");
        this.nivelAgua = nivelAgua;
    }

    private void setKilometraje(int kilometraje) throws ValorNoValidoException {
        if (kilometraje < 0) throw new ValorNoValidoException("El valor para el kilometraje no puede ser negativo");
        this.kilometraje = kilometraje;
    }

    public String isFuncional() {
        StringBuilder fallos = new StringBuilder();
        if (nivelAceite < MIN_ACEITE_FUNCIONAL || nivelAceite > MAX_ACEITE_FUNCIONAL)
            fallos.append(" ·El nivel de aceite no está en el rango funcional [" +
                    MIN_ACEITE_FUNCIONAL * 100 + "%," + MAX_ACEITE_FUNCIONAL * 100 + "%]\n");

        if (nivelAgua < MIN_AGUA_FUNCIONAL)
            fallos.append(" ·El nivel de agua está por debajo del mínimo [" + MIN_AGUA_FUNCIONAL * 100 + "%]\n");

        if (temperatura > MAX_TEMPERATURA_FUNCIONAL)
            fallos.append(" ·La temperatura esta por encima del maximo permitido [" + MAX_TEMPERATURA_FUNCIONAL + "]");


        return fallos.isEmpty() ? "" : "Errores de motor:\n" + fallos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Motor: ");
        sb.append(marcaMotor).append(", ").append(modeloMotor)
                .append("\n  ·Número de Serie: ").append(numeroSerie)
                .append("\n  ·Nivel de Aceite: ").append(nivelAceite * 100).append("%")
                .append("\n  ·Nivel del Agua: ").append(nivelAgua * 100).append("%")
                .append("\n  ·Temperatura: ").append(temperatura).append("ºC")
                .append("\n  ·Kilometraje: ").append(kilometraje).append("Km");
        return sb.toString();
    }
}
