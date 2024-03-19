package Ejer1;

import java.util.ArrayList;
import java.util.HashSet;

public class Pelicula {
    private String titulo;
    private int annoEstreno;
    private ArrayList<Opinion> opiniones;
    private HashSet<String> actores;

    public Pelicula(String titulo, int annoEstreno) {
        super();
        this.titulo = titulo;
        this.annoEstreno = annoEstreno;
        actores = new HashSet<String>();
        opiniones = new ArrayList<Opinion>();
    }

    public void annadirOpinion(Opinion opinion) {
        opiniones.add(opinion);
    }

    public void annadirActor(String actor) {
        actores.add(actor);
    }


    public double mediaDeOpiniones() {
        return opiniones.stream().mapToInt(Opinion::getValoracion).average().orElse(0);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnnoEstreno() {
        return annoEstreno;
    }

    public void setAnnoEstreno(int annoEstreno) {
        this.annoEstreno = annoEstreno;
    }

    public HashSet<String> getCadenaActores() {
        return actores;
    }

    @Override
    public String toString() {
        return "Pelicula [titulo=" + titulo + ", annoEstreno=" + annoEstreno + "]" + " Media de opiniones " + mediaDeOpiniones();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pelicula other = (Pelicula) obj;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        return true;
    }

}

/*
¿Crees que la elección de un LinkedList de Películas, un ArrayList de Opiniones
 y un HashSet de actores es la adecuada? Justifica con argumentos la respuesta.


A) LinkedList -- Películas
    Existen métodos para el borrado de peliculas concretas por lo que, si se usara un ArrayList,
    el borrado implicaria mover todas las peliculas en posiciones mayores al borrado lo cual no es eficiente.

B) ArrayList -- Opiniones
    Los métodos relacionados con las opiniones no implican borrado sino simplemente buscar la media.
    Para ello necesitamos recorrer la lista cada vez que necesitemos ese valor, por lo que
    es mucho más eficiente usar un arrayList que un LinkedList.

C) HashSet -- Actores
    Un actor no se puede duplicar por lo que tiene sentido que sea un HashSet; ademas,
    como no tiene ningún atributo ademas de su nombre y no nos importa su orden,
    sino que simplemento nos sinteresa añadir actores y comprobar si ya están incluidos,
    un HashSet nos facilitará la tarea.
*/