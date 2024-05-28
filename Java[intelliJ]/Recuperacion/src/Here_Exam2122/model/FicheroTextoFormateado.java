package Here_Exam2122.model;

import Here_Exam2122.interfaces.Analizables;
import Obj_Ejer3.Excepciones.ValorNoValidoException;

public class FicheroTextoFormateado extends FicheroTexto implements Analizables {
    private String tipoFuente;
    private int tamanioFuente;
    private String colorFuente;

    public FicheroTextoFormateado(String nombre, String[] contenido, String tipoFuente, int tamanioFuente, String colorFuente) throws ValorNoValidoException {
        super(nombre, contenido);
        setTipoFuente(tipoFuente);
        setTamanioFuente(tamanioFuente);
        setColorFuente(colorFuente);
    }

    public void setTipoFuente(String tipoFuente) throws ValorNoValidoException {
        if (tipoFuente.isBlank()) throw new ValorNoValidoException("Tipo de fuente no valida");
        this.tipoFuente = tipoFuente;
    }

    public void setTamanioFuente(int tamanioFuente) throws ValorNoValidoException {
        if (tamanioFuente < 1) throw new ValorNoValidoException("Valor de tamaño de fuente no valido");
        this.tamanioFuente = tamanioFuente;
    }

    public void setColorFuente(String colorFuente) throws ValorNoValidoException {
        if (!colorFuente.matches("([0-9A-Za-z]{3} | [0-9A-Za-z]{6})"))
            throw new ValorNoValidoException("Valor de color de la fuente no valido");
        this.colorFuente = colorFuente;
    }

    public String getTipoFuente() {
        return tipoFuente;
    }

    public int getTamanioFuente() {
        return tamanioFuente;
    }

    public String getColorFuente() {
        return colorFuente;
    }

    @Override
    public void analizar() {
        System.out.println("Analizando el fichero" + getNombre());
    }
}
