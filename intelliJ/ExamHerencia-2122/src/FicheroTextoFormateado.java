public class FicheroTextoFormateado extends FicheroTexto{
    private String fuente;
    private int tamFuente;
    private String colorFuente;

    public FicheroTextoFormateado(String name, long size, String[] contenido, String fuente, int tamFuente, String colorFuente) throws FicheroException {
        super(name, size, contenido);
        setFuente(fuente);
        setTamFuente(tamFuente);
        setColorFuente(colorFuente);
    }

    private void setFuente(String fuente) throws FicheroException{
        if (fuente.isBlank() || fuente.length() < 3) throw new FicheroException("No se ha introducido una fuente de texto valida");
        this.fuente = fuente;
    }

    public void setTamFuente(int tamFuente) throws FicheroException {
        if (tamFuente < 1) throw new FicheroException("El tamaño del texto no puede ser inferior a 1");
        this.tamFuente = tamFuente;
    }

    public void setColorFuente(String colorFuente) throws FicheroException{
        //if (colorFuente.length() != 7) throw new FicheroException("No se ha recibido el color en formato hexadecimal");
        if (!colorFuente.matches("#%06X")) throw new FicheroException("No se ha recibido el color en formato hexadecimal");
        this.colorFuente = colorFuente;
    }
}
