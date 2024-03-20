package Model;

import Excepciones.RestauranteException;

import java.util.List;
import java.util.Map;

public class Plato {
    private String nombre;
    private double duracionMin;
    private List<String> pasos;
    private Map<String, Integer> ingredientes;

    public Plato(String nombre, double duracionMin) {
        this.nombre = nombre;
        this.duracionMin = duracionMin;
    }

    public void addPaso(String paso) throws RestauranteException {
        if (paso.isBlank()) throw new RestauranteException("No se ha introducido un paso valido");

        pasos.add(paso);
    }

    public void addIngrediente(String nombre, int cantidad) {
        Integer cantidadPrevia = ingredientes.putIfAbsent(nombre, cantidad);
        if (cantidadPrevia != null) ingredientes.replace(nombre, cantidadPrevia + cantidad);
    }
}
