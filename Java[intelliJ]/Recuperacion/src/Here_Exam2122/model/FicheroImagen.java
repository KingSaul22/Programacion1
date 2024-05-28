package Here_Exam2122.model;

import Here_Exam2122.enums.TFormatoImagen;

public class FicheroImagen extends Fichero{
    private byte[] contenido;
    TFormatoImagen formatoImagen;

    public FicheroImagen(String nombre, TFormatoImagen formatoImagen, byte[] contenido) {
        super(nombre);
        this.formatoImagen = formatoImagen;
        setContenido(contenido);
    }

    public void setContenido(byte[] contenido) {
        if (contenido == null) contenido = new byte[0];
        this.contenido = contenido;
    }

    @Override
    public long getTamanio() {
        return contenido.length;
    }
}
