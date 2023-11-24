package Ejer9b;

public class Main {
    public static void main(String[] args) {

        int[][] miMatrizA = {{1, 2, 3}, {2, -2, 2}, {2, -2, 2}, {1, 2, 3}};

        int[][] miMatrizB = invertirMatriz(miMatrizA);

        imprimirMatriz(miMatrizA);
        imprimirMatriz(miMatrizB);


        if (comprobarIgualX(miMatrizA, miMatrizB)) {
            System.out.println("La matriz dada no es simetrica.");
        } else {
            System.out.println("La matriz dada es simetrica.");
        }
    }

    public static int[][] invertirMatriz(int[][] matriz) {
        int[][] matrizInv = new int[matriz.length][matriz[0].length];

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int colum = 0; colum < matriz[0].length; colum++) {

                matrizInv[matrizInv.length - 1 - fila][colum] = matriz[fila][colum];
            }
        }

        return matrizInv;
    }

    public static boolean comprobarIgualX(int[][] matrizA, int[][] matrizB) {

        for (int fila = 0; fila < matrizA.length; fila++) {
            for (int colum = 0; colum < matrizA[0].length; colum++) {

                if (matrizA[fila][colum] != matrizB[fila][colum]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void imprimirMatriz(int[][] matriz) {
        System.out.println("\nLa salida es:");
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int colum = 0; colum < matriz[0].length; colum++) {

                System.out.print(" " + matriz[fila][colum]);
            }
            System.out.println();
        }
    }
}