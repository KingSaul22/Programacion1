public class FicheroTexto extends Fichero implements Convertible{
    protected String[][] contenido;

    public FicheroTexto(String name, long size, String[] contenido) {
        super(name, size);
        setContenido(contenido);
    }

    public void setContenido(String[] contenido) {
        this.contenido = new String[1][contenido.length];

        for (int i = 0; i < contenido.length; i++) this.contenido[0][i] = contenido[i];
        //System.arraycopy(contenido, 0, this.contenido[0], 0, contenido.length);
    }

    @Override
    public long getSize() {
        return contenido[0].length;
    }

    /**
     *
     * @return Un String que junta el 'array vertical' en una sola cadena.
     */
    @Override
    public String textToAudio() {
        StringBuilder cadenaConjunta = new StringBuilder();
        for (int i = 0; i < contenido[0].length; i++){
            cadenaConjunta.append(" ").append(i + 1).append(". ").append(contenido[0][i]);
        }

        return String.valueOf(cadenaConjunta);
    }
}
