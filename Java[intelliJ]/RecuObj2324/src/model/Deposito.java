package model;

import excepciones.ValorNoValidoException;


public class Deposito {
    private int capacidad;
    private int nivelCombustible;
    private boolean presionCorrecta;

    /**
     * Deposito que incluye las caracteristicas básicas de este
     *
     * @param capacidad        Tamaño del deposito en Litros
     * @param nivelCombustible Combustible actual
     * @param presionCorrecta  Si hay presión correcta
     * @throws ValorNoValidoException Error en los rangos de los parametros
     */
    public Deposito(int capacidad, int nivelCombustible, boolean presionCorrecta) throws ValorNoValidoException {
        setCapacidad(capacidad);
        setNivelCombustible(nivelCombustible);
        this.presionCorrecta = presionCorrecta;
    }

    private void setCapacidad(int capacidad) throws ValorNoValidoException {
        if (capacidad < 1)
            throw new ValorNoValidoException("La capacidad del deposito no puede ser igual o inferior a cero");
        this.capacidad = capacidad;
    }

    private void setNivelCombustible(int nivelCombustible) throws ValorNoValidoException {
        if (nivelCombustible < 0)
            throw new ValorNoValidoException("No se puede asignar un valor negativo al nivel del combustible");
        if (nivelCombustible > capacidad)
            throw new ValorNoValidoException("El nivel del combustible no puede superar la capacidad del deposito");
        this.nivelCombustible = nivelCombustible;
    }

    public void setPresionCorrecta(boolean presionCorrecta) {
        this.presionCorrecta = presionCorrecta;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getNivelCombustible() {
        return nivelCombustible;
    }

    public boolean isPresionCorrecta() {
        return presionCorrecta;
    }

    /**
     * Comprueba que el deposito tiene la presión correcta y combustible
     *
     * @return true si funciona correctamente
     */
    public boolean isOperativo() {
        return nivelCombustible > 0 && presionCorrecta;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Capacidad del deposito: ").append(capacidad)
                .append(", nivel de combustible: ").append(nivelCombustible)
                .append(", presión: ").append(presionCorrecta ? "Correcta" : "Incorrecta");
        return sb.toString();
    }
}
