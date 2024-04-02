package Ejer10;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Character.isLetter;
import static java.lang.Character.isDigit;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena;
        String[] allWeb = new String[10];
        int auxWebValid = 0, auxWebInvalid = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Introduzca una dirección web:");
            cadena = sc.nextLine();

            if (isValidWeb(cadena)) {
                System.out.println("La dirección introducida es valida.\n");
                allWeb[auxWebValid] = cadena;
                auxWebValid++;

            } else {
                System.out.println("Dirección no valida.\n");
                allWeb[9 - auxWebInvalid] = cadena;
                auxWebInvalid++;
            }
        }

        imprimirWebs(allWeb, auxWebValid);
    }


    private static boolean isValidWeb(String web) {
        //Comprueba el inicio de la dirección web.
        if (!web.startsWith("https://www.") || !isLetter(web.charAt(12))) return false;

        StringBuilder direccion = new StringBuilder(web).delete(0, 12);

        if (web.endsWith(".com")) {
            direccion.delete(direccion.length() - 4, direccion.length());

        } else if (web.endsWith(".es")) {
            direccion.delete(direccion.length() - 3, direccion.length());

        } else return false;

        for (int i = 1; i < direccion.length(); i++) {

            if (!isLetter(direccion.charAt(i)) && !isDigit(direccion.charAt(i))) return false;
        }

        return true;
    }

    private static void imprimirWebs(String[] webs, int valida) {

        System.out.println("Webs validas:");
        for (int i = 0; i < valida; i++) {
            System.out.println("  · " + webs[i]);
        }

        System.out.println("\nWebs no validas:");
        for (int i = 9; i >= valida; i--) {
            System.out.println("  · " + webs[i]);
        }
    }
}
