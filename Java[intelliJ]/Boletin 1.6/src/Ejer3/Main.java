package Ejer3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca un número");
        int num = sc.nextInt();
        sc.close();

        //int numB = Math.abs(num);
        int numB = num;
        int i;

        for (i = 0; numB != 0; i++) {
            numB /= 10;
        }

        System.out.printf("El número %d tiene %d cifras", num, i);
    }
}