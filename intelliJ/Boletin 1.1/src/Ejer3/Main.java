package Ejer3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1;
        int num2;

        do {
            System.out.println("Intrdouzca un número:");
            num1 = sc.nextInt();
        } while (num1 <= 0);

        do {
            System.out.println("Introduzca otro número:");
            num2 = sc.nextInt();
        } while (num2 <= 0);

        if (num1 % 2 == 0){
            System.out.printf("%d es par.\n", num1);
        } else {
            System.out.printf("%d es impar.\n", num1);
        }

        if (num2 % 2 == 0){
            System.out.printf("%d es par.\n", num2);
        } else {
            System.out.printf("%d es impar.\n", num2);
        }
    }
}