import java.util.*;

public class Main {
    private static Scanner sc;
    private static LinkedList<Pelicula> listaPeliculas = new LinkedList<>();

    public static void main(String[] args) {

        listaPeliculas.add(new Pelicula("Saul"));

        Optional<Pelicula> optionalPelicula = listaPeliculas.stream().filter(a -> a.getTitulo().equals("Saul")).findFirst();

        if (optionalPelicula.isEmpty()) System.out.println("No hay peliculas con ese titulo");
        Pelicula pelicula = optionalPelicula.get();

        pelicula.annadirOpinion("Cocacola");
        System.out.println(listaPeliculas.element());
    }
}