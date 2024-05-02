package Ejer4;

import utils.SalidaEntradaNIO;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path qj = Paths.get(".\\src\\Ejer4\\quijote.txt");
        int num = cuentaOcurrenciasRazon(qj);
        System.out.println("En el fichero " + qj.getFileName() + ", la palabra 'razón' se ha encontrado " + num + " veces.");

        //Parte 2
        num = cuentaTildesEnieEnFichero(qj);
        System.out.println("En el fichero " + qj.getFileName() + ", se han encontrado " + num + " tildes.");

        //PARTE TRES
        Path qj2 = Paths.get(".\\src\\Ejer4\\quijote2.txt");
        eliminarAnotacionesFichero(qj, qj2);

        //PARTE CUATRO
        Path qj3 = Paths.get(".\\src\\Ejer4\\quijote3.txt");
        primeraMayusculaFichero(qj2, qj3);

        //PARTE CINCO
        int numLetras = 13;
        Set<String> palabras = buscaPalbrasMasLetras(qj3, numLetras);
        System.out.print("En el fichero " + qj3.getFileName());
        if (palabras == null) {
            System.out.println(", no hay palabras con " + numLetras + " o más letras");
        } else {
            System.out.println(", hay " + palabras.size() + " palabras con " + numLetras + " o más letras.");
            System.out.println("Son las siguientes:");
            palabras.stream().sorted().forEach(str -> System.out.println("  · " + str));
        }

        //PARTE CINCO
        int numPalabras = 13;
        Set<String> frases = buscaPalbrasMasLetras(qj3, numPalabras);
        System.out.print("En el fichero " + qj3.getFileName());
        if (frases == null) {
            System.out.println(", no hay frases con " + numPalabras + " o más palabras");
        } else {
            System.out.println(", hay " + frases.size() + " frases con " + numPalabras + " o más palabras.");
            System.out.println("Son las siguientes:");
            frases.stream().sorted().forEach(str -> System.out.println("  · " + str));
        }
    }

    private static int cuentaOcurrenciasRazon(Path fichero) {
        if (!SalidaEntradaNIO.validarFichero(fichero)) return -1;
        Pattern pt = Pattern.compile("\\braz[oó]n\\b", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

        return contarCoincidenciasExpresionFichero(pt, fichero);
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

    private static int cuentaTildesEnieEnFichero(Path fichero) {
        if (!SalidaEntradaNIO.validarFichero(fichero)) return -1;
        Pattern pt = Pattern.compile("[áéíóúñ]", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

        return contarCoincidenciasExpresionFichero(pt, fichero);
    }

    private static void eliminarAnotacionesFichero(Path ficheroIn, Path ficheroOut) {
        if (!SalidaEntradaNIO.validarFichero(ficheroIn)) {
            System.out.println("Fichero no valido");
            return;
        } else if (Files.exists(ficheroOut) && !Files.isRegularFile(ficheroOut)) {
            System.out.println("La ruta del fichero de salida no es valida");
            return;
        }

        Pattern pt = Pattern.compile("(\\p{L})\\d+", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        try (Stream<String> lineas = Files.lines(ficheroIn)) {
            Files.createFile(ficheroOut);

            lineas.map(pt::matcher).forEach(matcher -> {
                try {
                    Files.writeString(ficheroOut, matcher.replaceAll("$1") + "\n", StandardOpenOption.APPEND);
                } catch (IllegalArgumentException e) {
                    System.out.println("Opciones incorrectas en los ajustes del fichero\n" + e.getMessage());
                } catch (UnsupportedOperationException e) {
                    System.out.println("Operaciones incorrectas\n" + e.getMessage());
                } catch (IOException e) {
                    System.out.println("Ha ocurrido un error\n" + e.getMessage());
                }
            });

            /*lineas.forEach(linea -> {
                try {
                    Files.writeString(ficheroOut, linea.replaceAll("(\p{L})\d+", "$1"), StandardOpenOption.APPEND);
                } catch (IllegalArgumentException e) {
                    System.out.println("Opciones incorrectas en los ajustes del fichero\n" + e.getMessage());
                } catch (UnsupportedOperationException e) {
                    System.out.println("Operaciones incorrectas\n" + e.getMessage());
                } catch (IOException e) {
                    System.out.println("Ha ocurrido un error\n" + e.getMessage());
                }
            });*/
        } catch (IOException e) {
            System.out.println("No se ha podido acceder al fichero\n" + e.getMessage());
        }
    }

    private static void primeraMayusculaFichero(Path ficheroIn, Path ficheroOut) {
        if (!SalidaEntradaNIO.validarFichero(ficheroIn)) {
            System.out.println("Fichero no valido");
            return;
        } else if (Files.exists(ficheroOut) && !Files.isRegularFile(ficheroOut)) {
            System.out.println("La ruta del fichero de salida no es valida");
            return;
        }

        Pattern pt = Pattern.compile("(\\b\\p{L})(\\p{L}*\\b)",
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        try (Stream<String> lineas = Files.lines(ficheroIn)) {
            Files.createFile(ficheroOut);

            lineas.map(pt::matcher).forEach(matcher -> {
                try {
                    Files.writeString(
                            ficheroOut,
                            matcher.replaceAll(matchResult ->
                                    matchResult.group(1).toUpperCase() + matchResult.group(2)) + "\n",
                            StandardOpenOption.APPEND);
                } catch (IllegalArgumentException e) {
                    System.out.println("Opciones incorrectas en los ajustes del fichero\n" + e.getMessage());
                } catch (UnsupportedOperationException e) {
                    System.out.println("Operaciones incorrectas\n" + e.getMessage());
                } catch (IOException e) {
                    System.out.println("Ha ocurrido un error\n" + e.getMessage());
                }
            });
        } catch (IOException e) {
            System.out.println("No se ha podido acceder al fichero\n" + e.getMessage());
        }
    }

    private static Set<String> buscaPalbrasMasLetras(Path fichero, final int NUM_LETRAS_MIN) {
        if (!SalidaEntradaNIO.validarFichero(fichero)) {
            System.out.println("Fichero no valido");
            return null;
        }

        Set<String> palabras = new HashSet<>();
        Pattern pt = Pattern.compile("\\b(\\p{LD}+)\\b");

        try (Stream<String> lineas = Files.lines(fichero)) {
            palabras = lineas.map(pt::matcher)
                    .flatMap(matcher -> {
                        Set<String> auxPalabras = new HashSet<>();
                        while (matcher.find()) {
                            auxPalabras.add(matcher.group(1));
                        }
                        return auxPalabras.stream();
                    }).filter(palabra -> palabra.length() >= NUM_LETRAS_MIN)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            System.out.println("No se ha podido acceder al fichero\n" + e.getMessage());
        }

        return palabras;
    }

    private static Set<String> buscaFrasesMinimoPalabras(Path fichero, final int NUM_PALABRAS_MIN) {
        if (!SalidaEntradaNIO.validarFichero(fichero)) {
            System.out.println("Fichero no valido");
            return null;
        }

        Set<String> frases = new HashSet<>();
        Pattern pt = Pattern.compile("\\b(\\p{LD}+)\\b");

        try (Stream<String> lineas = Files.lines(fichero)) {
            /*frases = lineas.map(pt::matcher)
                    .filter(matcher -> {
                        int count = 0;
                        while (matcher.find()) {
                            count++;
                        }
                        return NUM_PALABRAS_MIN <= count;
                    }).map(Matcher::group).collect(Collectors.toSet());*/

            frases = lineas.map(pt::matcher)
                    .filter(matcher -> matcher.results().count() >= NUM_PALABRAS_MIN)
                    .map(Matcher::group)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            System.out.println("No se ha podido acceder al fichero\n" + e.getMessage());
        }

        return frases;
    }

    private static int contarCoincidenciasExpresionString(Pattern pt, String cadena) {
        int cont = 0;
        Matcher matcher = pt.matcher(cadena);
        while (matcher.find()) cont++;

        return cont;
    }

    private static int contarCoincidenciasExpresionFichero(Pattern pt, Path fichero) {
        AtomicInteger cont = new AtomicInteger(0);

        try (Stream<String> lineas = Files.lines(fichero)) {
            lineas.map(pt::matcher).forEach(matcher -> {
                while (matcher.find()) cont.getAndIncrement();
            });
        } catch (IOException e) {
            System.out.println("Error al leer el fichero\n" + e.getMessage());
        }

        return cont.get();
    }
}
