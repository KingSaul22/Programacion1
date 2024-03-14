package Ejer7.Model;

import Ejer7.Excepciones.RecetaException;

import java.util.*;

public class Recetario {
    private HashMap<String, Receta> recetas;

    public Recetario() {
        this.recetas = new HashMap<>();
    }

    public void aniadirReceta(Receta recetaNueva) throws RecetaException {
        if (recetas.containsKey(recetaNueva.getNombreReceta())) {
            throw new RecetaException("La receta indicada ya se encuentra en el recetario");
        }
        recetas.put(recetaNueva.getNombreReceta(), recetaNueva);
    }

    public String listadoRecetasOrdenadasAlfabeticamente() throws RecetaException {
        if (recetas.isEmpty()) throw new RecetaException("No hay recetas en el recetario");

        StringBuilder cadena = new StringBuilder("El recetario contiene las siguientes recetas:");
        recetas.values().stream().sorted((a, b) -> a.getNombreReceta().compareTo(b.getNombreReceta()))
                .forEach(a -> cadena.append("\n  · ").append(a.getNombreReceta())
                        .append(". (").append(a.getTiempoPreparacion()).append(" min)"));

        return cadena.toString();
    }

    public String listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion(String ingrediente) throws RecetaException {
        if (recetas.isEmpty()) throw new RecetaException("No hay recetas en el recetario");

        StringBuilder cadena = new StringBuilder("Recetas que incluyen " + ingrediente + " como ingrediente:");
        recetas.values().stream().filter(a -> a.necesitaIngrediente(ingrediente))
                .sorted().forEach(a ->
                        cadena.append("\n  · ").append(a.getNombreReceta())
                                .append(". (").append(a.getTiempoPreparacion()).append(" min)")
                                .append("\n    Ingredientes: ").append(getListaIngredientes(a))
                                //.append("\n    Ingredientes: ").append(Arrays.toString(a.getIngredientes().toArray()))
                );
        return cadena.toString();
    }

    private String getListaIngredientes(Receta receta) {
        StringBuilder cadena= new StringBuilder();
        receta.getIngredientes().stream().forEach( a ->
                cadena.append("\n    - ").append(a)
        );

        return cadena.toString();
    }
}
