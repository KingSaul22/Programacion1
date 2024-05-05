package utils;

import java.nio.file.Files;
import java.nio.file.Path;

public class EntradaSalidaNIO {

    public static Path getDirectoryReadable() {
        Path path;
        path = getValidPath();
        while (!Files.isDirectory(path) || !Files.isReadable(path)) {
            System.out.println("La ruta '" + path + "' no es valida\nPruebe de nuevo");
            path = getValidPath();
        }

        return path;
    }

    public static Path getDirectoryWritable() {
        Path path;
        do {
            path = getValidPath();
        } while (!Files.isDirectory(path) || !Files.isWritable(path));

        return path;
    }

    public static Path getValidPath() {
        String ruta = MiEntradaSalida.leerCadena("introduzca la ruta completa hasta el fichero o directorio");
        Path path = Path.of(ruta);

        while (!Files.exists(path)){
            System.out.println("La ruta indicada no existe");
            ruta = MiEntradaSalida.leerCadena("Introduzca la ruta completa (absoluta)");
            path = Path.of(ruta);
        }
        return path;
    }
}
