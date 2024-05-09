package ej1;


import Exceptions.NioException;
import utils.AyudasNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    /**
     * Puedes utilizar indistintamente java.io o java.nio para resolver los ejercicios.
     *
     * @param args
     */
    public static void main(String[] args) {
        Path qj = Path.of("./src/ej1/quijote.txt");

        System.out.println("INICIO EJERCICIO UNO");
        ejercicio1(qj);

        System.out.println("\nINICIO EJERCICIO DOS");
        ejercicio2(qj);

        System.out.println("\nINICIO EJERCICIO TRES");
        ejercicio3(qj);
    }

    /**
     *Guarda en un fichero todas las palabras que empiezan y terminan en vocal, ya sea con tilde o sin tilde.
     *
     * @param path Fichero a leer
     */
    public static void ejercicio1(Path path) {
        if (!Files.isRegularFile(path)) {
            System.out.println("La ruta indicada no es un fichero regular o no existe");
            return;
        }

        Path outPath = Path.of("./src/ej1/palabrasVocales.txt");
        try {
            AyudasNIO.crearFichero(outPath, true);
        } catch (NioException e) {
            System.out.println(e.getMessage());
            return;
        }

        Pattern pt = Pattern.compile("\\b([aáeéiíoóuú](?:\\p{L}*[aáeéiíoóuú])?)\\b", Pattern.CASE_INSENSITIVE);
        try (Stream<String> lineas = Files.lines(path)) {
            lineas.map(pt::matcher)
                    .forEach(matcher -> {
                        List<String> palabras = matcher.results()
                                .map(MatchResult::group)
                                .toList();

                        try {
                            AyudasNIO.escribirFichero(outPath, palabras, StandardOpenOption.APPEND);
                        } catch (NioException e) {
                            System.out.println(e.getMessage());
                        }
                    });
        } catch (IOException e) {
            System.out.println("No se ha podido acceder al fichero\n" + e.getMessage());
        }

        System.out.println("COMPLETADO");
    }

    /**
     * Guarda en un fichero todos los signos de puntuación encontrados en el fichero.
     *
     * @param path Fichero a leer
     */
    public static void ejercicio2(Path path) {
        if (!Files.isRegularFile(path)) {
            System.out.println("La ruta indicada no es un fichero reegular o no existe");
            return;
        }

        Path outPath = Path.of("./src/ej1/puntuacion.txt");
        try {
            AyudasNIO.crearFichero(outPath, true);
        } catch (NioException e) {
            System.out.println(e.getMessage());
            return;
        }

        Pattern pt = Pattern.compile("([^\\p{LD}\\s])");
        try (Stream<String> lineas = Files.lines(path)) {
            lineas.map(pt::matcher)
                    .forEach(matcher -> {
                        List<String> palabras = matcher.results()
                                .map(MatchResult::group)
                                .toList();

                        try {
                            AyudasNIO.escribirFichero(outPath, palabras, StandardOpenOption.APPEND);
                        } catch (NioException e) {
                            System.out.println(e.getMessage());
                        }
                    });
        } catch (IOException e) {
            System.out.println("No se ha podido acceder al fichero\n" + e.getMessage());
        }

        System.out.println("COMPLETADO");
    }

    /**
     * Crea carpetas por cada letra inicial de las palabras (en mayusucula) y
     * dentro crea ficheros para cada palabras en minusculas.
     *
     * @param path Fichero a leer
     */
    public static void ejercicio3(Path path) {
        if (!Files.isRegularFile(path)) {
            System.out.println("La ruta indicada no es un fichero reegular o no existe");
            return;
        }

        Path outBasePath = Path.of("./src/ej1/");

        Pattern pt = Pattern.compile("(\\p{L}+)", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        try (Stream<String> lineas = Files.lines(path)) {
            lineas.map(pt::matcher)
                    .forEach(matcher -> {
                        matcher.results()
                                .map(MatchResult::group)
                                .forEach(palabra -> {
                                    Path outPath = outBasePath.resolve(
                                            String.valueOf(Character.toUpperCase(palabra.charAt(0))));

                                    try {
                                        AyudasNIO.crearDirectorio(outPath, false);
                                    } catch (NioException ignore) {
                                    }

                                    try {
                                        AyudasNIO.crearFichero(outPath.resolve(palabra.toLowerCase() + ".txt"), false);
                                    } catch (NioException ignore) {
                                    }
                                });
                    });
        } catch (IOException e) {
            System.out.println("No se ha podido acceder al fichero\n" + e.getMessage());
        }

        System.out.println("COMPLETADO");
    }
}
