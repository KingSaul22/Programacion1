import java.util.ArrayList;

public class Pelicula {
    private String titulo;
    private ArrayList<String> opiniones;

    public Pelicula(String titulo) {
        this.titulo = titulo;
        this.opiniones = new ArrayList<>();
    }

    public void annadirOpinion(String opinion) {
        opiniones.add(opinion);
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", opiniones=" + opiniones +
                '}';
    }
}
