package Ejer4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        final int numRandom = 101;

        int posMD;
        double media = 0, porcentaje = 0;

        int[] miDigito = new int[10];
        for (int elem = 0; elem <= miDigito.length - 1; elem++) {
            miDigito[elem] = 0;
        }

        final int numArray = 6000;
        int[] miArray = new int[numArray];

        for (int elem = 0; elem <= miArray.length - 1; elem++) {
            miArray[elem] = r.nextInt(numRandom);

            media += miArray[elem];

            posMD = miArray[elem] % 10;
            miDigito[posMD]++;
        }

        media /= numArray;

        for (int elem = 0; elem <= miDigito.length - 1; elem++) {
            System.out.printf("Los números cuyo último dígito es %d, son un total de %d números.\n", elem, miDigito[elem]);
            System.out.println("Esto equivale a un " + (double) miDigito[elem] / numArray * 100 + "%\n");
            porcentaje += (double) miDigito[elem] / numArray * 100;
        }

        System.out.println("La media de los números del vector es: " + media);
        System.out.println("La suma de los porcentajes es: " + porcentaje + "% y su media es: " + porcentaje / 10 + "%");


        /*for (int elem = 0; elem <= miDigito.length - 1; elem++) {
            if (miDigito[elem] > 0) {
                System.out.printf("Los números cuyo último dígito es %d, son un total de %d números.\n", elem, miDigito[elem]);
                System.out.println("Esto equivale a un " + (double) miDigito[elem] / numArray * 100 + "%\n");
                porcentaje += (double) miDigito[elem] / numArray * 100;
            }
        }
        for (int elem = 0; elem <= miDigito.length - 1; elem++) {
            if (miDigito[elem] == 0) {
                System.out.printf("Los números cuyo último dígito es %d no se han repetido.\n", elem);
                System.out.println("Esto equivale a un 0%\n");
            }
        }*/
    }

}