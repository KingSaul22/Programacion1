package Ejer4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();

        int numMax = Integer.MIN_VALUE;
        int numMin = Integer.MAX_VALUE;
        float media = 0;
        int maxR = 1, minR = 1;

        final int numRandom = 101;

        int numArray = 6000;
        int[] miArray = new int[numArray];

        int[] miDigito = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int elem = 0; elem <= miArray.length - 1; elem++) {
            miArray[elem] = r.nextInt(numRandom);
            miArray[elem] = r.nextInt(numRandom);

            media += miArray[elem];
            if (elem == 0) {
                numMin = miArray[elem];
                numMax = miArray[elem];
            } else {
                if (miArray[elem] > numMax) {
                    numMax = miArray[elem];
                    maxR = 1;
                } else if (miArray[elem] < numMin) {
                    numMin = miArray[elem];
                    minR = 1;
                } else if (miArray[elem] == numMax && miArray[elem] == numMin) {
                    maxR++;
                    minR++;
                } else if (miArray[elem] == numMax) {
                    maxR++;
                } else if (miArray[elem] == numMin) {
                    minR++;
                }
            }
        }

        media /= numArray;

        if (maxR <= 1) {
            System.out.printf("\nEl mayor valor de la matriz es: %d", numMax);
        } else {
            System.out.printf("\nEl mayor valor de la matriz es: %d y se repite %d veces", numMax, maxR);
        }

        if (minR <= 1) {
            System.out.printf("\nEl menor valor de la matriz es: %d", numMin);
        } else {
            System.out.printf("\nEl menor valor de la matriz es: %d y se repite %d veces", numMin, minR);
        }

        System.out.println("\nY la media es: " + media);
    }
}