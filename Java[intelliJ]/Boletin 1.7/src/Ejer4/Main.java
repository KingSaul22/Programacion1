package Ejer4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dias = 0;

        System.out.println("Introduzca la hora base:");
        int horaA = sc.nextInt();
        System.out.println("Introduzca los minutos base:");
        int minA = sc.nextInt();
        System.out.println("Introduzca los segundos base:");
        int secA = sc.nextInt();
        System.out.printf("Fecha base, %d:%d:%d\n\n", horaA, minA, secA);

        System.out.println("¿Cuantas horas desea sumar?");
        int horaB = sc.nextInt();
        System.out.println("¿Cuantos minutos desea sumar?");
        int minB = sc.nextInt();
        System.out.println("¿Cuantos segundos desea sumar?");
        int secB = sc.nextInt();
        sc.close();
        System.out.printf("Tiempo a añadir, %d:%d:%d\n\n", horaB, minB, secB);


        secB += secA;
        if (secB >= 60) {
            secB -= 60;
            minB += 1;
        }

        minB += minA;
        if (minB >= 60) {
            minB -= 60;
            horaB += 1;
        }

        horaB += horaA;
        while (horaB >= 24) {
            horaB -= 24;
            dias++;
        }


        if (dias == 0) {
            System.out.printf("La hora resultante es: %d:%d:%d", horaB, minB, secB);
        } else {
            System.out.printf("Tras el paso de %d dias, la hora resultante es: %d:%d:%d", dias, horaB, minB, secB);
        }
    }
}
