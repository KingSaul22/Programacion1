package Model;

import Excepciones.LigaException;

import java.util.*;

public class Liga {
    private List<Equipo> equipos;
    private String nombre;

    public Liga(String nombre) {
        super();
        this.equipos = new ArrayList<>();
        this.nombre = nombre;
    }

    public void addEquipo(Equipo e) throws LigaException {
        if (e.getJugadores().isEmpty()) throw new LigaException("El equipo que quieres añadir no tiene jugadores");
        if (equipos.contains(e)) throw new LigaException("El equipo ya estaba añadido");

        equipos.add(e);
    }

    public void eliminaEquipo(Equipo e) throws LigaException {
        if (!equipos.remove(e)) throw new LigaException("Ese equipo no estaba inscrito");
    }


    public void unirEquipos(Equipo e1, Equipo e2) throws LigaException {
        if (!equipos.contains(e1) || !equipos.contains(e2)) {
            throw new LigaException("Los dos equipos deben estar inscritos");
        }

        e1.addJugadores(e2.getJugadores());
    }

    public List<Jugador> jugadoresEnComun(Equipo e1, Equipo e2) throws LigaException {
        if (!equipos.contains(e1) || !equipos.contains(e2)) {
            throw new LigaException("Los dos equipos deben estar inscritos");
        }

        Set<Jugador> jugadores = new HashSet<>(e1.getJugadores());
        jugadores.retainAll(e2.getJugadores());

        return jugadores.stream().toList();

        /*List<Jugador> jugadoresComunes = new LinkedList<>(e1.getJugadores());
        jugadoresComunes.addAll(e2.getJugadores());

        return jugadoresComunes.stream().filter().toList();*/
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
