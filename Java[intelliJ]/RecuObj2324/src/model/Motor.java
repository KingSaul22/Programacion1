package model;

import excepciones.ValorNoValidoException;

public class Motor {
    private String marca;
    private String modelo;
    private String numeroSerie;
    private double nivelAceite;
    private int kilometraje;
    private double nivelAgua;
    private double temperatura;

    /**
     * Clase Motor que incluye una serie de parametros que lo definen
     *
     * @param marca
     * @param modelo
     * @param numeroSerie Solo formado por  letras y números
     * @param nivelAceite En el rango 0 - 1
     * @param kilometraje Positivo
     * @param nivelAgua   En el rango 0 - 1
     * @param temperatura En el rango 0 - 120
     * @throws ValorNoValidoException Cuando alguno de los parametros no está dentro de rango
     */
    public Motor(String marca, String modelo, String numeroSerie, double nivelAceite, int kilometraje,
                 double nivelAgua, double temperatura) throws ValorNoValidoException {
        setNivelAceite(nivelAceite);
        setKilometraje(kilometraje);
        setNivelAgua(nivelAgua);
        setTemperatura(temperatura);
        setNumeroSerie(numeroSerie);
        this.marca = marca;
        this.modelo = modelo;
    }

    public void setNivelAceite(double nivelAceite) throws ValorNoValidoException {
        if (nivelAceite < 0 || nivelAceite > 1)
            throw new ValorNoValidoException("El nivel de aceite debe estar en el siguiente rango: [0,1]");
        this.nivelAceite = nivelAceite;
    }

    public void setKilometraje(int kilometraje) throws ValorNoValidoException {
        if (kilometraje < 0) throw new ValorNoValidoException("El kilometraje no puede ser inferior a 0");
        this.kilometraje = kilometraje;
    }

    public void setNivelAgua(double nivelAgua) throws ValorNoValidoException {
        if (nivelAgua < 0 || nivelAgua > 1)
            throw new ValorNoValidoException("El nivel de agua debe estar en el siguiente rango: [0,1]");
        this.nivelAgua = nivelAgua;
    }

    public void setTemperatura(double temperatura) throws ValorNoValidoException {
        if (temperatura < 0 || temperatura > 120)
            throw new ValorNoValidoException("El nivel de aceite debe estar en el siguiente rango: [0,120]");
        this.temperatura = temperatura;
    }

    public void setNumeroSerie(String numeroSerie) throws ValorNoValidoException {
        if (!numeroSerie.matches("[0-9A-Za-z]+")) throw new ValorNoValidoException(
                "El número de serie solo se compone por letras y números");
        this.numeroSerie = numeroSerie;
    }

    /**
     * Comprueba que todos los parametros del motor funcionen correctamente
     *
     * @return true si todos los parametros son correctos
     */
    public boolean isOperativo() {
        if (nivelAceite > 0.98 || nivelAceite < 0.96) return false;
        if (nivelAgua < 0.7) return false;
        if (temperatura > 95) return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Marca del motor: ").append(marca)
                .append(", modelo: ").append(modelo)
                .append(",  Numero de Serie: ").append(numeroSerie).append("\n")
                .append("  Kilometraje: ").append(kilometraje).append("\n")
                .append("  NivelAceite: ").append(nivelAceite).append("\n")
                .append("  NivelAgua: ").append(nivelAgua).append("\n")
                .append("  Temperatura: ").append(temperatura);
        return sb.toString();
    }
}
