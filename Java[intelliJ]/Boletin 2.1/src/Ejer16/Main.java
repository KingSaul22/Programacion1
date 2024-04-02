package Ejer16;

import java.util.Scanner;

public class Main {

    public static int numMax;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca hasta que número desea calcular las tablas de multiplicar:");
        numMax = sc.nextInt();
        sc.close();

        int[][] matrizA = new int[numMax][10];

        for (int fila = 0; fila < numMax; fila++) {

            for (int colum = 0; colum < 10; colum++) {
                matrizA[fila][colum] = (fila + 1) * (colum + 1);
            }
        }
        for (int fila = 0; fila < numMax; fila++) {

            for (int colum = 0; colum < 10; colum++) {
                System.out.print(matrizA[fila][colum] + " | ");

            }
            System.out.println();
        }

    }
}
