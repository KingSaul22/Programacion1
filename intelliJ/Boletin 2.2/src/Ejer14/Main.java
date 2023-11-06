package Ejer14;

public class Main {
    public static void main(String[] args) {
        int[][] miMatriz = {{1,2,3},{4,5,6}};
        imprimirMatriz(miMatriz);

        int[][] matrizB = matrizFtoC(miMatriz);
        imprimirMatriz(matrizB);
    }

    public static int[][] matrizFtoC(int[][] matriz) {
        int[][] matrizInv = new int[matriz[0].length][matriz.length];

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int colum = 0; colum < matriz[0].length; colum++) {

                matrizInv[colum][fila] = matriz[fila][colum];
            }
        }

        return matrizInv;
    }

    public static void imprimirMatriz(int[][] matriz) {
        System.out.print("\nLa salida es:\n");
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int colum = 0; colum < matriz[0].length; colum++) {

                System.out.print(" " + matriz[fila][colum]);
            }
            System.out.println();
        }
    }
}
