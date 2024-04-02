import java.time.LocalDateTime;

public abstract class Fichero {
    private String name;
    private LocalDateTime dateCreation;

    /**
     *
     * @param name Nombre del fichero
     */
    public Fichero(String name) {
        this.name = name;
        this.dateCreation = LocalDateTime.now();
    }

    public abstract long getSize();

    public String getName() {
        return name;
    }
}
