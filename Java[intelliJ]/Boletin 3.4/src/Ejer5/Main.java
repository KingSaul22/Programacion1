package Ejer5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nIntroduzca una frase original: ");
        String sentence = sc.nextLine();

        System.out.print("\nIntroduzca el texto a buscar: ");
        String word1 = sc.nextLine();

        System.out.print("Introduzca el texto que reemplaza: ");
        String word2 = sc.nextLine();


        System.out.println("\n" + reemplazaExpresion(sentence, word1, word2));
    }

    private static String reemplazaExpresion(String frase, String reemplazado, String reemplazador) {
        StringBuilder str = new StringBuilder(frase);

        //for (int i = str.indexOf(reemplazado); i != -1; i += reemplazador.length()) {
        for (int i = 0; i != -1; i += reemplazador.length()) {
            i = str.indexOf(reemplazado, i);

            if (i != -1) {
                str.delete(i, i + reemplazado.length());
                str.insert(i, reemplazador);

            } else {
                //i = -1 - reemplazador.length();
                break;
            }
        }

        return String.valueOf(str);
    }
}
