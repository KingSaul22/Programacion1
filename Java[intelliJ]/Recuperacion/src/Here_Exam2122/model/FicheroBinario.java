package Here_Exam2122.model;

public class FicheroBinario extends Fichero {
    private byte[] contenido;

    public FicheroBinario(String nombre, byte[] contenido) {
        super(nombre);
        this.contenido = contenido;
    }

    @Override
    public long getTamanio() {
        return contenido.length;
    }
}
