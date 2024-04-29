package Ejer4;

import utils.SalidaEntradaNIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path qj = Paths.get(".\\src\\Ejer4\\quijote.txt");
        int num = cuentaOcurrenciasRazon(qj);
        System.out.println("En el fichero " + qj.getFileName() + ", la palabra 'razón' se ha encontrado " + num + " veces.");
    }

    private static int cuentaOcurrenciasRazon(Path fichero) {
        if (!SalidaEntradaNIO.validarFichero(fichero)) return -1;
        AtomicInteger cont = new AtomicInteger(0);
        Pattern pt = Pattern.compile("\\braz[oó]n\\b", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

        try (Stream<String> lineas = Files.lines(fichero)) {
            /*lineas.forEach(linea -> {
                if (!linea.contains("razon") && !linea.contains("razón")) return;
                cont.addAndGet(linea.split("\\braz[oó]n\\b").length);
            });*/

            lineas.map(pt::matcher).forEach(matcher -> {
                while (matcher.find()) cont.getAndIncrement();
            });

        } catch (IOException e) {
            System.out.println("Error al leer el fichero\n" + e.getMessage());
        }

        return cont.get();
    }

    private static int cuentaOcurrenciasRazon(File fichero) {
        return cuentaOcurrenciasRazon(fichero.toPath());
    }
    /*
    private static int cuentaOcurrenciasPalabra(Path fichero, String palabra) {
        int cont = 0;
        try (Stream<String> lineas = Files.lines(fichero)) {
            lineas.forEach(linea -> {

            });
        }

        return cont;
    }*/
}
