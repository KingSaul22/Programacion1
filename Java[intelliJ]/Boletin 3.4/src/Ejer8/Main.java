package Ejer8;

import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nIntroduzca una frase original: ");
        String sentence = sc.nextLine();
        //sentence = "He estudiado mucho";
        sc.close();

        //System.out.println("La frase: '" + sentence + "', está compuesta por " + cuentaPalabras(sentence) + " palabras.");
        System.out.printf("\nLa frase: '%s', está compuesta por %d palabras.", sentence, cuentaPalabras(sentence));
        System.out.printf("\n\nLa frase: '%s', está compuesta por %d palabras.", sentence, cuentaPalabras2(sentence));
    }

    private static int cuentaPalabras(String cadena) {
        int auxEspacio = 1;

        cadena = cadena.trim().replaceAll("\\s+", " ");

        for (int i = 0; i < cadena.length(); i++) {

            if (cadena.charAt(i) == ' ') auxEspacio++;
        }

        return cadena.isBlank() ? 0 : auxEspacio;
    }

    private static int cuentaPalabras2(String cadena) {

        return cadena.isBlank() ? 0 :  cadena.trim().split("\\s+").length;
    }
}
