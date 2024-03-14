package Ejer7.Model;

import Ejer7.Excepciones.RecetaException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;

public class Receta implements Comparable<Receta>{
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

    public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException {
        if(!ingredientes.remove(ingredienteABorrar)) {
            throw new RecetaException("El ingrediente que quieres borrar no se encuentra en la receta");
        }

        pasos.stream().filter(s -> s.contains(ingredienteABorrar.getNombre())).forEach(s -> pasos.remove(s));
        
        /*Optional<Ingrediente> i = ingredientes.stream()
                .filter(a -> a.getNombre().equals(ingredienteABorrar.getNombre())).findFirst();

        if (i.isEmpty()) {
            throw new RecetaException("El ingrediente que quieres borrar no se encuentra en la receta");
        }

        ingredientes.remove(i.get());
        pasos.removeIf(s -> s.contains(ingredienteABorrar.getNombre()));*/
        /*Iterator<String> iterador = pasos.iterator();
        while (iterador.hasNext()) {
            if (iterador.next().contains(ingredienteABorrar.getNombre())){
                iterador.remove();
            }
        }*/
    }

    public void aniadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException {
        int posPaso = pasos.indexOf(pasoExistente);
        if (posPaso == -1) throw new RecetaException("No existe ningún paso como el indicado");
        pasos.add(++posPaso, pasoNuevo);

        /*Iterator<String> iterador = pasos.iterator();
        for (int i = 0; iterador.hasNext(); i++){
            if (iterador.next().equals(pasoExistente)) {
                pasos.add(++i, pasoNuevo);
                break;
            }
        }*/
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public HashSet<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    @Override
    public int compareTo(Receta other) {
        return tiempoPreparacion - other.tiempoPreparacion;
    }
}
