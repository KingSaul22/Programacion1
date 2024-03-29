package Model;

import Excepciones.MazoException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return mazo.keySet().stream().toList();
    }

    public List<Cromo> ordenar() {
        return getLista().stream().sorted((a, b) ->
                        a.getClass() == b.getClass() ? a.getNombre().compareTo(b.getNombre())
                                                     : ((a instanceof Escudo) ? -1 : 1))
                .toList();
    }

    public List<Cromo> equipoCompleto() {
    }
}
