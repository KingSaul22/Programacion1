package Ejer11;

import utils.MiEntradaSalida;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

    }

    private static void crearFicherosDesdeFichero() {
        Path ficheroLeer = getValidFichero();
        AtomicInteger numLinea = new AtomicInteger(0);

        try (Stream<String> lines = Files.lines(ficheroLeer)) {
            lines.forEach(a -> {
                numLinea.getAndIncrement();

                if (!isValidNombre(a)) {
                    System.out.println("Se ha interrumpido el proceso debido al formato incorrecto de la linea " +
                            numLinea + ".");
                    return;
                }

                Path out = Paths.get(".\\Resources\\Ejer11\\" + a);

                try {
                    Files.createFile(out);
                    System.out.println("Se ha creado el fichero " + a);
                } catch (FileAlreadyExistsException e) {
                    System.out.println("El fichero ya existe");
                    System.out.println(e.getMessage());
                } catch (UnsupportedOperationException e) {
                    System.out.println("Operacion no soportada");
                } catch (SecurityException e) {
                    System.out.println("No se tienen los permisos necesarios para crear el fichero " + a);
                    System.out.println(e.getMessage());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });
        } catch (SecurityException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean isValidNombre(String nombre) {
        return nombre.matches("^[A-Z]{2,} [A-Z]{2,} [A-Z]{2,} [1-4][A-Z]{2,4}$");
    }

    private static Path getValidFichero() {
        String name = MiEntradaSalida.leerCadena("Introduzca el nombre del fichero a escoger");
        Path outPath = Paths.get(".\\Resources\\Ejer11\\" + name);

        while (!Files.isRegularFile(outPath)) {
            System.out.println("El nombre del archivo " + name + " no es valido");
            name = MiEntradaSalida.leerCadena("Introduzca otro nombre para el archivo a escoger");
            outPath = Paths.get(".\\Resources\\Ejer11\\" + name);
        }

        return outPath;
    }
}
