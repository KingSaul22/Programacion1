import Interfaces.Convertible;
import java.nio.charset.StandardCharsets;

public class FicheroTexto extends Fichero implements Convertible {
    protected String[][] contenido;

    public FicheroTexto(String name, String[] contenido) {
        super(name);
        setContenido(contenido);
    }

    public void setContenido(String[] contenido) {
        this.contenido = new String[contenido.length][1];

        for (int i = 0; i < contenido.length; i++) this.contenido[i][0] = contenido[i];
        //System.arraycopy(contenido, 0, this.contenido[0], 0, contenido.length);
    }

    @Override
    public long getSize() {
        StringBuilder cadenaConjunta = new StringBuilder();
        for (int i = 0; i < contenido.length; i++){
            if (contenido[i][0] != null) cadenaConjunta.append(contenido[i][0]);
        }

        return String.valueOf(cadenaConjunta).getBytes(StandardCharsets.UTF_8).length;
    }

    /**
     *
     * @return Un String que junta el array 'vertical' en una sola cadena.
     */
    @Override
    public String textToAudio() {
        StringBuilder cadenaConjunta = new StringBuilder();
        for (int i = 0; i < contenido.length; i++){
            if (contenido[i][0] != null) cadenaConjunta.append(i + 1).append(". ").append(contenido[i][0]).append(" ");
        }

        //return String.valueOf(cadenaConjunta);
        return cadenaConjunta.toString();
    }
}
