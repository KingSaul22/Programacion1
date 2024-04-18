package Ejer1;

import utils.MiEntradaSalida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int option;
        do {
            mostrarMenu();
            option = MiEntradaSalida.leerEnteroDeRango("Seleccion", 1, 5);

            switch (option) {
                case 1:
                    crearDirectorio();
                    break;
                case 2:
                    crearFicheroTexto();
                    break;
                case 3:
                    borrarFicheroTexto();
                    break;
                case 4:
                    mostrarFicherosCarpeta();
            }
        } while (option != 5);
    }

    private static void crearDirectorio() {
        String nombre = MiEntradaSalida.leerCadena("Introduzca el nombre del directorio");
        Path directorio = Paths.get(".\\Resources\\Ejer1\\" + nombre);

        if (Files.exists(directorio)) {
            if (Files.isDirectory(directorio)) System.out.println("El directorio " + nombre + " ya existe");
            else if (Files.isRegularFile(directorio)) System.out.println("Ya existe un fichero llamado " + nombre);
            else System.out.println("El nombre " + nombre + " ya está en uso");
            return;
        }

        try {
            Files.createDirectories(directorio);
            System.out.println("Carpeta " + nombre + " creada");
        } catch (UnsupportedOperationException e) {
            System.out.println("Los atributos que se desean aplicar a la carpeta no están soportados");
            System.out.println(e.getMessage());
        } catch (SecurityException e) {
            System.out.println("No se tienen permisos para crear el directorio");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al crear el directorio");
            System.out.println(e.getMessage());
        }
    }

    private static void crearFicheroTexto() {
        String nombre = MiEntradaSalida.leerCadena("Nombre del fichero a crear");
        Path fichero = Paths.get(".\\Resources\\Ejer1\\" + nombre);

        if (Files.exists(fichero)) {
            if (Files.isDirectory(fichero)) System.out.println("El directorio " + nombre + " ya existe");
            else if (Files.isRegularFile(fichero)) System.out.println("Ya existe un fichero llamado " + nombre);
            else System.out.println("El nombre " + nombre + " ya está en uso");
            return;
        }

        try {
            Files.createFile(fichero);
            System.out.println("Fichero " + nombre + " creado");
        } catch (UnsupportedOperationException e) {
            System.out.println("Los atributos que se desean aplicar al fichero no están soportados");
            System.out.println(e.getMessage());
        } catch (SecurityException e) {
            System.out.println("No se tienen permisos para crear el fichero");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al crear el fichero");
            System.out.println(e.getMessage());
        }
    }

    private static void borrarFicheroTexto() {
        String nombre = MiEntradaSalida.leerCadena("Nombre del fichero a borrar");
        Path fichero = Paths.get(".\\Resources\\Ejer1\\" + nombre);

        if (Files.isDirectory(fichero)) {
            System.out.println("El nombre indicado pertenece a un Directorio");
            return;
        }
        if (Files.exists(fichero) && !Files.isRegularFile(fichero)) {
            System.out.println("El nombre indicado no pertenece a un archivo");
            return;
        }

        try {
            Files.delete(fichero);
            System.out.println("Fichero " + nombre + " borrado");

        } catch (NoSuchFileException e) {
            System.out.println("El fichero que se quiere borrar no existe");
            System.out.println(e.getMessage());
        } catch (SecurityException e) {
            System.out.println("No se tienen los permisos necesarios para borrar el fichero");
            System.out.println(e.getMessage());
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarFicherosCarpeta() {
        String name = MiEntradaSalida.leerCadena("Introduzca el nombre de la carpeta");
        Path fichero = Paths.get(".\\Resources\\Ejer1\\" + name);

        try (Stream<Path> ficheros = Files.list(fichero)) {
            ficheros.filter(Files::isRegularFile).forEach(a -> System.out.println(a.getFileName()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                \n1. Crear Directorio
                2. Crear Fichero de Texto
                3. Borrar Fichero de Texto
                4. Mostrar los Ficheros de una Carpeta
                5. Salir""");
    }
}
