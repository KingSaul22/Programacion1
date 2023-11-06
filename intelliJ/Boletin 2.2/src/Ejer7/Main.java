package Ejer7;

public class Main {
    public static void main(String[] args) {

        int[][] miMatrizA = {{1, 2, 3}, {4, 5, 6}};
        int[][] miMatrizB = {{1, 2, 3}, {4, 5, 6}};

        comprobarIgual(miMatrizA, miMatrizB);
    }

    public static void comprobarIgual(int[][] matrizA, int[][] matrizB) {
        int numDiff = 0;

        for (int fila = 0; fila < matrizA.length; fila++) {
            for (int colum = 0; colum < matrizA[0].length; colum++) {

                if (matrizA[fila][colum] != matrizB[fila][colum]) {
                    numDiff++;
                }
            }
        }

        if (numDiff >= 1) {
            System.out.println("Las matrices dadas son diferentes");
        } else {
            System.out.println("Las matrices dadas son iguales");
        }
    }
}
