/*
package Ejer7;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Random r = new Random();
    final int numRandom = 1001;
    public static void main(String[] args) {
        final int numRandom = 1001;
        int elem = -1;

        System.out.println("Indica el tamaño del array:");
        int numArray = sc.nextInt();
        System.out.println("Indica el valor que deseas hallar:");
        int numBuscar = sc.nextInt();
        sc.close();
        System.out.println();

        int[] miArray = new int[numArray];

        do {
            elem++;
            miArray[elem] = r.nextInt(numRandom);
        } while (miArray[elem] != numBuscar && elem < numArray - 1);

        if (numBuscar == miArray[elem]){
            System.out.printf("El número %d, se encuentra en la posición %d del Array.", numBuscar, elem);
        } else {
            System.out.printf("El número %d, no se encuentra en el Array.", numBuscar);
        }
    }

    private static void insertarValor(int[] arrayEnteros) {

        for (int elem = 0; elem <= arrayEnteros.length - 1; elem++) {
            arrayEnteros[elem] = r.nextInt(numRandom);

        }

    }
}*/
