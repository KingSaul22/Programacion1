package ExamenObjetoBiblioteca;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Main {

    private static Biblioteca biblioteca;

    public static void main(String[] args) {
        System.out.println("BIENVENIDO A LA BIBLIOTECA");
        do {
            seleccionarBiblioteca();
        } while (biblioteca == null);

        int opcion;
        do {
            menu();
            opcion = MIEntradaSalida2_0.leerEnteroDeRango("Seleccione una opción", 1, 8);
            switch (opcion) {
                case 1:
                    usuarioSocio();
                    break;
                case 2:
                    nuevoLibro();
                    break;
                case 3:
                    prestamoLibro();
                    break;
                case 4:
                    devolverPrestamo();
                    break;
                case 5:
                     verEstadisticas();
                     break;
                case 6:
                case 8:
                    guardado();
                    break;
                case 7:
                    guardado();
                    do {
                        seleccionarBiblioteca();
                    } while (biblioteca == null);
                    break;
            }

        } while (opcion != 8);

        System.out.println("Gracias por su trabajo.");
    }

    private static void seleccionarBiblioteca() {
        System.out.println("""
                1)Nueva partida
                2)Selecionar partida
                3)Salir del juego
                """);

        int option = MIEntradaSalida2_0.leerEnteroDeRango("Selección", 1, 3);
        if (option == 1) {
            while (true) {
                String nombre = MIEntradaSalida2_0.leerCadena("Introduce el nombre de la nueva biblioteca:");
                try {
                    biblioteca = new Biblioteca(nombre);
                    break;
                } catch (BibliotecaException e) {
                    System.out.println(e.getMessage());
                }
            }

        } else if (option == 2) {
            try (Stream<Path> saves = Files.list(Paths.get(".\\src\\ExamenObjetoBiblioteca\\")).filter(Files::isDirectory)) {
                List<Path> savesCarpeta = saves.toList();
                for (int i = 0; i < savesCarpeta.size(); i++) {
                    System.out.println(i + ". " + savesCarpeta.get(i).getFileName());
                }
                option = MIEntradaSalida2_0.leerEnteroDeRango("Seleccione partida", 0, savesCarpeta.size() - 1);
                System.out.println("Has seleccionado la partida: " + savesCarpeta.get(option).getFileName());
                biblioteca = new Biblioteca(savesCarpeta.get(option).getFileName().toString());

                System.out.println("""
                        1)Inciar partida
                        2)Ver estadistica de partida
                        3)Borrar partida
                        """);
                option = MIEntradaSalida2_0.leerEnteroDeRango("Seleciona la siguinete opcion:", 1, 3);
                switch (option) {
                    case 1:
                        cargarDatos();
                        break;
                    case 2:
                        cargarDatos();
                        verEstadisticas();
                        biblioteca = null;
                        break;
                    case 3:
                        //TODO: Método que borre carpetas y todo lo de su interior
                        Path save = Paths.get(".\\src\\ExamenObjetoBiblioteca\\" + biblioteca.getNombre());
                        Files.deleteIfExists(Paths.get(save + "LibrosSave.txt"));
                        Files.deleteIfExists(Paths.get(save + "UsuariosSave.txt"));
                        Files.delete(save);
                        System.out.println("Se ha borrado correctamente");
                        biblioteca = null;
                        break;
                }

            } catch (IOException | BibliotecaException e) {
                System.out.println("Error:" + e.getMessage());
            }

        } else {
            System.out.println("Hasta la próxima");
            System.exit(0);
        }
    }

    private static void verEstadisticas() {
        System.out.println("Estadistacas de la patida: " + biblioteca.getNombre());
        int numUser = biblioteca.getUsuarios().size(), numSocios = biblioteca.getContSocios(),
                numLibrosDiff = biblioteca.getLibros().size(),
                numLibrosTotal = biblioteca.getLibros().stream().mapToInt(Libro::getNumEjemplares).sum(),
                numLibrosPrestados = biblioteca.getLibros().stream().mapToInt(libro ->
                        libro.getNumEjemplares() - libro.getEjemplDisponib()).sum();

        System.out.printf("""
                        1)Número dew usuarios: %d
                        2)Número de socios: %d
                        3)Número de Libros Diferentes: %d
                        4)Total de Libros: %d
                        5)Número de libros prestados: %d
                        -----------------------------------
                        
                        """,
                numUser, numSocios, numLibrosDiff, numLibrosTotal, numLibrosPrestados);
    }

    private static void usuarioSocio() {
        String nombre = MIEntradaSalida2_0.leerCadena("Dime tu nombre");
        String apellidos = MIEntradaSalida2_0.leerCadena("Dime tu apellidos");
        String dni = MIEntradaSalida2_0.leerCadena("Dime tu dni");

        try {
            Usuario usuario = new Usuario(nombre, apellidos, dni);
            biblioteca.registarUsuario(usuario);

            if (MIEntradaSalida2_0.leerSN("Dispone de número de socio (Responda con S o N)") == 'S') {
                biblioteca.anadirSocio(usuario);
            }

        } catch (ValorInvalidoException | BibliotecaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void nuevoLibro() {
        String nombre = MIEntradaSalida2_0.leerCadena("Dime el nombre del libro");
        String autor = MIEntradaSalida2_0.leerCadena("Dime el autor del libro");
        String sinopsis = MIEntradaSalida2_0.leerCadena("Dime el sinopsis del libro");
        int numeroEjemplares = MIEntradaSalida2_0.leerEntero("Dime el numero de ejemplares del libro");
        try {
            Libro libro = new Libro(nombre, autor, sinopsis, numeroEjemplares);
            biblioteca.anadirLibro(libro);
        } catch (ValorInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (BibliotecaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void prestamoLibro() {
        List<Libro> libros = biblioteca.getLibros();
        for (int i = 0; i < libros.size(); i++) {
            System.out.println(i + ". " + libros.get(i));
        }
        int indexLibro = MIEntradaSalida2_0.leerEnteroDeRango("Introduzca el número del libro", 0, libros.size() - 1);

        String dni = MIEntradaSalida2_0.leerCadena("Dime el dni del usuario");
        Usuario user = biblioteca.getUsuarios().stream().filter(usuario -> dni.equals(usuario.getDni())).findFirst().orElse(null);

        try {
            biblioteca.prestarLibro(libros.get(indexLibro), user);
            System.out.println("Prestamo realizado con exito del libro: " + libros.get(indexLibro));
        } catch (BibliotecaException | ValorInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void devolverPrestamo() {
        String dni = MIEntradaSalida2_0.leerCadena("Dime el dni del usuario");
        Usuario user = biblioteca.getUsuarios().stream().filter(usuario -> dni.equals(usuario.getDni())).findFirst().orElse(null);
        if (user == null) {
            System.out.println("El usuario no está registrado");
            return;
        }

        List<Libro> libros = biblioteca.getLibros();
        for (int i = 0; i < libros.size(); i++) {
            System.out.println(i + ". " + libros.get(i));
        }
        int indexLibro = MIEntradaSalida2_0.leerEnteroDeRango("Introduzca el número del libro", 0, libros.size() - 1);

        try {
            biblioteca.devolverLibro(libros.get(indexLibro), user);
            System.out.println("Se ha realizado con exito la devolución del libro: " + libros.get(indexLibro));
        } catch (BibliotecaException | ValorInvalidoException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    private static void cargarDatos() {
        Path pathLibros = Paths.get(".\\src\\ExamenObjetoBiblioteca\\" + biblioteca.getNombre() + "\\LibrosSave.txt");
        try (Stream<String> librosSaved = Files.lines(pathLibros)) {
            librosSaved.forEach(libro -> {
                String[] infoLibro = libro.split(";");
                try {
                    biblioteca.anadirLibro(new Libro(infoLibro[0], infoLibro[1], infoLibro[2], Integer.parseInt(infoLibro[3])));
                } catch (BibliotecaException | ValorInvalidoException e) {
                    System.out.println("Error inesperado: " + e.getMessage());
                }
            });
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }


        Path pathUsuarios = Paths.get(".\\src\\ExamenObjetoBiblioteca\\" + biblioteca.getNombre() + "\\UsuariosSave.txt");
        try (Stream<String> usersSaved = Files.lines(pathUsuarios)) {
            usersSaved.forEach(user -> {
                String[] infoUser = user.split(";");
                try {
                    Usuario usuario = new Usuario(infoUser[0], infoUser[1], infoUser[2]);
                    biblioteca.registarUsuario(usuario);
                    if (!infoUser[3].equals("null")) {
                        biblioteca.anadirSocio(usuario);
                    }

                    for (int i = 4; i < infoUser.length; i++) {
                        biblioteca.prestarLibro(biblioteca.getLibros().get(Integer.parseInt(infoUser[i])), usuario);
                    }

                } catch (BibliotecaException | ValorInvalidoException e) {
                    System.out.println("Error inesperado: " + e.getMessage());
                }
            });
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void guardado() {
        try {
            List<Libro> librosBiblioteca = biblioteca.getLibros();
            Path pathLibros = Paths.get(".\\src\\ExamenObjetoBiblioteca\\" + biblioteca.getNombre() + "\\LibrosSave.txt");
            if (Files.exists(pathLibros)) {
                Files.delete(pathLibros);
            } else {
                Files.createDirectory(Paths.get(".\\src\\ExamenObjetoBiblioteca\\" + biblioteca.getNombre()));
            }
            Files.createFile(pathLibros);

            StringBuilder infoLibros = new StringBuilder();
            for (Libro libro : librosBiblioteca) {
                infoLibros.append(libro.getNombre()).append(";")
                        .append(libro.getAutor()).append(";")
                        .append(libro.getSinopsis()).append(";")
                        .append(libro.getNumEjemplares()).append("\n");
            }

            Files.writeString(pathLibros, infoLibros);


            List<Usuario> usuarios = biblioteca.getUsuarios();
            Path pathUsuarios = Paths.get(".\\src\\ExamenObjetoBiblioteca\\" + biblioteca.getNombre() + "\\UsuariosSave.txt");
            if (Files.exists(pathUsuarios)) {
                Files.delete(pathUsuarios);
            }
            Files.createFile(pathUsuarios);
            StringBuilder infoUsuario = new StringBuilder();

            usuarios.stream().map(user -> {
                StringBuilder datos = new StringBuilder();
                datos.append(user.getNombre()).append(";")
                        .append(user.getApellidos()).append(";")
                        .append(user.getDni()).append(";")
                        .append(user.getNumSocio());

                for (Libro libro : user.getLibrosRecogidos()) {
                    datos.append(";").append(librosBiblioteca.indexOf(libro));
                }

                return (datos.append("\n")).toString();
            }).forEach(infoUsuario::append);


            Files.writeString(pathUsuarios, infoUsuario);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void menu() {
        System.out.println("""
                1)Dar de alta a un usuario como socio
                2)Dar de alta un nuevo libro
                3)Realizar un préstamo de un libro.
                4)Realizar una devolución de un préstamo.
                5)Ver estadisticas de la partida
                6)Guardar progreso
                7)Guardar y volver al menu principal.
                8)Guardar y cerrar el juego
                """);
    }
}
