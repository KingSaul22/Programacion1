package Ejer1;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class PeliculasDeUnTema {

    private String tema;
    private LinkedList<Pelicula> listaPeliculasDeUnTema;

    public PeliculasDeUnTema(String tema) {
        this.tema = tema;
        listaPeliculasDeUnTema = new LinkedList<>();
    }

    public String getTema() {
        return getTema();
    }

    public void addPelicula(Pelicula pelicula) throws NetPleaseException {
        if (pelicula == null || listaPeliculasDeUnTema.contains(pelicula)) {
            throw new NetPleaseException("Error, la pelicula no es valida. Asegurese de que no se haya introducido ya");
        }
        if (LocalDate.now().getYear() < pelicula.getAnnoEstreno()) {
            throw new NetPleaseException("El año de estreno es invalido");
        }

        listaPeliculasDeUnTema.add(pelicula);
    }

    public void borrarLasPeliculasDeUnAnno(int anno) throws NetPleaseException {
        /*List<Pelicula> peliculasConAnno = listaPeliculasDeUnTema.stream()
                .filter(a -> a.getAnnoEstreno() == anno).toList();

        if (peliculasConAnno.isEmpty()) throw new NetPleaseException("No hay peliculas con ese año");

        peliculasConAnno.forEach(a -> listaPeliculasDeUnTema.remove(a));
        */

        /*Iterator<Pelicula> it = listaPeliculasDeUnTema.iterator();
        while (it.hasNext()) {
            if (it.next().getAnnoEstreno() == anno) it.remove();
        }*/

        if (!listaPeliculasDeUnTema.removeIf(pelicula -> pelicula.getAnnoEstreno() == anno)) {
            throw new NetPleaseException("No hay peliculas con ese año");
        }

        /*listaPeliculasDeUnTema.stream().filter(a -> a.getAnnoEstreno() == anno)
                .forEach(a -> listaPeliculasDeUnTema.remove(a));
        */
    }

    public void annadirOpinionAPelicula(String tituloPelicula, Opinion opinion) throws NetPleaseException {
        Pelicula pelicula = listaPeliculasDeUnTema.stream().filter(a -> a.getTitulo().equals(tituloPelicula))
                .findAny().orElseThrow(() -> new NetPleaseException("No hay peliculas con ese titulo"));

        pelicula.annadirOpinion(opinion);


        /*listaPeliculasDeUnTema.stream().filter(a -> a.getTitulo().equals(tituloPelicula))
                .findAny().orElseThrow(() -> new NetPleaseException("No hay peliculas con ese titulo"))
                .annadirOpinion(opinion);*/


        /*Pelicula peli = buscarPeliculaPorTitulo(tituloPelicula);
        if (peli == null) throw new NetPleaseException("o hay peliculas con ese titulo");
        peli.annadirOpinion(opinion);*/
    }

    public List<Pelicula> listadoDePeliculasOrdenadasPorMediaDeOpiniones() {
        return listaPeliculasDeUnTema.stream()
                .sorted((a, b) -> Double.compare(b.mediaDeOpiniones(), a.mediaDeOpiniones())).toList();


        /*listaPeliculasDeUnTema.sort((a, b) -> Double.compare(b.mediaDeOpiniones(), a.mediaDeOpiniones()));
        return listaPeliculasDeUnTema;*/
    }


    public List<Pelicula> listaPeliculasDondeIntervieneUnActor(String actor) {
        //return listaPeliculasDeUnTema.stream().filter(a -> a.getCadenaActores().contains(actor)).toList();
        return listaPeliculasDeUnTema.stream().filter(a -> a.intervieneActor(actor)).toList();
    }

    public Pelicula buscarPeliculaPorTitulo(String titulo) {
        return listaPeliculasDeUnTema.stream().filter(a -> a.getTitulo().equals(titulo)).findFirst().orElse(null);
    }

    public void borrar(String titulo) throws NetPleaseException {
        if (listaPeliculasDeUnTema.isEmpty()) throw new NetPleaseException("No hay una pelicula en este tema");
        if (!listaPeliculasDeUnTema.remove(titulo)) throw new NetPleaseException("No hay una pelicula con ese titulo");
    }

    public boolean borrarB(String titulo) {
        return listaPeliculasDeUnTema.removeIf(a -> a.getTitulo().equals(titulo));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tema == null) ? 0 : tema.hashCode());
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
        PeliculasDeUnTema other = (PeliculasDeUnTema) obj;
        if (tema == null) {
            if (other.tema != null)
                return false;
        } else if (!tema.equals(other.tema))
            return false;
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tema " + tema + "\n");
        for (Pelicula pelicula : listaPeliculasDeUnTema) {
            sb.append(pelicula + "\n");
        }
        return sb.toString();
    }


}
