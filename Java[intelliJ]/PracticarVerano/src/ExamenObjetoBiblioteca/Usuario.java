package ExamenObjetoBiblioteca;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private String nombre;
    private String apellidos;
    private String dni;
    private Integer numSocio;
    private List<Libro> librosRecogidos;

    public Usuario(String nombre, String apellidos, String dni) throws ValorInvalidoException {
        setNombre(nombre);
        setApellidos(apellidos);
        setDni(dni);
        this.numSocio = null;
        librosRecogidos = new LinkedList<>();
    }

    public Integer getNumSocio() {
        return numSocio;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Libro> getLibrosRecogidos() {
        return librosRecogidos;
    }

    public int numeroLibroRecogido() {
        return librosRecogidos.size();
    }

    public boolean devolverLibro(Libro libro) {
        return librosRecogidos.remove(libro);
    }

    public void recogerLibro(Libro libro) throws BibliotecaException {
        if (librosRecogidos.size() >= 5) {
            throw new BibliotecaException("Se ha alcanzado el limite de libro que puedes recoger.");
        }
        librosRecogidos.add(libro);
    }

    public void setNombre(String nombre) throws ValorInvalidoException {
        if (nombre == null || nombre.isBlank()) {
            throw new ValorInvalidoException("Nombre invalido");
        }
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) throws ValorInvalidoException {
        if (apellidos == null || apellidos.isBlank()) {
            throw new ValorInvalidoException("apellido invalido");
        }
        this.apellidos = apellidos;
    }

    public void setDni(String dni) throws ValorInvalidoException {
        if (!dni.matches("^\\d{8}[a-zA-Z]$")) {
            throw new ValorInvalidoException("Dni invalido");
        }
        this.dni = dni;
    }

    public void setNumSocio(Integer numSocio) throws ValorInvalidoException {
        if (numSocio == null) {
            eliminarNumeroSocio();
            return;
        }
        if (numSocio < 1) {
            throw new ValorInvalidoException("Número de Socio invalido");
        }
        this.numSocio = numSocio;
    }

    public String getDni() {
        return dni;
    }

    public void eliminarNumeroSocio() {
        this.numSocio = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(dni, usuario.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    public String toSave(List<Libro> libros) {
        StringBuilder librosPos = new StringBuilder(librosRecogidos.isEmpty() ? ";-1" : "");
        for (Libro librosRecogido : librosRecogidos) {
            librosPos.append(";").append(libros.indexOf(librosRecogido));
        }

        return nombre + ";" + apellidos + ";" + dni + librosPos;
    }
}