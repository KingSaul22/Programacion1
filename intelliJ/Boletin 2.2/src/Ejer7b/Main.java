package Ejer7b;

public class Main {
    public static void main(String[] args) {

        int[][] miMatrizA = {{1, 2, 3}, {4, 5, 6}};
        int[][] miMatrizB = {{1, 2, 3}, {4, 5, 6}};

        if (comprobarIgual(miMatrizA, miMatrizB)) {
            System.out.println("Las matrices dadas son diferentes");
        } else {
            System.out.println("Las matrices dadas son iguales");
        }
    }

    public static boolean comprobarIgual(int[][] matrizA, int[][] matrizB) {

        for (int fila = 0; fila < matrizA.length; fila++) {

            for (int colum = 0; colum < matrizA[0].length; colum++) {

                if (matrizA[fila][colum] != matrizB[fila][colum]) {
                    return false;
                }
            }
        }
        return true;
    }
}