import java.time.LocalDateTime;

public abstract class Fichero {
    private String name;
    private long size;
    private LocalDateTime dateCreation;

    /**
     *
     * @param name Nombre del fichero
     * @param size Tamaño del fichero
     */
    public Fichero(String name, long size) {
        setSize(size);
        this.name = name;
        this.dateCreation = LocalDateTime.now();
    }

    public abstract long getSize();

    public String getName() {
        return name;
    }

    /**
     * @param size Tamaño recibido
     * @throws IllegalArgumentException Excepción para tamaños imposibles.
     */
    private void setSize(long size) {
        if (size < 1) throw new IllegalArgumentException("El tamaño del archivo no puede ser negativo");
        this.size = size;
    }
}
