package Ejer11;

import utils.MiEntradaSalida;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

    }

    private static void crearDirectoriosDesdeFichero() {
        Path ficheroLeer = getValidFichero();
        Path directorioBase = Paths.get(".\\Resources\\Ejer11\\");
        //String dirBase = ".\\Resources\\Ejer11\\";
        Pattern p = Pattern.compile("^(\\p{Lu}{2,})\\s(\\p{Lu}{2,})\\s(\\p{Lu}{2,})\\s([^\\\\/:*?\"<>|]{2,})$");

        try (Stream<String> lineas = Files.lines(ficheroLeer)) {
            lineas.map(p::matcher).filter(Matcher::matches)
                    .forEach(a -> {
                        try {
                            String alumno = a.group(2) + a.group(3) + a.group(1);
                            //Files.createDirectories(Path.of(dirBase, a.group(4), alumno));
                            Files.createDirectories(directorioBase.resolve(a.group(4)).resolve(alumno));

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
    } //TODO: PAtrón Singletown

    //INCOMPLETO
    private static void crearFicherosDesdeFicheroB() {
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
        //Sustituir con el Pattern de crearFicherosDesdeFichero
        return nombre.matches("^(\\p{Lu}{2,}\\s){3}[1-4][A-Z]{2,4}$");
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
