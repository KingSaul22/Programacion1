public class FicheroVideo extends Fichero{
    private int duracionSegundos;
    private byte[] contenido;

    public FicheroVideo(String name, int duracionSegundos, byte[] contenido) throws FicheroException {
        super(name);
        setDuracionSegundos(duracionSegundos);
        setContenido(contenido);
    }

    public void setDuracionSegundos(int duracionSegundos) throws FicheroException{
        if (duracionSegundos < 1) throw new FicheroException("La duración del fichero de video no puede ser inferior a 1");
        this.duracionSegundos = duracionSegundos;
    }

    public void setContenido(byte[] contenido) throws FicheroException{
        if (contenido.length < 1) throw new FicheroException("No puedes crear un fichero de video vacio");
        this.contenido = contenido;
    }

    @Override
    public long getSize() {
        return contenido.length;
    }
}
