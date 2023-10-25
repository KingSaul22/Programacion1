package Ejer4b;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        final int numRandom = 101;

        int posMD, num, Max = 0, Min = 0;
        double media = 0, porcentaje = 0;

        int[] miDigito = new int[10];
        for (int elem = 0; elem <= miDigito.length - 1; elem++) {
            miDigito[elem] = 0;
        }

        final int numArray = 6000;

        for (int elem = 0; elem <= numArray - 1; elem++) {
            num = r.nextInt(numRandom);

            media += num;

            posMD = num % 10;
            miDigito[posMD]++;
        }

        media /= numArray;

        for (int elem = 0; elem <= miDigito.length - 1; elem++) {
            System.out.printf("Los números cuyo último dígito es %d, son un total de %d números.\n", elem, miDigito[elem]);
            System.out.println("Esto equivale a un " + (double) miDigito[elem] / numArray * 100 + "%\n");
            porcentaje += (double) miDigito[elem] / numArray * 100;

            if (miDigito[elem] > miDigito[Max]) {
                Max = elem;
            }
            if (miDigito[elem] < miDigito[Min]) {
                Min = elem;
            }
        }
        for (int elem = 0; elem <= miDigito.length - 1; elem++) {
            if (miDigito[elem] == miDigito[Max]) {
                Max = elem;
                System.out.println("El último dígito más repetido es: " + Max);
            }
            if (miDigito[elem] == miDigito[Min]) {
                Min = elem;
                System.out.println("El último dígito menos repetido es: " + Min);
            }
        }


        System.out.println("La media de los números del vector es: " + media);
        System.out.println("La suma de los porcentajes es: " + porcentaje + "% y su media es: " + porcentaje / 10 + "%");
    }

}