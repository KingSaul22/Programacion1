package Ejer3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca el número de filas para la matriz.");
        int numFila = sc.nextInt();
        System.out.println("Introduzca el número de columnas para la matriz.");
        int numColum = sc.nextInt();

        int[][] miMatriz = new int[numFila][numColum];

        for (int fila = 0; fila < miMatriz.length; fila++) {
            for (int colum = 0; colum < miMatriz[0].length; colum++) {

                System.out.printf("Introduzca un entero para la posición %dx%d:", fila, colum);
                miMatriz[fila][colum] = sc.nextInt();
            }
        }

        System.out.print("\nLa salida es:");
        for (int fila = 0; fila < miMatriz.length; fila++) {
            for (int colum = 0; colum < miMatriz[0].length; colum++) {

                System.out.print(" " + miMatriz[fila][colum]);
            }
        }
    }
}
