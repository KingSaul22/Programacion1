package Ejer6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduzca la frase: ");
        String frase = sc.nextLine();
        sc.close();

        System.out.println("\nLa frase: '" + frase + "', contiene "+ detectorVocales(frase) +" vocales.");

    }

    private static int detectorVocales (String cadena) {
        int auxVocal = 0;
        cadena = cadena.toLowerCase();

        if (cadena.contains("a")) auxVocal++;
        if (cadena.contains("e")) auxVocal++;
        if (cadena.contains("i")) auxVocal++;
        if (cadena.contains("o")) auxVocal++;
        if (cadena.contains("u")) auxVocal++;

        return auxVocal;
    }
}
