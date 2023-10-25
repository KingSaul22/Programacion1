package Ejer6b;

import java.util.Scanner;

public class Main {
    public static final int numRandom = 1001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int elem = -1;

        System.out.println("Indica el tamaño del array:");
        int numArray = sc.nextInt();
        System.out.println("Indica el valor que deseas hallar:");
        int numBuscar = sc.nextInt();
        sc.close();
        System.out.println();

        int[] miArray = generaArrayAleatorio(numArray);

        do {
            elem++;
        } while (miArray[elem] != numBuscar && elem < numArray - 1);

        if (numBuscar == miArray[elem]){
            System.out.printf("El número %d, se encuentra en la posición %d del Array.", numBuscar, elem);
        } else {
            System.out.printf("El número %d, no se encuentra en el Array.", numBuscar);
        }
    }

    public static int[] generaArrayAleatorio(int tamArray) {
        int[] miArray = new int[tamArray];

        for (int elem = 0; elem <= miArray.length - 1; elem++) {
            miArray[elem] = (int) (Math.random() * (numRandom + 1));
        }

        return miArray;
    }
}