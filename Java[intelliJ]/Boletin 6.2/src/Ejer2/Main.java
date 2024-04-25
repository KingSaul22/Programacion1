package Ejer2;

import utils.SalidaEntradaNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path file = SalidaEntradaNIO.getValidFichero(".\\Resources\\Ejer2\\");
        System.out.println(contarPalabrasFichero(file));
        System.out.println(contarPalabrasFichero(file));
    }

    private static long contarPalabrasFichero(Path fichero) {
        if (!SalidaEntradaNIO.validarFichero(fichero)) return -1L;
        AtomicLong palabras = new AtomicLong(-1L);
        try (Stream<String> lineas = Files.lines(fichero)) {
            lineas.forEach(linea -> palabras.addAndGet(linea.split("\\s").length));

        } catch (IOException e) {
            System.out.println("No se puede leer el fichero " + fichero);
            System.out.println(e.getMessage());
        }
        return palabras.get();
    }

    private static long contarPalabrasFicheroB(Path fichero) {
        if (!SalidaEntradaNIO.validarFichero(fichero)) return -1L;
        AtomicLong palabras = new AtomicLong(-1L);
        try (Stream<String> lineas = Files.lines(fichero)) {
            lineas.forEach(linea -> {
                if (linea.isBlank()) return;
                long contPalabras = 1L;
                int auxPalabras = 0;

                while (auxPalabras != -1) {
                    auxPalabras = linea.indexOf("\\s", auxPalabras);
                    contPalabras++;
                }
                palabras.addAndGet(contPalabras);
            });

        } catch (IOException e) {
            System.out.println("No se puede leer el fichero " + fichero);
            System.out.println(e.getMessage());
        }
        return palabras.get();
    }
}
