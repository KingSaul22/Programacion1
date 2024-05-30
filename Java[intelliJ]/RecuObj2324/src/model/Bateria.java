package model;

import excepciones.ValorNoValidoException;

public class Bateria {
    private double capacidad;
    private double voltaje;
    private double cargaActual;

    /**
     * Clase Bateria que incluye una serie de parametros que lo definen
     *
     * @param capacidad   Debe ser mayor que 0 y se mide en amperios/hora
     * @param voltaje     Debe ser mayor que 0 y se mide en voltios
     * @param cargaActual Deentro del rango de la capacidad y se mide en amperios/hora
     * @throws ValorNoValidoException Si alguno de los parametros no tiene datos validos
     */
    public Bateria(double capacidad, double voltaje, double cargaActual) throws ValorNoValidoException {
        setCapacidad(capacidad);
        setVoltaje(voltaje);
        setCargaActual(cargaActual);
    }

    private void setCapacidad(double capacidad) throws ValorNoValidoException {
        if (capacidad <= 0)
            throw new ValorNoValidoException("La capacidad de la bateria no puede ser inferior o igual a cero");
        this.capacidad = capacidad;
    }

    private void setVoltaje(double voltaje) throws ValorNoValidoException {
        if (voltaje <= 0)
            throw new ValorNoValidoException("El voltaje de la bateria no puede ser inferior o igual a cero");
        this.voltaje = voltaje;
    }

    private void setCargaActual(double cargaActual) throws ValorNoValidoException {
        if (cargaActual < 0 || cargaActual > capacidad) throw new ValorNoValidoException(
                "La carga no puede ser inferior a cero o superior a la capacidad máxima");
        this.cargaActual = cargaActual;
    }

    public double getVoltaje() {
        return voltaje;
    }

    /**
     * Comprueba que la bateria tenga al menos un 5% de batería
     *
     * @return true cuando la bateria tiene carga suficiente
     */
    public boolean isOperativo() {
        return cargaActual >= capacidad * 0.05;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Capacidad de la bateria: ");
        sb.append(capacidad).append("a/h ")
                .append(", voltaje: ").append(voltaje).append("V ")
                .append(", cargaActual: ").append(cargaActual).append("a/h");
        return sb.toString();
    }
}
