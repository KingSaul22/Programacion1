package NIO;

import Exceptions.NioException;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Clase que proporciona utilidades para operaciones de E/S (entrada/salida) con el sistema de archivos utilizando NIO (New I/O).
 * Esta clase ofrece métodos para contar líneas y palabras en archivos, escribir en archivos, crear y borrar directorios y archivos,
 * y obtener el contenido de un directorio, entre otras operaciones.
 * <p>
 * {@author <a href="https://github.com/KingSaul22">@KingSaul22</a>}
 * Fecha: [2024/05/08]
 */
public class AyudasNIO {

    /**
     * Cuenta las lineas de un fichero dado
     *
     * @param fichero Path con el fichero a leer
     * @return El número de lineas en el fichero o, {@code -1} cuando se ha producido un error
     */
    public static long contarLineasFichero(Path fichero) {
        if (!Files.isRegularFile(fichero) || !Files.isReadable(fichero)) return -1;

        try (Stream<String> lines = Files.lines(fichero)) {
            return lines.count();
        } catch (IOException e) {
            return -1;
        }
    }

    /**
     * Cuenta el número de palabras que coinciden con una expresión regular en un archivo especificado.
     *
     * @param fichero El archivo en el que buscar palabras.
     * @param regex   La expresión regular que define una palabra.
     * @param flags   Los indicadores de expresión regular, como CASE_INSENSITIVE, UNICODE_CASE, etc.
     * @return El número de palabras que coinciden con la expresión regular en el archivo, o {@code -1} si se produce un error.
     */
    public static long contarPalabrasFichero(Path fichero, String regex, int flags) {
        if (!Files.isRegularFile(fichero) || !Files.isReadable(fichero)) return -1;

        Pattern pt = Pattern.compile(regex, flags);
        try (Stream<String> lineas = Files.lines(fichero)) {
            return lineas.map(pt::matcher).mapToLong(matcher -> {
                if (!matcher.matches()) return 0;
                //return matcher.groupCount();
                return matcher.results().count();
            }).sum();
        } catch (IOException e) {
            return -1;
        }
    }

    /**
     * Cuenta el número de palabras en un archivo utilizando la expresión regular predeterminada.
     *
     * @param fichero El archivo en el que buscar palabras.
     * @param flags   Los indicadores de expresión regular, como CASE_INSENSITIVE, UNICODE_CASE, etc.
     * @return El número de palabras en el archivo, o {@code -1} si se produce un error.
     */
    public static long contarPalabrasFichero(Path fichero, int flags) {
        return contarPalabrasFichero(fichero, "\\b(\\p{L})\\b", flags);
    }

    /**
     * Cuenta el número de palabras en un archivo utilizando la expresión regular predeterminada y sin indicadores adicionales.
     *
     * @param fichero El archivo en el que buscar palabras.
     * @return El número de palabras en el archivo, o {@code -1} si se produce un error.
     */
    public static long contarPalabrasFichero(Path fichero) {
        return contarPalabrasFichero(fichero, "\\b(\\p{L})\\b", 0);
    }

    /**
     * Recibe las lineas a escribir en una {@link List<String>} y las envia al método
     * {@link Files#write(Path, Iterable, OpenOption...)}; para escribirlas en un fichero de texto
     *
     * @param fichero Path con la ruta a la que escribir
     * @param lineas  Lista de lineas a escribir
     * @param options Opciones que especifican como se abre el archivo
     * @throws NioException Cuando la operación no se ha podido realizar
     */
    public static void escribirFichero(Path fichero, List<String> lineas, StandardOpenOption... options) throws NioException {
        try {
            Files.write(fichero, lineas, options);
        } catch (IllegalArgumentException e) {
            throw new NioException("Alguna de las opciones indicadas son erroneas");
        } catch (IOException e) {
            throw new NioException("Alguna de las opciones indicadas");
        } catch (UnsupportedOperationException e) {
            throw new NioException("Alguna de las opciones indicadas no es soportada");
        }
    }

    /**
     * Crea un directorio en la ruta especificada, opcionalmente lo trunca si ya existe.
     *
     * @param path     La ruta del directorio a crear.
     * @param truncate Indica si se debe truncar el directorio si ya existe.
     * @throws NioException Si no se puede crear el directorio o si el directorio ya existe y no se permite truncarlo.
     */
    public static void crearDirectorio(Path path, boolean truncate) throws NioException {
        if (Files.exists(path)) {
            if (Files.isDirectory(path)) {
                if (!truncate) throw new NioException("El directorio ya existe");
            } else {
                throw new NioException("El path indicado ya está en uso por algo que no es un directorio");
            }
        }

        try {
            Files.deleteIfExists(path);
            Files.createDirectory(path);
        } catch (DirectoryNotEmptyException e) {
            throw new NioException("El directorio no está vacio, no se puede borrar");
        } catch (UnsupportedOperationException e) {
            throw new NioException("Alguno de los atributos indicados no es valido\n" + e.getMessage());
        } catch (IOException e) {
            throw new NioException("Error al leer el fichero\n" + e.getMessage());
        }
    }

    /**
     * Crea un nuevo archivo en la ruta especificada, opcionalmente lo trunca si ya existe.
     *
     * @param path     La ruta del archivo a crear.
     * @param truncate Indica si se debe truncar el archivo si ya existe.
     * @throws NioException Si no se puede crear el archivo o si el archivo ya existe y no se permite truncarlo.
     */
    public static void crearFichero(Path path, boolean truncate) throws NioException {
        if (Files.exists(path)) {
            if (Files.isRegularFile(path)) {
                if (!truncate) throw new NioException("El fichero ya existe");
            } else {
                throw new NioException("El path indicado ya está en uso por algo que no es un fichero");
            }
        }

        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (UnsupportedOperationException e) {
            throw new NioException("Alguno de los atributos indicados no es valido\n" + e.getMessage());
        } catch (IOException e) {
            throw new NioException("Error al leer el fichero\n" + e.getMessage());
        }
    }

    /**
     * Borra un directorio y opcionalmente su contenido de forma recursiva.
     *
     * @param path      La ruta del directorio a borrar.
     * @param recursive Indica si se debe borrar el contenido del directorio de forma recursiva.
     * @throws NioException Si no se puede borrar el directorio o su contenido.
     */
    public static void borrarDirectorio(Path path, boolean recursive) throws NioException {
        if (!Files.exists(path)) return;
        if (!Files.isDirectory(path)) throw new NioException("El path indicado no es un directorio");

        try (Stream<Path> paths = Files.list(path)) {
            if (recursive) {
                paths.forEach(p -> {
                    try {
                        if (Files.isDirectory(p)) {
                            borrarDirectorio(p, true);
                        } else {
                            Files.delete(p);
                        }
                    } catch (NioException | IOException ignore) {
                    }
                });
                borrarDirectorio(path, false);
            } else if (paths.findFirst().isEmpty()) {
                Files.delete(path);
            } else {
                throw new NioException("El directorio contiene elementos");
            }
        } catch (IOException e) {
            throw new NioException("Error al acceder al path\n" + e.getMessage());
        }
    }

    /**
     * Borra un archivo en la ruta especificada.
     *
     * @param path La ruta del archivo a borrar.
     * @throws NioException Si no se puede borrar el archivo.
     */
    public static void borrarFichero(Path path) throws NioException {
        if (Files.isDirectory(path)) throw new NioException("El path indicado pertenece a un directorio");

        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new NioException("Error al acceder al path\n" + e.getMessage());
        }
    }

    /**
     * Obtiene el contenido de un directorio y lo devuelve como una lista de cadenas, donde cada elemento
     * representa un elemento del directorio (archivo o directorio) y su tipo.
     *
     * @param path      La ruta del directorio del que se obtendrá el contenido.
     * @param recursive Indica si se debe obtener el contenido de forma recursiva.
     * @return Una lista de cadenas que representa el contenido del directorio.
     * @throws NioException Si no se puede acceder al directorio o si ocurre un error al obtener su contenido.
     */
    public static List<String> mostrarDirectorio(Path path, boolean recursive) throws NioException {
        List<String> contenido = new ArrayList<>();

        getContenidoDirectorio(path, recursive).forEach(p -> {
            if (Files.isDirectory(p)) {
                contenido.add(p + " (directorio)");
            } else if (Files.isRegularFile(p)) {
                contenido.add(p + " (fichero)");
            } else {
                contenido.add(p + " (otro)");
            }
        });

        return contenido;
    }

    /**
     * Obtiene el contenido de un directorio como una lista de rutas de archivos y directorios.
     *
     * @param path      La ruta del directorio del que se obtendrá el contenido.
     * @param recursive Indica si se debe obtener el contenido de forma recursiva.
     * @return Una lista de rutas de archivos y directorios.
     * @throws NioException Si no se puede acceder al directorio o si ocurre un error al obtener su contenido.
     */
    public static List<Path> getContenidoDirectorio(Path path, boolean recursive) throws NioException {
        if (!Files.isDirectory(path)) throw new NioException("El path indicado no es un directorio");
        if (!Files.isReadable(path)) throw new NioException("No se puede acceder al interior del directorio");

        List<Path> contenido = new ArrayList<>();
        try (Stream<Path> paths = Files.list(path)) {
            paths.sorted((a, b) -> {
                        if ((Files.isDirectory(a) && Files.isDirectory(b)) ||
                                (Files.isRegularFile(a) && Files.isRegularFile(b)) ||
                                (!Files.isDirectory(a) && !Files.isRegularFile(a) && !Files.isDirectory(b) && !Files.isRegularFile(b)))
                            return 0;

                        if (Files.isDirectory(a)) return -1;
                        if (Files.isDirectory(b)) return 1;
                        if (Files.isRegularFile(a)) return -1;
                        return 1;
                    })
                    .forEach(p -> {
                        contenido.add(p);
                        if (Files.isDirectory(p) && recursive) {
                            try {
                                contenido.addAll(getContenidoDirectorio(p, true));
                            } catch (NioException ignore) {
                            }
                        }
                    });
        } catch (IOException e) {
            throw new NioException("Error al acceder al path\n" + e.getMessage());
        }

        return contenido;
    }
}
