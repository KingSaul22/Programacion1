package model;

import enums.TColor;
import excepciones.ValorNoValidoException;


public class Coche {
    private String marca;
    private String modelo;
    private TColor color;
    private Motor motor;
    private CajaDeCambio cajaDeCambio;
    private Bateria bateria;
    private Deposito deposito;
    private double voltajeFuncionamiento;

    /**
     * Clase Coche que incluye una serie de parametros que lo definen
     *
     * @param marca
     * @param modelo
     * @param color                 Del Enum TColor
     * @param motor
     * @param cajaDeCambio
     * @param bateria
     * @param deposito              Debe coincidir con el voltaje de funcionamimento
     * @param voltajeFuncionamiento Voltaje al que funciona el coche
     * @throws ValorNoValidoException Cuando la bateria no es compatible debido al voltaje
     */
    public Coche(String marca, String modelo, TColor color, Motor motor, CajaDeCambio cajaDeCambio,
                 Bateria bateria, Deposito deposito, double voltajeFuncionamiento) throws ValorNoValidoException {
        setVoltajeFuncionamiento(voltajeFuncionamiento);
        setBateria(bateria);
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.motor = motor;
        this.cajaDeCambio = cajaDeCambio;
        this.deposito = deposito;
    }

    private void setVoltajeFuncionamiento(double voltajeFuncionamiento) throws ValorNoValidoException {
        if (voltajeFuncionamiento < 0)
            throw new ValorNoValidoException("El voltaje de funcionamiento debe ser superior a 0");
        this.voltajeFuncionamiento = voltajeFuncionamiento;
    }

    public void setBateria(Bateria bateria) throws ValorNoValidoException {
        if (bateria.getVoltaje() != voltajeFuncionamiento)
            throw new ValorNoValidoException("La bateria no es compatible, no tiene el voltaje adecuado");
        this.bateria = bateria;
    }

    /**
     * Se comprueban la operatibilidad de los componentes del coche y
     * se devuelve un mensaje si ha arrancado o si no lo ha hecho y por qué
     *
     * @return Un mensaje que incluye la fuente del error si la hay
     */
    public String arrancar() {
        StringBuilder fallos = new StringBuilder("El coche no puede arrancar.\n");
        if (!motor.isOperativo()) fallos.append("  · Hay fallos en el motor\n");
        if (!cajaDeCambio.isOperativo()) fallos.append("  · Hay fallos en la caja de cambio\n");
        if (!bateria.isOperativo()) fallos.append("  · Hay fallos en la bateria\n");
        if (!deposito.isOperativo()) fallos.append("  · Hay fallos en el deposito\n");

        return fallos.toString().equals("El coche no puede arrancar.\n") ? "El coche ha arrancado" : fallos.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Marca: ").append(marca)
                .append(", modelo: ").append(modelo).append("\n")
                .append("  Color: ").append(color).append("\n")
                .append("  Motor: ").append(motor).append("\n")
                .append("  Caja de Cambios: ").append(cajaDeCambio).append("\n")
                .append("  Bateria: ").append(bateria).append("\n")
                .append("  Deposito: ").append(deposito);
        return sb.toString();
    }
}
