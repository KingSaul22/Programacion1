import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Liga {
    private List<Equipo> equipos;
    private String nombre;
    
    public Liga(String nombre) {
        super();
        this.equipos = new ArrayList<>();
        this.nombre = nombre;
    }
    
    public int addEquipo(Equipo e) throws LigaException {
        if (e.getJugadores().size() == 0) {
            throw new LigaException("No puedes añadir un equipo vacío");
        }
        
        if (!equipos.contains(e)) {
            equipos.add(e);
            return equipos.size();
        }
        else {
            throw new LigaException("El equipo ya se había añadido");
        }
        
    }
    
    public int eliminaEquipo(Equipo e) throws LigaException {
        if (!equipos.contains(e)) {
            throw new LigaException("El equipo que buscas no juega en esta liga");
        }
        
        equipos.remove(e);
        return equipos.size();
    }
    
    
    public void unirEquipos(Equipo e1, Equipo e2) throws LigaException {
        if (equipos.contains(e1) && equipos.contains(e2)) {
            e1.getJugadores().addAll(e2.getJugadores());
        }
        else {
            throw new LigaException("Los dos equipos deben pertenecer a la liga");
        }
    }
    
    public List<Jugador> jugadoresEnComun(Equipo e1, Equipo e2) throws LigaException {
        if (equipos.contains(e1) && equipos.contains(e2)) {
            return e1.getJugadores().stream().filter(e2.getJugadores()::contains).toList();
        }
        else {
            throw new LigaException("Los equipos indicados no juegan en esta liga");
        }
    }
    
    public double mediaEdad() throws LigaException {
        
        
        LocalDate fechaActual = LocalDate.now();
                
        return todosLosJugadores().stream().mapToDouble(j -> {
            Period periodo = Period.between(j.getFechaNacimiento(), fechaActual);
            return periodo.getYears();
        }).average().orElseThrow(() -> new LigaException("No hay jugadores en la liga"));
    }
    
    public List<Jugador> jugadoresOrdenadosEdad() {
        return todosLosJugadores().stream().sorted().toList();
    }
    
    public List<Jugador> jugadoresOrdenadosNombre() {
        return todosLosJugadores().stream().sorted((j1, j2) -> j1.getNombre().compareTo(j2.getNombre())).toList();
    }
    
    public Set<Jugador> todosLosJugadores() {
        Set<Jugador> todosLosJugadores = new HashSet<>();
        equipos.stream().forEach(e -> todosLosJugadores.addAll(e.getJugadores()));
        return todosLosJugadores;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bienvenidos a " + nombre).append(System.lineSeparator());
        sb.append("Equipos: ").append(System.lineSeparator());
        for (Equipo e: equipos) {
            sb.append(e).append(System.lineSeparator());
        }
        
        return sb.toString();
        
    }
}
