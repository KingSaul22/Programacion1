package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cocina {
    private Map<String, Integer> despensa;

    public Cocina() {
        despensa = new HashMap<>();
    }

    public boolean haySuficientesIngredientes(Map<String, Integer> ingredientes) {
        Set<String> nombres = ingredientes.keySet();
        for (String str : nombres) {
            if (ingredientes.get(str) > despensa.get(str)) return false;
        }
        return true;
    }

    public void addIngrediente(String nombre, int cantidad) {
        Integer cantidadPrevia = despensa.putIfAbsent(nombre, cantidad);
        if (cantidadPrevia != null) despensa.replace(nombre, cantidadPrevia + cantidad);
    }
}
