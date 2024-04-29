package utils;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class SalidaEntradaNIO {

    public static Path getValidFichero(String base) {
        String name = MiEntradaSalida.leerCadena("Introduzca el nombre del fichero a buscar");
        Path outPath = Paths.get(base + name);

        while (!Files.isRegularFile(outPath)) {
            System.out.println("El nombre del archivo " + name + " no existe");
            name = MiEntradaSalida.leerCadena("Introduzca otro nombre para el archivo a leer");
            outPath = Paths.get(base + name);
        }

        return outPath;
    }

    public static void mostrarInteriorDirectorio(Path directorio) {
        try (Stream<Path> pathStream = Files.list(directorio)) {
            pathStream.forEach(a -> {
                System.out.print(a.getFileName());
                if (Files.isDirectory(a)) {
                    System.out.println(" (directorio)");
                } else if (Files.isRegularFile(a)) {
                    try {
                        System.out.println(" (" + Files.size(a) / 1024.0 + " KB)");
                    } catch (IOException e) {
                        System.out.println(" (peso no detectado)");
                    }
                } else {
                    System.out.println(" (otro)");
                }
            });
        } catch (NotDirectoryException e) {
            System.out.println("La ruta indicada no es un directorio");
            System.out.println(e.getMessage());
        } catch (SecurityException e) {
            System.out.println("No se puede acceder al fichero");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean validarDirectorio(Path directorio) {
        return Files.isDirectory(directorio);
    }

    public static boolean validarFichero(Path fichero) {
        return Files.isRegularFile(fichero);
    }
}