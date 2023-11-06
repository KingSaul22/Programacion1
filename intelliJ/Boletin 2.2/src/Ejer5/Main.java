package Ejer5;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Introduzca el número de filas para la matriz.");
        int numFila = sc.nextInt();
        System.out.println("Introduzca el número de columnas para la matriz.");
        int numColum = sc.nextInt();

        int[][] miMatriz = new int[numFila][numColum];

        insertarValores(miMatriz);

        sc.close();

        imprimirMatrizC(miMatriz);
    }

    public static void insertarValores(int[][] matriz) {
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int colum = 0; colum < matriz[0].length; colum++) {

                System.out.printf("Introduzca un entero para la posición %dx%d: ", fila, colum);
                matriz[fila][colum] = sc.nextInt();
            }
        }
    }

    public static void imprimirMatrizC(int[][] matriz) {
        System.out.print("\nLa salida es:");
        for (int colum = 0; colum < matriz[0].length; colum++) {
            for (int fila = 0; fila < matriz.length; fila++) {

                System.out.print(" " + matriz[fila][colum]);
            }
        }
    }
}