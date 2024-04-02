package Model;

import Excepciones.RestauranteException;

import java.util.*;

public class Cocina {
    private Map<String, Integer> despensa;
    private List<Receta> platosPedidos;

    public Cocina() {
        despensa = new HashMap<>();
        platosPedidos = new LinkedList<>();
    }

    public boolean haySuficientesIngredientes(Map<String, Integer> ingredientes) {
        if (ingredientes.isEmpty()) return true;
        if (despensa.isEmpty()) return false;
        Set<String> nombres = ingredientes.keySet();
        for (String str : nombres) {
            if (despensa.get(str) == null || ingredientes.get(str) > despensa.get(str)) return false;
        }
        return true;
    }

    public void encolarPlato(Receta plato) throws RestauranteException {
        if (haySuficientesIngredientes(plato.getIngredientes()))
            throw new RestauranteException("No hay suficientes ingredientes");

        Map<String, Integer> ingredientes = plato.getIngredientes();
        for (Map.Entry<String, Integer> entry : ingredientes.entrySet()) {
            eliminarIngrediente(entry.getKey(), entry.getValue());
        }

        platosPedidos.add(plato);
    }

    public Receta cocinarPlato() throws RestauranteException {
        if (platosPedidos.isEmpty()) throw new RestauranteException("No hay pedidos por cocinar");
        return ((LinkedList<Receta>) platosPedidos).poll();
    }

    public void addIngrediente(String nombre, int cantidad) {
        Integer cantidadPrevia = despensa.putIfAbsent(nombre, cantidad);
        if (cantidadPrevia != null) despensa.replace(nombre, cantidadPrevia + cantidad);
    }

    private void eliminarIngrediente(String nombre, int cantidad) {
        if (despensa.get(nombre) == cantidad) {
            despensa.remove(nombre);
        } else {
            despensa.replace(nombre, despensa.get(nombre) - cantidad);
        }
    }
}
