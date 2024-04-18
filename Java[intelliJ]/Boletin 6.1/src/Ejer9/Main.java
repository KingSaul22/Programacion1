package Ejer9;

import utils.MiEntradaSalida;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        hola("Cocacola", "Agua", "Cola-Cao", "Pepsi");
        guardarMatricula();
    }

    private static void guardarMatricula() {
        Path ficheroLeer = getValidFichero();
        Path ficheroSalida = Paths.get(".\\Resources\\Ejer9\\MatriculasCorrectas.txt");

        try (Stream<String> lineas = Files.lines(ficheroLeer)) {
            if (!Files.exists(ficheroSalida)) Files.createFile(ficheroSalida);

            lineas.forEach(a -> {
                String matricula = a.substring(1 + a.lastIndexOf(" "));
                if (!isValidMatricula(a)) return;
                try {
                    Files.writeString(ficheroSalida, matricula + "\n",
                            StandardOpenOption.APPEND, StandardOpenOption.TRUNCATE_EXISTING);
                    System.out.println(matricula + " se ha añadido");
                } catch (UnsupportedOperationException e) {
                    System.out.println("Operación no soportada");
                    System.out.println(e.getMessage());
                } catch (IllegalArgumentException | IOException e) {
                    System.out.println(e.getMessage());
                }
            });
        } catch (NotDirectoryException e) {
            System.out.println("Directorio no encontrado");
            System.out.println(e.getMessage());
        } catch (SecurityException e) {
            System.out.println("Sin permisos suficientes para leer el directorio");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void guardarMatriculaB() {
        Path ficheroLeer = getValidFichero();
        Path ficheroSalida = Paths.get(".\\Resources\\Ejer9\\MatriculasCorrectas.txt");

        Pattern p = Pattern.compile("^\\p{L}+\\s([0-9]{4}-[A-Z&&[^AEIOU]]{3})$");

        try (PrintWriter writer = new PrintWriter(Files.newOutputStream(ficheroSalida), true);
             Stream<String> lineas = Files.lines(ficheroLeer)) {
            if (!Files.exists(ficheroSalida)) Files.createFile(ficheroSalida);

            lineas.map(p::matcher)
                    .filter(Matcher::matches)
                    .forEach(matcher -> writer.println(matcher.group(1)));
        } catch (NotDirectoryException e) {
            System.out.println("Directorio no encontrado");
            System.out.println(e.getMessage());
        } catch (SecurityException e) {
            System.out.println("Sin permisos suficientes para leer el directorio");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean isValidMatricula(String matricula) {
        return matricula.matches("^\\p{L}+\\s[0-9]{4}-[A-Z&&[^AEIOU]]{3}$");
    }

    private static Path getValidFichero() {
        String name = MiEntradaSalida.leerCadena("Introduzca el nombre del fichero con las matriculas");
        Path outPath = Paths.get(".\\Resources\\Ejer9\\" + name);

        while (!Files.isRegularFile(outPath)) {
            System.out.println("El nombre del archivo " + name + " no existe");
            name = MiEntradaSalida.leerCadena("Introduzca otro nombre para el archivo a leer");
            outPath = Paths.get(".\\Resources\\Ejer9\\" + name);
        }

        return outPath;
    }

    private static void hola(String... options) {
        Arrays.stream(options).forEach(System.out::println);
    }
}
