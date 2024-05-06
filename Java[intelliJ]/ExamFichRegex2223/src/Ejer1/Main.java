package Ejer1;

import utils.EntradaSalidaNIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path directorioPadre = EntradaSalidaNIO.getDirectoryReadable();
        Path directorioHijo = EntradaSalidaNIO.getDirectoryWritable();
        copiarFicherosDirectorios(directorioPadre, directorioHijo);
    }

    private static void copiarFicherosDirectorios(Path dirIn, Path dirOut) {
        final int MIN_BYTES = 1024;
        final String PRIMERA_PALABRA = "copiar";
        final String EXTENSION = ".txt";

        try (Stream<Path> lineas = Files.list(dirIn)) {
            lineas.filter(path -> {
                        try {
                            return Files.isRegularFile(path) &&
                                    Files.size(path) > MIN_BYTES &&
                                    path.getFileName().toString().endsWith(EXTENSION);
                        } catch (IOException e) {
                            return false;
                        }
                    })
                    .filter(path -> {
                        try (BufferedReader br = Files.newBufferedReader(path)) {
                            return br.readLine().toLowerCase().startsWith(PRIMERA_PALABRA);
                        } catch (IOException e) {
                            return false;
                        }
                    })
                    .forEach(path -> {
                        System.out.print("Fichero a copiar: " + path);
                        try {
                            Files.copy(path, dirOut.resolve(path.getFileName()));
                            System.out.println(" // Completado");
                        } catch (IOException e) {
                            System.out.println("\nError inesperado al copiar el archivo " + path.getFileName().toString());
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
}
