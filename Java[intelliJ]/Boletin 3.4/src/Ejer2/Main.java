package Ejer2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cadena a = new Cadena(sc.nextLine());
        sc.close();

        System.out.println("\n" + a);

        System.out.println(a.getContMay());
    }
}
