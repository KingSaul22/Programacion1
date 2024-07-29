package ExamenRecuperacionObjeto.model;

import ExamenRecuperacionObjeto.exceptions.ValorNoValidoException;

public class CajaCambios {
    public static final int MIN_MARCHA = 1, MAX_MARCHA = 7;

    int numeroVelocidades;
    boolean estado;

    public CajaCambios(int numeroVelocidades, boolean estado) throws ValorNoValidoException {
        setNumeroVelocidades(numeroVelocidades);
        this.estado = estado;
    }

    private void setNumeroVelocidades(int numeroVelocidades) throws ValorNoValidoException {
        if (numeroVelocidades < MIN_MARCHA || numeroVelocidades > MAX_MARCHA) {
            throw new ValorNoValidoException("El valor para el número de marchas no está dentro del rango permitido [" +
                    MIN_MARCHA + "," + MAX_MARCHA + "]");
        }
        this.numeroVelocidades = numeroVelocidades;
    }

    public boolean isFuncional() {
        return estado;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Propiedades de la Caja de Cambios:");
        sb.append("\n  ·Numero de Velocidades: ").append(numeroVelocidades)
                .append("\n  ·Estado: ").append(estado ? "Operativa" : "Dañada");
        return sb.toString();
    }
}
