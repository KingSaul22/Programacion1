package Ejer14;

public class Main {
    public static void main(String[] args) {
        int[][] miMatriz = {{1,2,3},{4,5,6}};

        int[][] matrizB = matrizFtoC(miMatriz);

    }

    public static int[][] matrizFtoC(int[][] matriz) {
        int[][] matrizInv = new int[matriz[0].length][matriz.length];

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int colum = 0; colum < matriz[0].length; colum++) {

                matrizInv[fila][colum] = matriz[fila][colum];
            }
        }

        return matrizInv;
    }
}
