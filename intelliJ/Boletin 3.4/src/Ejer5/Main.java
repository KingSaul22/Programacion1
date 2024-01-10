package Ejer5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Introduzca una frase original: ");
        String sentence = sc.nextLine();

        System.out.printf("Introduzca el texto a buscar: ");
        String word1 = sc.nextLine();

        System.out.printf("Introduzca el texto que reemplaza: ");
        String word2 = sc.nextLine();


        System.out.println("\n" + reemplazaExpresion(sentence, word1, word2));
    }

    private static String reemplazaExpresion(String frase, String reemplazado, String reemplazador) {

        //TODO: Revisar última letra error.
        for (int i = frase.indexOf(reemplazado); i != -1; i += reemplazador.length()) {

        }

        return frase;
    }
}
