package Ejer4b;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca una frase");
        String sentence = sc.nextLine();

        System.out.println("\nIntroduzca la palabra escondida");
        String word = sc.nextLine();

        if (encontrarPalabra(sentence, word)) {
            System.out.println("\nLa palabra se ha encontrado.");
        } else {
            System.out.println("\nLa palabra no se ha encontrado");
        }
    }

    private static boolean encontrarPalabra(String cadena, String palabra) {
        cadena = cadena.toLowerCase();
        palabra = palabra.toLowerCase();

        int auxWord = 0;
        for (int i = 0; i < cadena.length() && auxWord < palabra.length(); i++) {

            if (cadena.charAt(i) == palabra.charAt(auxWord)) {
                auxWord++;
            }
        }

        return auxWord == palabra.length();
    }
}