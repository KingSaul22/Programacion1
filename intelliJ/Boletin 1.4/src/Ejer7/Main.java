package Ejer7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int edadA = 35;
        final int edadB = 50;

        System.out.println("Introduzca  su edad.");
        int edad = sc.nextInt();

        if (edad > edadB) {
            sc.close();
            System.out.println("Todas las personas mayores de 50 años, un 8'5%");
        } else {
            System.out.println("Introduzca su estado civil.");
            char cState = sc.nextLine().charAt(0);
            sc.close();

            switch (cState) {
                case 'V', 'C':
                    if (edad < edadA) {
                        System.out.println("Le corresponde un 11'3%");
                    }
                    break;
                case 'D', 'S':
                    if (edad < edadA) {
                        System.out.println("Le corresponde un 12%");
                    }
                    break;
                default:
                    System.out.println("Se aplica un 10'5%");
            }
        }


    }
}
