package Model;

import java.util.ArrayList;
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

    public void addEquipo(Equipo e) throws LigaException {

    }

    public void eliminaEquipo(Equipo e) throws LigaException {

    }


    public void unirEquipos(Equipo e1, Equipo e2) throws LigaException {

    }

    public List<Jugador> jugadoresEnComun(Equipo e1, Equipo e2) throws LigaException {

    }

    public double mediaEdad() throws LigaException {

    }

    public List<Jugador> jugadoresOrdenadosEdad() {

    }

    public List<Jugador> jugadoresOrdenadosNombre() {

    }

    private Set<Jugador> todosLosJugadores() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bienvenidos a " + nombre).append(System.lineSeparator());
        sb.append("Equipos: ").append(System.lineSeparator());
        for (Equipo e : equipos) {
            sb.append(e).append(System.lineSeparator());
        }

        return sb.toString();

    }
}
