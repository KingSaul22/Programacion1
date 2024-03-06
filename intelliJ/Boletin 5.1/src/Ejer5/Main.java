package Ejer5;

import java.util.Scanner;

public class Main {
    private static final Scanner SC = new Scanner(System.in);
    private static final Diccionario DICCIONARIO = new Diccionario();

    public static void main(String[] args) {
        int opcion;
        do {
            imprimirMenu();
            opcion = seleccionarOpcion();
            System.out.println();

            switch (opcion) {
                case 1 -> nuevaPalabra();
                case 2 -> buscarSignificado();
                case 3 -> borrarPalabra();
                case 4 -> buscarPalabraCadena();
                default -> SC.close();
            }
        } while (opcion != 5);
        System.out.println("\n¡Gracias por usar el diccionario!");
    }

    private static void nuevaPalabra() {
        //String palabra = introducirCadena("Introduzca una palabra");
        //String significado = introducirCadena("Introduzca el significado");

        DICCIONARIO.nuevaPalabra(
                introducirCadena("Introduzca una palabra"),
                introducirCadena("Introduzca el significado")
        );
    }

    private static void buscarSignificado() {
        try {
            System.out.println(DICCIONARIO.buscarPalabra(introducirCadena("Introduzca la palabra a buscar")));
        } catch (DiccionarioException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void borrarPalabra() {
        DICCIONARIO.borrarPalabra(introducirCadena("Introduzca la palabra a borrar"));
    }

    private static void buscarPalabraCadena() {
        System.out.println(DICCIONARIO.getPalabrasCadenaLetra(
                introducirCadena("Introduzca los caracteres iniciales de la palabra")
        ));
    }

    private static String introducirCadena(String mensaje) {
        String palabra;
        do {
            System.out.print(mensaje + ": ");
            palabra = SC.nextLine();
        } while (palabra.isBlank());
        palabra = palabra.toUpperCase();

        if (palabra.length() == 1) return palabra;
        return palabra.charAt(0) + palabra.substring(1).toLowerCase();
    }

    private static void imprimirMenu() {
        System.out.println("""
                                
                Seleccione una opción:
                  1. Añadir una palabra al diccionario
                  2. Buscar los significados de una palabra
                  3. Borrar una palabra
                  4. Buscar las palabras que coincida con unos caracteres dados
                  5. Finalizar el programa""");
    }

    private static int seleccionarOpcion() {
        int opcion = -1;
        do {
            System.out.print("Selección [1 - 5]: ");
            try {
                opcion = Integer.parseInt(SC.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduzca un número");
            }
        } while (opcion < 1 || opcion > 5);

        return opcion;
    }
}
