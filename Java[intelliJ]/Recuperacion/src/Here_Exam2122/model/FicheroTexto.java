package Here_Exam2122.model;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public abstract class FicheroTexto extends Fichero {
    private String[] contenido;

    public FicheroTexto(String nombre, String[] contenido) {
        super(nombre);
        this.contenido = contenido;
    }

    @Override
    public long getTamanio() {
        /*
        StringBuilder parrafos = new StringBuilder();
        for (String parrafo : contenido) parrafos.append(parrafo);
        return String.valueOf(parrafos).getBytes(StandardCharsets.UTF_8).length;
        */
        return Arrays.toString(contenido).getBytes(StandardCharsets.UTF_8).length;
    }
}
