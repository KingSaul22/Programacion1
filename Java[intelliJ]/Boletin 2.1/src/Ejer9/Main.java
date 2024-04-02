package Ejer9;

import java.util.Arrays;
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
        sc.nextLine();
        System.out.println("Indica si quieres que el array se ordene de mayor a menor o viceversa ('mayor' o 'menor'):");
        String ordenar = sc.nextLine();
        sc.close();
        System.out.println();

        int[] miArray = new int[tamArray];

        insertarValor(miArray);

        if (contieneValor(miArray, numBuscar, ordenar)) {
            if (encontrado == 1) {
                System.out.printf("\nEl número %d, se encuentra %d veces en el Array.\nSu posición es la siguiente:\n", numBuscar, encontrado);

            } else {

                System.out.printf("El número %d, se encuentra %d veces en el Array.\nSus posiciones son las siguientes:\n", numBuscar, encontrado);
            }
            imprimeArray();
        } else {
            System.out.printf("\nEl número %d, no se encuentra en el Array.\n%d", numBuscar, encontrado);
        }

    }

    private static void insertarValor(int[] arrayEnteros) {

        for (int elem = 0; elem <= arrayEnteros.length - 1; elem++) {

            arrayEnteros[elem] = r.nextInt(numRandom);
        }
    }

    private static boolean contieneValor(int[] arrayEnteros, int buscarNum, String orden) {
        for (int elem : arrayEnteros) {
            if (elem == buscarNum) {
                encontrado++;
            }
        }
        if (encontrado >= 1) {
            int indice = 0;
            arrayEncontrado = new int[encontrado];
            for (int elem = 0; elem < arrayEnteros.length; elem++) {
                if (arrayEnteros[elem] == buscarNum) {
                    arrayEncontrado[indice] = elem;
                    indice++;
                }
            }
        } else {
            encontrado = -1;
        }
        if (orden.equalsIgnoreCase("mayor")) {
            int cajon = 0;
            for (int i = arrayEnteros.length - 1; i > 0; i--) {
                for (int elem = 1; elem <= i; elem++) {
                    if (arrayEnteros[elem] > arrayEnteros[elem - 1]) {
                        cajon = arrayEnteros[elem];
                        arrayEnteros[elem] = arrayEnteros[elem - 1];
                        arrayEnteros[elem - 1] = cajon;
                    }
                }
            }
        } else {
            Arrays.sort(arrayEnteros);
        }
        System.out.println(Arrays.toString(arrayEnteros));

        return encontrado > 0;
    }

    private static void imprimeArray() {
        for (int elem : arrayEncontrado) {
            System.out.println(elem);
        }
    }
}