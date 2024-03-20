package Model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Receta {
    private String nombre;
    private double duracionMin;
    private List<String> pasos;
    private Map<String, Integer> ingredientes;

    public Receta(String nombre, double duracionMin) {
        this.nombre = nombre;
        this.duracionMin = duracionMin;
        this.pasos = new LinkedList<>();
        this.ingredientes = new HashMap<>();
    }

    public void addPaso(String paso) {
        pasos.add(paso);
    }

    public void addIngrediente(String nombre, int cantidad) {
        Integer cantidadPrevia = ingredientes.putIfAbsent(nombre, cantidad);
        if (cantidadPrevia != null) ingredientes.replace(nombre, cantidadPrevia + cantidad);
    }
}
