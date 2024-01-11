package Ejer9;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nIntroduzca una frase: ");
        String sentence = sc.nextLine();
        sentence = "Frase con números, 12 entre las palabras 456 y al final 1000";
        sc.close();

        System.out.print("\nEl total de la suma de los números comprendidos en la cadena ");
        System.out.printf("'%s' es de: %d", sentence, sumaDesdeString(sentence));
    }


    private static int sumaDesdeString (String cadena) {

    }
}
