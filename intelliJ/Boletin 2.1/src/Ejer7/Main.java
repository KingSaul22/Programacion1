package Ejer7;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Random r = new Random();
    private static final int numRandom = 1001;
    private static int encontrado = 0;

    public static void main(String[] args) {

        System.out.println("Indica el tamaño del array:");
        int tamArray = sc.nextInt();
        System.out.println("Indica el valor que deseas hallar:");
        int numBuscar = sc.nextInt();
        sc.close();
        System.out.println();

        int[] miArray = new int[tamArray];

        insertarValor(miArray);

        if (contieneValor(miArray, numBuscar)) {
            System.out.printf("El número %d, se encuentra %d veces en el Array.", numBuscar, encontrado);
        } else {
            System.out.printf("El número %d, no se encuentra en el Array.", numBuscar);
        }

    }

    private static void insertarValor(int[] arrayEnteros) {

        for (int elem = 0; elem <= arrayEnteros.length - 1; elem++) {

            arrayEnteros[elem] = r.nextInt(numRandom);
        }
    }

    private static boolean contieneValor(int[] arrayEnteros, int buscarNum) {
        for (int elem : arrayEnteros) {
            if (elem == buscarNum) {
                encontrado++;
            }
        }
        return encontrado > 0;
    }
}
