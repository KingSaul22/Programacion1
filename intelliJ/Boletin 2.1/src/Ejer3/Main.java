package Ejer3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numMax = Integer.MIN_VALUE;
        int numMin = Integer.MAX_VALUE;
        double media = 0;
        int maxR = 1, minR = 1;

        System.out.println("¿Cuantos números desea introducir?");
        int numArray = sc.nextInt();
        int[] miArray = new int[numArray];

        for (int elem = 0; elem <= miArray.length - 1; elem++) {
            elem++;
            System.out.printf("\nIntroduzca un %dº número entero para colocar en la matriz: ", elem);
            elem--;
            miArray[elem] = sc.nextInt();

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

        sc.close();
        media /= numArray;

        if (maxR <= 1) {
            System.out.printf("\nEl mayor valor de la matriz es: %d", numMax);
        } else {
            System.out.printf("\nEl mayor valor de la matriz es: %d y se repite un total de %d veces", numMax, maxR);
        }

        if (minR <= 1) {
            System.out.printf("\nEl menor valor de la matriz es: %d", numMin);
        } else {
            System.out.printf("\nEl menor valor de la matriz es: %d y se repite un total de %d veces", numMin, minR);
        }

        System.out.println("\nY la media es: " + media);
    }
}