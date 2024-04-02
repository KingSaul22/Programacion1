package Model;

import Excepciones.MazoException;

import java.util.*;
import java.util.stream.Stream;

public class Mazo {
    private Map<Cromo, Integer> mazo;

    public Mazo() {
        this.mazo = new HashMap<>();
    }

    public void addCromo(Cromo cromo) {
        addCromo(cromo, 1);
    }

    public void addCromo(Cromo cromo, int cantidad) {
        Integer numCromos = mazo.putIfAbsent(cromo, cantidad);
        if (numCromos != null) mazo.replace(cromo, numCromos + cantidad);
    }

    private void deleteCromo(Cromo cromo) {
        Integer cantidad = mazo.get(cromo);
        if (cantidad == 1) {
            mazo.remove(cromo);
        } else {
            mazo.replace(cromo, --cantidad);
        }
    }

    public void intercambiar(Cromo cromoParaCambiar, Cromo cromoDelOtro) throws MazoException {
        if (!mazo.containsKey(cromoParaCambiar)) throw new MazoException("No dispones de este cromo");
        deleteCromo(cromoParaCambiar);
        addCromo(cromoDelOtro);
    }

    public void mezclar(Mazo m2) {
        /*for (Cromo cromo : m2.mazo.keySet()) {
            addCromo(cromo, m2.mazo.get(cromo));
        }*/
        for (Map.Entry<Cromo, Integer> entrada : m2.mazo.entrySet()) {
            addCromo(entrada.getKey(), entrada.getValue());
        }
    }

    public int contarDiferentes() {
        return mazo.size();
    }

    public List<Cromo> cromosDeUnEquipo(String equipoMostrar) {
        return mazo.keySet().stream().filter(a -> a.getNombre().equals(equipoMostrar)).toList();
    }

    public double alturaMedia(String equipoAltura) throws MazoException {
        return cromosDeUnEquipo(equipoAltura).stream()
                .filter(a -> a instanceof Jugador)
                .mapToInt(a -> ((Jugador) a).getAltura()).average()
                .orElseThrow(() -> new MazoException("No hay jugadores en el equipo " + equipoAltura));
    }

    public List<Cromo> getLista() {
        //Sin repetidos
        //return new LinkedList<>(mazo.keySet());
        //return mazo.keySet().stream().toList();

        //Con repetidos
        return mazo.entrySet().stream().flatMap(entry -> {
                    Cromo[] cromos = new Cromo[entry.getValue()];
                    for (int i = 0; i < entry.getValue(); i++) {
                        cromos[i] = entry.getKey();
                    }

                    return Stream.of(cromos);
                }
        ).toList();
    }

    public List<Cromo> ordenar() {
        return getLista().stream().sorted((a, b) -> a.getClass() == b.getClass() ?
                        a.getNombre().compareTo(b.getNombre()) : ((a instanceof Escudo) ? -1 : 1))
                .toList();
    }

    public List<Cromo> equipoCompleto() {
        /*List<Cromo> equiposCompletos = new ArrayList<>();

        for (Cromo escudo : mazo.keySet().stream().filter(a -> a instanceof Escudo).toList()) {
            List<Cromo> equipo = new ArrayList<>();
            mazo.keySet().stream()
                    .filter(a -> a instanceof Jugador)
                    .filter(a -> a.getEquipo().equals(escudo.getEquipo()))
                    .forEach(equipo::add);

            if (equipo.size() == ((Escudo) escudo).getNumJugadores()) {
                equiposCompletos.add(escudo);
                equiposCompletos.addAll(equipo);
            }
        }

        return equiposCompletos;*/

        return mazo.keySet().stream().filter(a -> a instanceof Escudo).flatMap(escudo -> {
                    List<Cromo> equipo = new ArrayList<>(cromosDeUnEquipo(escudo.getEquipo()));
                    equipo.add(escudo);
                    equipo.addAll(cromosDeUnEquipo(escudo.getEquipo()));
                    return equipo.size() - 1 == ((Escudo) escudo).getNumJugadores() ? equipo.stream() : Stream.empty();
                })
                .toList();
    }

    public List<String> nombreEquipoCompleto() {
        /*return mazo.keySet().stream().filter(a -> a instanceof Escudo).flatMap(escudo -> {
                    List<Cromo> equipo = new ArrayList<>();
                    equipo.add(escudo);
                    equipo.addAll(mazo.keySet().stream().filter(j -> j instanceof Jugador)
                            .filter(j -> j.getEquipo().equals(escudo.getEquipo()))
                            .toList());

                    return equipo.size() - 1 == ((Escudo) escudo).getNumJugadores() ?
                            Stream.of(escudo.getEquipo()) : Stream.empty();
                })
                .toList();
        */

        /*return mazo.keySet().stream().filter(a -> a instanceof Escudo).filter(escudo -> {
            long numJug = mazo.keySet().stream().filter(a -> a.getEquipo().equals(escudo.getEquipo())).count();
            return ((Escudo) escudo).getNumJugadores() == --numJug;
        }).flatMap(a -> Stream.of(a.getEquipo())).toList();
        */

        return mazo.keySet().stream().filter(a -> a instanceof Escudo)
                .filter(a -> cromosDeUnEquipo(a.getEquipo()).size() - 1 == ((Escudo) a).getNumJugadores())
                .map(Cromo::getEquipo).toList();
    }
}
