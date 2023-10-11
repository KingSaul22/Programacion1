package Ejer8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca la hora A");
        int horaA = sc.nextInt();
        System.out.println("Introduzca la hora B");
        int horaB = sc.nextInt();

        if (horaA - horaB == 0) {
            System.out.println("Introduzca los minutos A");
            horaA = sc.nextInt();
            System.out.println("Introduzca los minutos B");
            horaB = sc.nextInt();

            if (horaA - horaB == 0) {
                System.out.println("Introduzca los segundos A");
                horaA = sc.nextInt();
                System.out.println("Introduzca los segundos B");
                horaB = sc.nextInt();

                if (horaA - horaB == 0) {
                    System.out.println("Son la misma hora");
                } else if (horaA > horaB) {
                    System.out.println("La hora A es mayor que la hora B");
                } else {
                    System.out.println("La hora B es mayor que la hora A");
                }

            } else if (horaA > horaB) {
                System.out.println("La hora A es mayor que la hora B independientemente de los segundos");
            } else {
                System.out.println("La hora B es mayor que la hora A independientemente de los segundos");
            }

        } else {
            if (horaA > horaB) {
                System.out.println("La hora A sera mayor independientemente de los minutos o segundos");
            } else {
                System.out.println("La hora B sera mayor independientemente de los minutos o segundos");
            }
        }
    }
}
