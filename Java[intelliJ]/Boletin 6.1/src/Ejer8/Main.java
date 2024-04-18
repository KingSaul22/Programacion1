package Ejer8;

import utils.MiEntradaSalida;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String nombreCompletoEdad = MiEntradaSalida.leerCadena("Introduzca su nombre, apellidos y edad");
        while (!isValidFormat(nombreCompletoEdad)) {
            System.out.println("Introduzca valores adecuados, en una sola línea separada por espacios");
            nombreCompletoEdad = MiEntradaSalida.leerCadena("Introduzca su nombre, apellidos y edad");
        }
        String[] valoresCadena = nombreCompletoEdad.split(" ");
        System.out.printf("""
                Datos introducidos:
                  Nombre: %s
                  Apellido 1: %s
                  Apellido 2: %s
                  Edad: %d
                """, valoresCadena[0], valoresCadena[1], valoresCadena[2], Integer.parseInt(valoresCadena[3]));

        Path fichero = Paths.get(".\\Resources\\Ejer8\\prueba.txt");
        Pattern p = Pattern.compile("^(\\p{L}{2,}\\s){3}(([1-9]\\d?)|0[1-9])$");

        try (BufferedReader br = Files.newBufferedReader(fichero, StandardCharsets.UTF_8)) {
            boolean ficheroValido = true;
            Matcher m;
            String line;
            while ((line = br.readLine()) != null) {
                m = p.matcher(line);
                if (!m.matches()) {
                    ficheroValido = false;
                    break;
                }
            }

            if (ficheroValido) {
                System.out.println("Fichero valido");
            } else {
                System.out.println("Fichero invalido");
            }

            if (br.lines().toList().isEmpty()) System.out.println("El fichero solo se puede leer una vez");

            if (br.lines().map(p::matcher).allMatch(Matcher::matches)) {
                System.out.println("Fichero valido");
            } else {
                System.out.println("Fichero no correcto");
            }

        } catch (SecurityException e) {
            System.out.println("No se disponen de los permisos necesarios para abrir el fichero");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean isValidFormat(String cadena) {
        /*
        String[] valoresCadena = cadena.split(" ");

        if (valoresCadena.length != 4) return false;
        if (!valoresCadena[0].toLowerCase().matches("^[a-z]{2,}$")) return false;
        if (!valoresCadena[1].toLowerCase().matches("^[a-z]{2,}$")) return false;
        if (!valoresCadena[2].toLowerCase().matches("^[a-z]{2,}$")) return false;
        return Integer.parseInt(valoresCadena[3]) >= 1 && Integer.parseInt(valoresCadena[3]) <= 99;
        */

        return cadena.matches("^(\\p{L}{2,}\\s){3}(([1-9]\\d?)|0[1-9])$");
    }
}
