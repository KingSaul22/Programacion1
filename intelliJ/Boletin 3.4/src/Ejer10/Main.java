package Ejer10;

import java.util.Scanner;

import static java.lang.Character.isLetter;
import static java.lang.Character.isDigit;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena;

        System.out.println("Introduzca una dirección web:");
        cadena = sc.nextLine();

        while (!isValidWeb(cadena)) {//TODO: Establecer que el usuario introduzca 10 webs.
            System.out.println("\nNo es una web valida, pruebe de nuevo.");
            cadena = sc.nextLine();
        }

        System.out.println("La web introducida es valida.");
    }


    private static boolean isValidWeb(String web) {

        if (!web.startsWith("https://www.")) return false;
        if (!isLetter(web.charAt(12))) return false;

        StringBuilder direccion = new StringBuilder(web).delete(0, 12);

        if (web.endsWith(".com")) {
            direccion.delete(direccion.length() - 4, direccion.length());

        } else if (web.endsWith(".es")) {
            direccion.delete(direccion.length() - 3, direccion.length());

        } else return false;

        for (int i = 1; i < direccion.length(); i++) {

            if (!isLetter(direccion.charAt(i)) || !isDigit(direccion.charAt(i))) return false;
        }

        //TODO: La dirección debe contener solo letras o digitos.

        return true;
    }
}
