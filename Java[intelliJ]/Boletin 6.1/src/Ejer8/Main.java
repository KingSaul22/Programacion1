package Ejer8;

import utils.MiEntradaSalida;

public class Main {
    public static void main(String[] args) {
        String nombreCompletoEdad = MiEntradaSalida.leerCadena("Introduzca su nombre, apellidos y edad");
        while (isValidFormat(nombreCompletoEdad)) {
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
    }

    private static boolean isValidFormat(String cadena) {
        String[] valoresCadena = cadena.split(" ");

        if (valoresCadena.length != 4) return false;
        if (!valoresCadena[0].toLowerCase().matches("[a-z]") || valoresCadena[0].length() < 2) return false;
        if (!valoresCadena[1].toLowerCase().matches("[a-z]") || valoresCadena[1].length() < 2) return false;
        if (!valoresCadena[2].toLowerCase().matches("[a-z]") || valoresCadena[2].length() < 2) return false;
        return Integer.parseInt(valoresCadena[3]) >= 1 && Integer.parseInt(valoresCadena[3]) <= 99;
    }
}
