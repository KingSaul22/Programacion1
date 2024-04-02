public class FicheroBinario extends Fichero{
    private byte[] contenido;

    /**
     *
     * @param name Nombre del Fichero Binario
     * @param contenido Recibe el tamaño un array en Bytes con los datos del fichero
     */
    public FicheroBinario(String name, byte[] contenido) throws FicheroException {
        super(name);
        setContenido(contenido);
    }

    public void setContenido(byte[] contenido) throws FicheroException{
        if (contenido.length < 1) throw new FicheroException("No puedes crear un fichero vacio");
        this.contenido = contenido;
    }

    @Override
    public long getSize() {
        return contenido.length;
    }
}
