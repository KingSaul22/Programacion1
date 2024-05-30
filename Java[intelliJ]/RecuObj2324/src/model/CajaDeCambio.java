package model;

import excepciones.ValorNoValidoException;

public class CajaDeCambio {
    private int numeroMarchas;
    private boolean estado;

    /**
     * Una caja de Cambios con una serrie de parametros
     *
     * @param numeroMarchas Dentro del rango 1 - 7
     * @param estado        Si la caja de Cambios funcniona correctamente
     * @throws ValorNoValidoException Si alguno de los parametros no tiene datos validos
     */
    public CajaDeCambio(int numeroMarchas, boolean estado) throws ValorNoValidoException {
        setNumeroMarchas(numeroMarchas);
        this.estado = estado;
    }

    private void setNumeroMarchas(int numeroMarchas) throws ValorNoValidoException {
        if (numeroMarchas < 1 || numeroMarchas > 7) throw new ValorNoValidoException(
                "El número de velocidades o marchas debe encontrarse en el siguiente rango: [1,7]");
        this.numeroMarchas = numeroMarchas;
    }

    /**
     * Comprueba el estado de la caja de cambios
     *
     * @return true la caja de  cambios funicona correctamente
     */
    public boolean isOperativo() {
        return estado;
    }

    @Override
    public String toString() {
        return "Numero de Marchas: " + numeroMarchas + ", estado: " + (estado ? "Correcto" : "Incorrecto");
    }
}
