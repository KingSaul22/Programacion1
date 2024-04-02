package Ejer2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca la base:");
        int num1 = sc.nextInt();
        int calEx = num1;

        System.out.println("Introduzca el exponente:");
        int num2 = sc.nextInt();

        if (num1 != 0) {
            if (num2 == 0) {
                calEx = 1;
            } else {
                for (int i = 1; i < num2; i++) {
                    calEx *= num1;
                }
            }
        }

        System.out.printf("El resultado de usar como base a %d y como exponente a %d nos da como resultado: %d", num1, num2, calEx);
    }
}
