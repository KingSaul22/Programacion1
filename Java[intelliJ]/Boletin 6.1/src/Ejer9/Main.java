package Ejer9;

import utils.MiEntradaSalida;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

    }

    private static void guardarMatricula() {
        Path ficheroLeer = getValidFichero();
        Path ficheroSalida = Paths.get(".\\Resources\\Ejer9\\MatriculasCorrectas.txt");

        try (Stream<String> lineas = Files.lines(ficheroLeer)) {
            lineas.forEach(a -> {
                String str = a.substring(a.lastIndexOf(" ") + 1, a.length() - 1).trim();
                if (!isValidMatricula(str)) return;
                try {
                    Files.writeString(ficheroSalida, str, StandardOpenOption.APPEND);
                } catch (UnsupportedOperationException e){
                    System.out.println("Operación no soportada");
                    System.out.println(e.getMessage());
                }catch (IllegalArgumentException | IOException e) {
                    System.out.println(e.getMessage());
                }
            });
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

    private static boolean isValidMatricula(String matricula) {
        return matricula.matches("^[0-9]{4}-[A-Z]{3}$");
    }

    private static Path getValidFichero() {
        String name = MiEntradaSalida.leerCadena("Introduzca el nombre del directorio a mostrar");
        Path outPath = Paths.get(".\\Resources\\Ejer9\\" + name);

        while (!Files.isRegularFile(outPath)) {
            System.out.println("El nombre del archivo " + name + " no existe");
            name = MiEntradaSalida.leerCadena("Introduzca otro nombre para el archivo a leer");
            outPath = Paths.get(".\\Resources\\Ejer9\\" + name);
        }

        return outPath;
    }
}
