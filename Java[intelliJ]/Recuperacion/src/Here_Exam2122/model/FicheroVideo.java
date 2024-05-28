package Here_Exam2122.model;

import Here_Exam2122.interfaces.Reproducibles;
import Obj_Ejer3.Excepciones.ValorNoValidoException;

public class FicheroVideo extends Fichero implements Reproducibles {

    private byte[] contenido;
    private int duracion;

    public FicheroVideo(String nombre, byte[] contenido, int duracion) throws ValorNoValidoException {
        super(nombre);
        setContenido(contenido);
        setDuracion(duracion);
    }

    public void setContenido(byte[] contenido) {
        if (contenido == null) contenido = new byte[0];
        this.contenido = contenido;
    }

    public void setDuracion(int duracion) throws ValorNoValidoException {
        if (duracion < 0) throw new ValorNoValidoException("La duración no puede ser negativa");
        if (contenido.length == 0) duracion = 0;
        this.duracion = duracion;
    }

    @Override
    public long getTamanio() {
        return contenido.length;
    }

    @Override
    public void reproducir() {
        System.out.println("Se esta reproduciendo el fichero " + getNombre());
    }
}
