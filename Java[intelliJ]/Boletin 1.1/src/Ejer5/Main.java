package Ejer5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num;
        int suma = -1;

        do {
            System.out.println("Introduzca un número negativo para finalizar el programa.");
            num = sc.nextInt();
            suma++;
        } while (num >= 0);

        System.out.printf("Ha escrito %d números positivos", suma);
    }

}
