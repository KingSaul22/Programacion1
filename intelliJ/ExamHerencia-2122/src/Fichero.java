import java.time.LocalDateTime;

public class Fichero {
    private String name;
    private long size;
    private LocalDateTime dateCreation;

    public Fichero(String name, long size) {
        setSize(size);
        this.name = name;
        this.dateCreation = LocalDateTime.now();
    }

    public long getSize() {
        return size;
    }

    /**
     * @param size
     * @throws IllegalArgumentException
     */
    private void setSize(long size) {
        if (size < 1) throw new IllegalArgumentException("El tamaño del archivo no puede ser negativo");
        this.size = size;
    }
}
