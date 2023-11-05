package Ejer18b;

public class Main {
    public static void main(String[] args) {
        final int numFila = 5;
        final int numColum = 10;

        int[][] matrizA = new int[numFila][numColum];

        for (int fila = 0; fila < numFila; fila++) {

            for (int colum = 0; colum < numColum; colum++) {
                matrizA[fila][colum] = (fila + 1) * (colum + 1);
            }
        }

        int[][] matrizB = new int[matrizA.length][matrizA[0].length];
        int[][] matrizC = new int[matrizA.length][matrizA[0].length];

        for (int fila = 0; fila < matrizA.length; fila++) {

            for (int colum = 0; colum < matrizA[fila].length; colum++) {

                matrizB[fila][matrizB[0].length - 1 - colum] = matrizA[fila][colum];
            }
        }

        for (int colum = 0; colum < matrizB[0].length; colum++) {

            for (int fila = 0; fila < matrizB.length; fila++) {

                matrizC[matrizC.length - 1 - fila][colum] = matrizB[fila][colum];
            }
        }


        for (int[] fila : matrizA) {

            for (int colum : fila) {
                System.out.print(colum + " | ");

            }
            System.out.println();
        }
        System.out.println("\n\n");

        for (int[] fila : matrizB) {

            for (int colum : fila) {
                System.out.print(colum + " | ");

            }
            System.out.println();
        }
        System.out.println("\n\n");

        for (int[] fila : matrizC) {

            for (int colum : fila) {
                System.out.print(colum + " | ");

            }
            System.out.println();
        }
    }
}