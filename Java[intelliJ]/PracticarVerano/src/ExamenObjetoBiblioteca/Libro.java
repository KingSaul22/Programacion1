package ExamenObjetoBiblioteca;

import java.util.Objects;

public class Libro {
    private String nombre;
    private String autor;
    private String sinopsis;
    private int numEjemplares;
    private int ejemplDisponib;

    public Libro(String nombre, String autor, String sinopsis, int numEjemplares) throws ValorInvalidoException {
        setNombre(nombre);
        setAutor(autor);
        setSinopsis(sinopsis);
        setNumEjemplares(numEjemplares);
        setEjemplDisponib(numEjemplares);
    }

    public void setNombre(String nombre) throws ValorInvalidoException {
        if (nombre == null || nombre.isBlank()) {
            throw new ValorInvalidoException("Nombre del libro invalido");
        }
        this.nombre = nombre;
    }

    public void setAutor(String autor) throws ValorInvalidoException {
        if (autor == null || autor.isBlank()) {
            throw new ValorInvalidoException("autor invalido");
        }
        this.autor = autor;
    }

    public void setSinopsis(String sinopsis) throws ValorInvalidoException {
        if (sinopsis == null || sinopsis.isBlank()) {
            throw new ValorInvalidoException("Sinopsis invalido");
        }
        this.sinopsis = sinopsis;
    }

    public void setNumEjemplares(int numEjemplares) throws ValorInvalidoException {
        if (numEjemplares < 1) {
            throw new ValorInvalidoException("Numero de ejemplares invalido");
        }
        this.numEjemplares = numEjemplares;
    }

    public void setEjemplDisponib(int ejemplDisponib) throws ValorInvalidoException {
        if (ejemplDisponib < 0) {
            throw new ValorInvalidoException("Ejemplares disponibles invalido");
        }
        this.ejemplDisponib = ejemplDisponib;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public int getEjemplDisponib() {
        return ejemplDisponib;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro libro)) return false;
        return Objects.equals(nombre, libro.nombre) && Objects.equals(autor, libro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, autor);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("nombre: ").append(nombre).append(", autor: ").append(autor);
        return sb.toString();
    }

    public String toSave() {
        return nombre + ";" + autor + ";" + sinopsis + ";" + numEjemplares;
    }
}
