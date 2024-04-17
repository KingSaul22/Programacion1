package Ejer10;

import utils.MiEntradaSalida;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

    }

    private static void crearFicherosDesdeFichero() {
        Path ficheroLeer = getValidFichero();

        try (Stream<String> lines = Files.lines(ficheroLeer)) {
            lines.filter(Main::isValidNombreFichero)
                    .forEach(a -> {
                        a = a.substring(2);
                        Path out = Paths.get(".\\Resources\\Ejer10\\" + a);
                        /*if (Files.exists(out)) {
                            System.out.println("Ya existe un fichero o directorio con el nombre " + a);
                        } else {*/
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
                        //}
                    });
        } catch (SecurityException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean isValidNombreFichero(String nombre) {
        return nombre.matches("^F [a-zA-Z]{3,}.[a-zA-Z]{3}$");
    }

    private static Path getValidFichero() {
        String name = MiEntradaSalida.leerCadena("Introduzca el nombre del fichero a escoger");
        Path outPath = Paths.get(".\\Resources\\Ejer10\\" + name);

        while (!Files.isRegularFile(outPath)) {
            System.out.println("El nombre del archivo " + name + " no es valido");
            name = MiEntradaSalida.leerCadena("Introduzca otro nombre para el archivo a escoger");
            outPath = Paths.get(".\\Resources\\Ejer10\\" + name);
        }

        return outPath;
    }
}