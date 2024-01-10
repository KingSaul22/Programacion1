package Ejer4b;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca una frase");
        String sentence = sc.nextLine();

        System.out.println("Introduzca la palabra escondida");
        String word = sc.nextLine();

        if (encontrarPalabra(sentence.toLowerCase(), word.toLowerCase())) {
            System.out.println("La palabra se ha encontrado.");
        } else {
            System.out.println("La palabra no se ha encontrado");
        }
    }

    private static boolean encontrarPalabra(String cadena, String palabra) {

        int auxWord = 0;
        for (int i = 0; i < cadena.length() && auxWord < palabra.length(); i++) {
            if (cadena.charAt(i) == palabra.charAt(auxWord)) {
                auxWord++;
            }
        }

        return auxWord == palabra.length();
    }
}