package Ejer9;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nIntroduzca una frase: ");
        String sentence = sc.nextLine();
        sentence = "Frase con números, 12 entre las palabras 456 y al final 1000";
        sc.close();

        System.out.print("\nEl total de la suma de los números comprendidos en la cadena:\n");
        System.out.printf("'%s'\nEs de: %d", sentence, sumaDesdeString(sentence));
    }


    private static int sumaDesdeString(String cadena) {
        int suma = 0;
        int auxNumero = 0;

        for (int i = 0; i < cadena.length(); i++) {

            if (Character.isDigit(cadena.charAt(i))) {
                auxNumero = auxNumero * 10 + Integer.parseInt(String.valueOf(cadena.charAt(i)));

            } else {
                suma += auxNumero;
                auxNumero = 0;
            }
        }

        return suma + auxNumero;
    }
}
