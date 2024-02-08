public class FicheroImagen extends Fichero{
    private byte[] contenido;
    private TFormatoImagen formato;

    public FicheroImagen(String name, byte[] contenido, TFormatoImagen formato) throws FicheroException {
        super(name);
        setContenido(contenido);
        setFormato(formato);
    }

    public void setContenido(byte[] contenido) throws FicheroException{
        if (contenido.length < 1) throw new FicheroException("No puedes crear un fichero de imagen vacio");
        this.contenido = contenido;
    }

    public void setFormato(TFormatoImagen formato) {
        this.formato = formato;
    }

    @Override
    public long getSize() {
        return contenido.length;
    }
}
