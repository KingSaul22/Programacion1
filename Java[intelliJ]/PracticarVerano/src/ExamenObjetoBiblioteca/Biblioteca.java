package ExamenObjetoBiblioteca;


import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private int contSocios;
    private List<Usuario> usuarios;
    private List<Libro> libros;

    public Biblioteca(String nombre) throws BibliotecaException {
        setNombre(nombre);
        this.contSocios = 0;
        this.usuarios = new ArrayList<>();
        this.libros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getContSocios() {
        return contSocios;
    }

    public void setNombre(String nombre) throws BibliotecaException {
        if (nombre.isBlank() || nombre.length() < 5) throw new BibliotecaException("Nombre de la biblioteca no valido");
        this.nombre = nombre;
    }

    public void registarUsuario(Usuario usuario) throws BibliotecaException {
        if (usuarios.contains(usuario)) {
            throw new BibliotecaException("Ya hay un usuario con ese dni asignado");
        }
        usuarios.add(usuario);
    }

    public void anadirSocio(Usuario usuario) throws BibliotecaException, ValorInvalidoException {
        int indiceUsuario = usuarios.indexOf(usuario);

        if (indiceUsuario == -1) {
            throw new BibliotecaException("El usuario no se encuentra en la base de datos");
        }

        usuarios.get(indiceUsuario).setNumSocio(++contSocios);
    }

    public void anadirLibro(Libro libro) throws BibliotecaException, ValorInvalidoException {
        int indiceLibro = libros.indexOf(libro);
        if (indiceLibro == -1) {
            libros.add(libro);
            throw new BibliotecaException("El libro no se ha encontrado en la base de datos, se ha añadido como un libro nuevo");
        }

        Libro libroList = libros.get(indiceLibro);
        libroList.setNumEjemplares(libroList.getNumEjemplares() + libro.getNumEjemplares());
        libroList.setEjemplDisponib(libroList.getEjemplDisponib() + libro.getEjemplDisponib());
        throw new BibliotecaException("Se han sumado los ejemplares disponibles a la base de datos");
    }

    public void prestarLibro(Libro libro, Usuario user) throws BibliotecaException, ValorInvalidoException {
        int indexUser = usuarios.indexOf(user);
        if (indexUser == -1) throw new BibliotecaException("Usuario no registrado");

        if (libro.getEjemplDisponib() == 0) {
            throw new BibliotecaException("No esta disponible el libro");
        }

        usuarios.get(indexUser).recogerLibro(libro);
        libro.setEjemplDisponib(libro.getEjemplDisponib() - 1);
    }

    public void devolverLibro(Libro libro, Usuario user) throws BibliotecaException, ValorInvalidoException {
        int indexUser = usuarios.indexOf(user);
        if (indexUser == -1) throw new BibliotecaException("Usuario no registrado");

        if (!usuarios.get(indexUser).devolverLibro(libro)) {
            throw new BibliotecaException("El usuario no tiene un prestamo con ese libro");
        }
        libro.setEjemplDisponib(libro.getEjemplDisponib() + 1);
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
