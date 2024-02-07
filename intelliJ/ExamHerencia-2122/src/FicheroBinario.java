public class FicheroBinario extends Fichero{
    private byte[] contenido;

    /**
     *
     * @param name Nombre del Fichero Binario
     * @param size Recibe el tamaño en bytes
     */
    public FicheroBinario(String name, byte[] contenido) {
        super(name, contenido.length);
        setContenido(contenido);
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }
}
