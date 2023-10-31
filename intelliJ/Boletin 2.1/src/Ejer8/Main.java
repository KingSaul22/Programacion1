package Ejer8;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Random r = new Random();
    private static final int numRandom = 1001;
    private static int encontrado = 0;
    private static int[] arrayEncontrado;

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
            if (encontrado==1){
                System.out.printf("El número %d, se encuentra %d veces en el Array.\nSu posición es la siguiente:\n", numBuscar, encontrado);

            }else{

                System.out.printf("El número %d, se encuentra %d veces en el Array.\nSus posiciones son las siguientes:\n", numBuscar, encontrado);
            }
            imprimeArray();
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
        if (encontrado >= 1) {
            int indice=0;
            arrayEncontrado = new int[encontrado];
            for (int elem = 0; elem < arrayEnteros.length; elem++) {
                if (arrayEnteros[elem] == buscarNum) {
                    arrayEncontrado[indice]=elem;
                    indice++;
                }
            }
        }

        return encontrado > 0;
    }

    private static void imprimeArray() {
        for (int elem : arrayEncontrado) {
            System.out.println(elem);
        }
    }
}