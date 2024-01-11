package Ejer7;

import java.util.Scanner;
import static java.lang.Character.toLowerCase;

public class Main {
    public static void main(String[] args) {
        //if ("h".matches())
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca la frase.\n");
        String frase = sc.nextLine();
        sc.close();

        System.out.println("\n" + moverVocales(frase));
    }

    private static String moverVocales(String cadena) {
        StringBuilder str = new StringBuilder(cadena.replaceAll("\\s+", ""));
        int auxCadena = 0;

        for (int i = 0; i < str.length(); i++) {

            //TODO: No detecta acentos.
            if (String.valueOf(toLowerCase(str.charAt(auxCadena))).matches("[aeiou]")) {

                str.append(str.charAt(auxCadena));
                str.deleteCharAt(auxCadena);
            } else {
                auxCadena++;
            }
        }

        return String.valueOf(str);
    }
}