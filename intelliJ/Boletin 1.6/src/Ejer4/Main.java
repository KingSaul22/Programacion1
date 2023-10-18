package Ejer4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Random r = new Random();
        //int aleatorio2 = (int) (Math.random() * 100) + 1;
        int aleatorio = r.nextInt(100) + 1;

        System.out.println("introduzca un número entre 1 y 100, tienes 5 intentos.");
        int num = sc.nextInt();
        int i = 1;

        while (num != aleatorio && i < 5) {
            System.out.printf("Te faltan %d intentos. ", 5 - i);

            if (num >= 101 || num <= 0) {
                System.out.println("El número debe encontrarse dentro del rango 1-100.\n");
            } else if (num > aleatorio) {
                System.out.println("El número es más pequeño.\n");
            } else {
                System.out.println("El número es más grande.\n");
            }

            num = sc.nextInt();
            i++;
        }
        sc.close();

        if (num == aleatorio) {
            System.out.printf("\nHas acertado tras %d intentos, el número correcto es %d.", i, aleatorio);
        } else {
            System.out.printf("\nHas consumido todos tus intentos y no has conseguido la victoria, el número correcto era %d.", aleatorio);
        }
    }
}
