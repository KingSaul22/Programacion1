package Model;

import Excepciones.RestauranteException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurante {
    private Cocina cocina;
    private String nombre;
    private Map<String, Receta> menu;

    public Restaurante(String nombre) {
        this.nombre = nombre;
        this.cocina = new Cocina();
        this.menu = new HashMap<>();
    }

    public void incluirReceta(Receta r) {
        //TODO: Existen pasos e ingredientes(?)
        menu.put(r.getNombre(), r);
    }

    public List<Receta> listaRecetasDisponibles() throws RestauranteException {
        if (menu.isEmpty()) throw new RestauranteException("No hay recetas en el menu");

        return menu.values().stream().filter(this::recetaDisponible).toList();
    }

    public Receta getRecetaConcreta(String nombre) throws RestauranteException {
        Receta plato = menu.get(nombre);
        if (plato == null) throw new RestauranteException("No hay recetas con ese nombre");
        return menu.get(nombre);
    }

    public boolean recetaDisponible(String nombre) throws RestauranteException {
        Receta plato = menu.get(nombre);
        if (plato == null) throw new RestauranteException("No hay recetas con ese nombre");

        return recetaDisponible(plato);
    }

    public boolean recetaDisponible(Receta plato) {
        return cocina.haySuficientesIngredientes(plato.getIngredientes());
    }

    public void masIngrediente(String nombre, int cantidad) {
        cocina.addIngrediente(nombre, cantidad);
    }
}
