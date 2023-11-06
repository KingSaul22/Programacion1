package Ejer9;

public class Main {
    public static void main(String[] args) {

        int[][] miMatrizA = {{1, 2, 3}, {4, 5, 6}};

        int[][] miMatrizB = invertirMatriz(miMatrizA);

        imprimirMatriz(miMatrizA);
        imprimirMatriz(miMatrizB);
    }

    public static int[][] matrizSuma(int[][] matrizA, int[][] matrizB) {
        int[][] sumaMatriz= new int[matrizA.length][matrizA[0].length];

        for (int fila = 0; fila < matrizA.length; fila++) {
            for (int colum = 0; colum < matrizA[0].length; colum++) {

                sumaMatriz[fila][colum] = matrizA[fila][colum] + matrizB[fila][colum];
            }
        }

        return sumaMatriz;
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

    public static void imprimirMatriz(int[][] matriz) {
        System.out.print("\nLa salida es:");
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int colum = 0; colum < matriz[0].length; colum++) {

                System.out.print(" " + matriz[fila][colum]);
            }
            System.out.println();
        }
    }
}