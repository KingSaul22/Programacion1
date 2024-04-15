package Ejer6;

import utils.MiEntradaSalida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        mostrarContenidosCarpeta();
    }

    private static void mostrarContenidosCarpeta() {
        Path directorio = getValidDirectorio();

        System.out.println("Ficheros dentro de la carpeta " + directorio.getFileName() + ":");
        //try (Stream<Path> directorios = Files.list(Paths.get("/Users/Alumno/Desktop"))) {
        try (Stream<Path> directorios = Files.list(directorio)) {
            directorios.forEach(a -> {
                        if (Files.isRegularFile(a)) {
                            try {
                                System.out.println(a.getFileName() + " (" + Files.size(a) / 1024.0 + " KB)");
                            } catch (IOException e) {
                                System.out.println(a.getFileName() + " (Peso no detectado)");
                            }
                        } else if (Files.isDirectory(a)) {
                            System.out.println(a.getFileName() + " (Directorio)");
                        } else {
                            System.out.println(a.getFileName() + " (Otro)");
                        }
                    }
            );
        } catch (NotDirectoryException e) {
            System.out.println("Directorio no encontrado");
            System.out.println(e.getMessage());
        } catch (SecurityException e) {
            System.out.println("Sin permisos suficientes para leer el directorio");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Path getValidDirectorio() {
        String name = MiEntradaSalida.leerCadena("Introduzca el nombre del directorio a mostrar");
        Path outPath = Paths.get(".\\Resources\\" + name);

        while (!Files.isDirectory(outPath)) {
            System.out.println("El nombre del directorio " + name + " no existe");
            name = MiEntradaSalida.leerCadena("Introduzca otro nombre para el directorio a mostrar");
            outPath = Paths.get(".\\Resources\\" + name);
        }

        return outPath;
    }
}
