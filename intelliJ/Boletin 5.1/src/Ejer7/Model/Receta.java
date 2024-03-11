package Ejer7.Model;

import Ejer7.Excepciones.IngredienteException;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Optional;

public class Receta {
    private String nombreReceta;
    private int tiempoPreparacion; //Medido en minutos
    private HashSet<Ingrediente> ingredientes;
    LinkedList<String> pasos;

    public Receta(String nombreReceta, int tiempoPreparacion) {
        this.nombreReceta = nombreReceta;
        this.tiempoPreparacion = tiempoPreparacion;
        this.ingredientes = new HashSet<>();
        this.pasos = new LinkedList<>();
    }

    public boolean necesitaIngrediente(String nombreIngrediente) {
        return ingredientes.stream().anyMatch(a -> a.getNombre().equals(nombreIngrediente));
    }

    public void aniadirIngrediente(Ingrediente ingredienteNuevo) {
        //ingredientes.stream().filter(ingredienteNuevo::equals).forEach(Ingrediente::addCantidad);
        Optional<Ingrediente> i = ingredientes.stream()
                .filter(a -> a.getNombre().equals(ingredienteNuevo.getNombre())).findFirst();

        if (i.isEmpty()) {
            ingredientes.add(ingredienteNuevo);
        } else {
            i.get().addCantidad(ingredienteNuevo.getCantidad());
        }
    }
}
