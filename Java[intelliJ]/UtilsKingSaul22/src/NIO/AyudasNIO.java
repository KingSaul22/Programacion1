package NIO;

import Exceptions.NioException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 */
public class AyudasNIO {

    /**
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
     *
     * @param fichero Path con la ruta a la que escribir
     * @param lineas Lista de lineas a escribir
     * @param options Opciones que especifican como se abre el archivo
     * @throws NioException Cuando la operación no se ha podido realizar
     */
    public static void escribirFichero(Path fichero, List<String> lineas, StandardOpenOption... options) throws NioException {
        try {
            Files.write(fichero, lineas, options);
        }catch (IllegalArgumentException e){
            throw new NioException("Alguna de las opciones indicadas son erroneas");
        } catch (IOException e) {
            throw new NioException("Alguna de las opciones indicadas");
        } catch (UnsupportedOperationException e) {
            throw new NioException("Alguna de las opciones indicadas no es soportada");
        }
    }

    public static 

}
