package Ejer10;

import org.w3c.dom.ls.LSOutput;
import utils.MiEntradaSalida;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        crearFicherosDesdeFicheroB();
    }

    private static void crearFicherosDesdeFicheroC() {
        Path ficheroLeer = getValidFichero();
        Path directorioFinal = Paths.get(".\\Resources\\Ejer10\\out\\");
        Pattern p = Pattern.compile("^F\\s(\\p{L}{3,}\\.\\p{Ll}{3})$");
        AtomicBoolean fichValido = new AtomicBoolean(true);

        try (Stream<String> lines = Files.lines(ficheroLeer)) {
            lines.forEach(linea -> {
                Matcher matcher = p.matcher(linea);
                if (!matcher.matches()) {
                    fichValido.set(false);
                    return;
                }

                try {
                    //Files.createFile(Paths.get(directorioFinal + matcher.group(1)));
                    Files.createFile(directorioFinal.resolve(matcher.group(1)));
                    //Files.createFile(Path.of(directorioFinal.toString(), matcher.group(1)));
                    System.out.println("El fichero " + matcher.group(1) + " ha sido creado exitosamente");
                } catch (InvalidPathException e) {
                    System.out.println("Fallo con el nombre del fichero");
                    System.out.println(e.getMessage());
                } catch (FileAlreadyExistsException e) {
                    System.out.println("El fichero " + matcher.group(1) + " ya existe");
                } catch (UnsupportedOperationException e) {
                    System.out.println("Operacion no soportada");
                } catch (SecurityException e) {
                    System.out.println("No se tienen los permisos necesarios para crear el fichero " + matcher.group(1));
                    System.out.println(e.getMessage());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            });//TODO: API Reflection
        } catch (SecurityException | IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(fichValido.get() ? "El fichero es correcto" : "El fichero no es correcto");
    }

    private static void crearFicherosDesdeFicheroB() {
        Path ficheroLeer = getValidFichero();
        Path directorioFinal = Paths.get(".\\Resources\\Ejer10\\out\\");
        Pattern p = Pattern.compile("^F\\s(\\p{L}{3,}\\.\\p{Ll}{3})$");

        try (Stream<String> lines = Files.lines(ficheroLeer)) {
            lines.map(p::matcher)
                    .forEach(matcher -> {
                        if (!matcher.matches()) {
                            System.out.println("Formato de la linea no valido");
                            return;
                        }
                        try {
                            //Files.createFile(Paths.get(directorioFinal + matcher.group(1)));
                            Files.createFile(directorioFinal.resolve(matcher.group(1)));
                            //Files.createFile(Path.of(directorioFinal.toString(), matcher.group(1)));
                            System.out.println("El fichero " + matcher.group(1) + " ha sido creado exitosamente");
                        } catch (InvalidPathException e) {
                            System.out.println("Fallo con el nombre del fichero");
                            System.out.println(e.getMessage());
                        } catch (FileAlreadyExistsException e) {
                            System.out.println("El fichero " + matcher.group(1) + " ya existe");
                        } catch (UnsupportedOperationException e) {
                            System.out.println("Operacion no soportada");
                        } catch (SecurityException e) {
                            System.out.println("No se tienen los permisos necesarios para crear el fichero " + matcher.group(1));
                            System.out.println(e.getMessage());
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }

                    });//TODO: API Reflection
        } catch (SecurityException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void crearFicherosDesdeFichero() {
        Path ficheroLeer = getValidFichero();

        try (Stream<String> lines = Files.lines(ficheroLeer)) {
            lines.forEach(a -> {
                if (!isValidNombreFichero(a)) {
                    System.out.println("El nombre del fichero no es valido");
                } else {
                    a = a.substring(2);
                    Path out = Paths.get(".\\Resources\\Ejer10\\out\\" + a);

                    try {
                        Files.createFile(out);
                        System.out.println("Se ha creado el fichero " + a);
                    } catch (FileAlreadyExistsException e) {
                        System.out.println("El fichero " + a + " ya existe");
                        System.out.println(e.getMessage());
                    } catch (UnsupportedOperationException e) {
                        System.out.println("Operacion no soportada");
                    } catch (SecurityException e) {
                        System.out.println("No se tienen los permisos necesarios para crear el fichero " + a);
                        System.out.println(e.getMessage());
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            });
        } catch (SecurityException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void crearFichero(Path pathCrear) {
        try {
            Files.createFile(pathCrear);
            System.out.println("El fichero ha sido creado exitosamente");
        } catch (FileAlreadyExistsException e) {
            System.out.println("El fichero ya existe");
        } catch (UnsupportedOperationException e) {
            System.out.println("Operacion no soportada");
        } catch (SecurityException e) {
            System.out.println("No se tienen los permisos necesarios para crear el fichero");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void crearFichero(Path base, String nombreFichero) {
        crearFichero(base.resolve(nombreFichero));
    }

    private static void crearFichero(Path base, Matcher matcher, int numGroup) {
        crearFichero(base.resolve(matcher.group(numGroup)));
    }

    private static boolean isValidNombreFichero(String nombre) {
        return nombre.matches("^F\\s(\\p{L}{3,}\\.[a-zA-Z]{3})$");
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
