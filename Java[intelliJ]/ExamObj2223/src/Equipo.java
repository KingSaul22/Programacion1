import java.util.List;

public class Equipo {
    private String pais;
    private String entrenador;
    private List<Jugador> jugadores;

    public Equipo(String pais, String entrenador) {
        this.pais = pais;
        this.entrenador = entrenador;
    }

}
