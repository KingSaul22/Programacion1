package Ejer12;

public class Main {
    public static void main(String[] args) {
        int[][] miMatrizA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        if (miMatrizA.length == miMatrizA[0].length) {
            int[][] miMatrizB = invertirMatriz(miMatrizA);

            /*for (int fila = 0; fila < miMatrizB.length; fila++) {
                for (int colum = 0; colum < miMatrizB[0].length; colum++) {

                    System.out.print(miMatrizB[fila][colum]);
                }
                System.out.println();
            }*/
        } else {
            System.out.println("La matriz dada no es cuadrada, no se procederá con la inversión.");
        }

    }

    public static int[][] invertirMatriz(int[][] matriz) {
        int[][] matrizInv = new int[matriz.length][matriz[0].length];

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int colum = 0; colum < matriz[0].length; colum++) {

                matrizInv[matriz.length - 1 - fila][matrizInv[0].length - 1 - colum] = matriz[fila][colum];
            }
        }

        return matrizInv;
    }
}
