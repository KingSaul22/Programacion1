package Ejer4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca una frase");
        String frase = sc.nextLine();

        System.out.println("Introduzca la palabra escondida");
        String word = sc.nextLine();

        int auxWord = 0;
        for (int i = 0; i < frase.length() && auxWord < word.length(); i++) {

            if (frase.toLowerCase().charAt(i) == word.toLowerCase().charAt(auxWord)) {
                auxWord++;
            }
        }

        if (auxWord == word.length()) {
            System.out.println("La palabra se ha encontrado.");
        } else {
            System.out.println("La palabra no se ha encontrado");
        }
    }
}
