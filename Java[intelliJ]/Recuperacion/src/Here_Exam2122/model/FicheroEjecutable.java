package Here_Exam2122.model;

import Here_Exam2122.interfaces.Analizables;
import Obj_Ejer3.Excepciones.ValorNoValidoException;

public class FicheroEjecutable extends Fichero implements Analizables {

    private byte[] contenido;
    private String permisos;

    public FicheroEjecutable(String nombre, byte[] contenido, String permisos) throws ValorNoValidoException {
        super(nombre);
        setContenido(contenido);
        setPermisos(permisos);
    }

    public void setContenido(byte[] contenido) {
        if (contenido == null) contenido = new byte[0];
        this.contenido = contenido;
    }

    public void setPermisos(String permisos) throws ValorNoValidoException {
        if (!permisos.matches("[157]{3}")) throw new ValorNoValidoException("Formato de los permisos no valido");
        this.permisos = permisos;
    }

    @Override
    public long getTamanio() {
        return contenido.length;
    }

    @Override
    public void analizar() {
        System.out.println("Analizando el fichero" + getNombre());
    }
}
