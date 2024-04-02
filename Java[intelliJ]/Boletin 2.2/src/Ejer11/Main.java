package Ejer11;

public class Main {
    public static void main(String[] args) {
        int[][] miMatrizA = {{1, 2, 3}, {1, 2, 3}};
        int[][] miMatrizB = {{3, 2, 1}, {3, 2, 1}};

        comprobarInv(miMatrizA, miMatrizB);
    }

    public static void comprobarInv(int[][] matrizA, int[][] matrizB) {
        int numDiff = 0;
        for (int fila = 0; fila < matrizA.length; fila++) {
            for (int colum = 0; colum < matrizA[0].length; colum++) {

                if (matrizA[fila][colum] != matrizB[matrizB.length - 1 - fila][matrizB[0].length - 1 - colum]) {
                    numDiff++;
                }
            }
        }
        if (numDiff >= 1) {
            System.out.println("Las matrices dadas no son inversas.");
        } else {
            System.out.println("Las matrices dadas son inversas.");
        }
    }
}
