package Ejer10;

import java.util.Scanner;
import static java.lang.Character.isLetter;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena;

        System.out.println("Introduzca una dirección web:");
        cadena = sc.nextLine();

        while (!isValidWeb(cadena)) {
            System.out.println("\nNo es una web valida, pruebe de nuevo.");
            cadena = sc.nextLine();
        }

        System.out.println("La web introducida es valida.");
    }


    private static boolean isValidWeb(String web) {

        if (!web.startsWith("https://www.")) return false;
        if (!web.endsWith(".com") && !web.endsWith(".es")) return false;
        if (!isLetter(web.charAt(10))) return false;

        //TODO: Establecer reglas.
        return true;
    }
}
