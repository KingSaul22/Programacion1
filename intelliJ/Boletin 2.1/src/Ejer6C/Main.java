package Ejer6C;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final int numRandom = 1001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica el tamaño del array:");
        int numArray = sc.nextInt();
        System.out.println("Indica el valor que deseas hallar:");
        int numBuscar = sc.nextInt();
        sc.close();
        System.out.println();

        int[] miArray = generaArrayAleatorio(numArray);
        //int[] miArray = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(miArray));

        if (encontrarElem(miArray, numBuscar)) {
            System.out.printf("El número %d, se encuentra en el Array.", numBuscar);
        } else {
            System.out.printf("El número %d, no se encuentra en el Array.", numBuscar);
        }
    }

    public static boolean encontrarElem(int[] array, int buscado) {
        for (int elem : array) {
            if (elem == buscado) {
                return true;
            }
            //return array[i] == buscado;
        }
        return false;
    }

    public static int[] generaArrayAleatorio(int tamArray) {
        int[] miArray = new int[tamArray];

        for (int elem = 0; elem <= miArray.length - 1; elem++) {
            miArray[elem] = (int) (Math.random() * (numRandom + 1));
        }

        return miArray;
    }
}