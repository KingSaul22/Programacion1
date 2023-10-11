package Ejer5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int suma = 0;
        int numS = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        System.out.println("Introduzca cuatro números, por favor.");
        for (int i = 1; i <= 4; i++) {
            int num;

            System.out.printf("Introduzca el %dº número\n", i);
            num = sc.nextInt();
            /*try {
                num = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número entero válido.");
            }*/
            if (num == -1) {
                break;
            }

            suma += num;
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            /*if (num <= -2){
                numS--;
                i--;
            }*/
            numS++;
        }
        sc.close();

        double media = suma;
        media = media / numS;

        System.out.printf("De los %d números introducidos, el minimo es %d, el máximo es %d y la media es %f.", numS, min, max, media);
    }
}

