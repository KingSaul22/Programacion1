import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Equipo {
    private String nombre;
    private Set<Jugador> jugadores;
    
    public Equipo(String nombre) {
        super();
        this.nombre = nombre;
        this.jugadores = new HashSet<>();
    }
    
    public void addJugador(Jugador j) {
        this.jugadores.add(j);
    }
    
    public Set<Jugador> getJugadores() {
        return jugadores;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Equipo other = (Equipo) obj;
        return Objects.equals(nombre, other.nombre);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(nombre).append(": ").append(System.lineSeparator());
        for (Jugador j: jugadores) {
            sb.append(j).append(System.lineSeparator());
        }
        
        return sb.toString();
    }
    
    
    
}
