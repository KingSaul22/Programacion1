public class FicheroEjecutable extends Fichero{
    private byte[] contenido;
    private int permisos;

    public FicheroEjecutable(String name, byte[] contenido, int permisos) throws FicheroException {
        super(name);
        setContenido(contenido);
        setPermisos(permisos);
    }

    public void setContenido(byte[] contenido) throws FicheroException{
        if (contenido.length < 1) throw new FicheroException("No puedes crear un fichero ejecutable vacio");
        this.contenido = contenido;
    }

    private void setPermisos(int permisos) throws FicheroException {
        String auxPermisos = String.valueOf(permisos);
        //if (!auxPermisos.matches("%3O") || auxPermisos.contains("0"))
        //    throw new FicheroException("El formato introducido para los permisos no es correcto");
        if (!auxPermisos.matches("^[1-7]{3}$")) throw new FicheroException("El formato introducido para los permisos no es correcto");
        this.permisos = permisos;
    }

    @Override
    public long getSize() {
        return contenido.length;
    }
}
