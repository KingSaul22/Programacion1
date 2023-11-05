package Ejer17;


public class Main {
    public static void main(String[] args) {
        final int numFila = 10;

        int[][] matrizA = new int[numFila][10];

        for (int fila = 0; fila < numFila; fila++) {

            for (int colum = 0; colum < 10; colum++) {
                matrizA[fila][colum] = (fila + 1) * (colum + 1);
            }
        }
         int[][] matrizB = matrizA;

        /*for (int fila = 0; fila < matrizB.length; fila++) {

            for (int colum = 0; colum < matrizB[fila].length; colum++) {
                System.out.print(matrizB[fila][colum] + " | ");

            }
            System.out.println();
        }*/

        for (int[] fila : matrizB) {

            for (int colum : fila) {
                System.out.print(colum + " | ");

            }
            System.out.println();
        }
    }
}
