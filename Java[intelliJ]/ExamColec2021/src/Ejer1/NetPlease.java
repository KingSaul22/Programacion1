package Ejer1;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class NetPlease {

    //Hashmap donde por cada tema, podemos acceder a las películas de ese tema
    private HashMap<String, PeliculasDeUnTema> mapPeliculas;


    public NetPlease() {
        mapPeliculas = new HashMap<String, PeliculasDeUnTema>();

    }

    public void annadirTema(String tema) throws NetPleaseException {

        tema = tema.toUpperCase();
        if (mapPeliculas.containsKey(tema)) {
            throw new NetPleaseException("Ya existe ese tema");
        }

        mapPeliculas.put(tema, new PeliculasDeUnTema(tema));
    }


    public void addPelicula(String tema, Pelicula pelicula) throws NetPleaseException {
        PeliculasDeUnTema listaPeliculasDeUnTema = mapPeliculas.get(tema);

        if (listaPeliculasDeUnTema == null) throw new NetPleaseException("No existe el tema " + tema);

        listaPeliculasDeUnTema.addPelicula(pelicula);
    }

    public void listadoDeTodasPeliculasDeTodosLosTemas() {

        for (PeliculasDeUnTema listaPelisTema : mapPeliculas.values()) {
            System.out.println(listaPelisTema);
        }
    }

    public void borrarPeliculaDeUnTema(String tema, String titulo) throws NetPleaseException {
        PeliculasDeUnTema pelisConTema = mapPeliculas.get(tema);
        if (pelisConTema == null) throw new NetPleaseException("No existen peliculas con ese tema");
        //pelisConTema.borrar(titulo);

        if (!pelisConTema.borrarB(tema)) throw new NetPleaseException("No existia una pelicula con ese titulo");
    }


    public String temaDePelicula(String titulo) throws NetPleaseException {
        PeliculasDeUnTema peliculasConTitulo;
        try {
            peliculasConTitulo = mapPeliculas.values().stream()
                    .filter(a -> a.buscarPeliculaPorTitulo(titulo) != null)
                    .findFirst().orElseThrow();
        } catch (NoSuchElementException e) {
            throw new NetPleaseException("No hay una pelicula con ese titulo");
        }

        return peliculasConTitulo.getTema();
    }


}
