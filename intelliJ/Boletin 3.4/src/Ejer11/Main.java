package Ejer11;

import java.util.Scanner;

public class Main {
    private static final int MAX_INTENTOS = 7;
    private static String word;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intento = 1;

        do {
            System.out.println("Introduzca una letra");
            if (isValidLetter(sc.nextLine().charAt(0))) {

            }

        } while (intento <= MAX_INTENTOS);
    }

    private static boolean isValidLetter(char letter) {

        return word.contains(String.valueOf(letter));
    }

    //private static boolean stringContentLetter(char letter) {

    //}
}
