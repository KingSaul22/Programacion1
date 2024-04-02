package Ejer11;

import java.util.Scanner;

import static java.lang.Character.toLowerCase;

public class Main {
    private static final int MAX_INTENTOS = 7;
    private static StringBuilder letrasUsadas = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca la palabra secreta.");
        final String word = sc.nextLine();

        char[] auxWord = new char[word.length()];
        for (int i = 0; i < auxWord.length; i++) auxWord[i] = '*';
        char letra;
        int intento = 1;

        do {
            System.out.println("\nIntroduzca una letra");
            letra = sc.nextLine().charAt(0);

            if (isValidLetter(letra, word)) {
                System.out.print("Letra valida, la palabra queda así: ");

                for (int i = 0; i != -1; i++) {
                    i = word.indexOf(letra, i);

                    if (i != -1) {
                        auxWord[i] = letra;
                    } else break;
                    //i != -1 ? auxWord[i] = letra : break;
                }
                System.out.println(String.valueOf(auxWord));

            } else {
                System.out.println("Intento fallido.");
                intento++;
            }

        } while (intento <= MAX_INTENTOS && !word.equals(String.valueOf(auxWord))); //auxWord es un char array.
        sc.close();


        if (intento == 8) {
            System.out.println("\nFracasaste, la palabra correcta es: " + word);

        } else {
            System.out.println("\nHas completado la palabra '" + word + "', felicidades");
        }
    }

    private static boolean isValidLetter(char letter, String palabra) {
        letter = toLowerCase(letter);
        palabra = palabra.toLowerCase();

        if (String.valueOf(letrasUsadas).contains(String.valueOf(letter))) {

            System.out.println("Letra ya usada.");
            return false;

        } else {
            letrasUsadas.append(letter);
        }

        return palabra.contains(String.valueOf(letter));
    }

    //private static boolean stringContentLetter(char letter) {

    //}
}
