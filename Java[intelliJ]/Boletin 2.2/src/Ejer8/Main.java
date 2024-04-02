package Ejer8;

public class Main {
    public static void main(String[] args) {

        int[][] miMatrizA = {{1, 2, 3}, {4, 5, 6}};
        int[][] miMatrizB = {{1, 2, 3}, {4, 5, 6}};

        int[][] miMatrizAB = matrizSuma(miMatrizA,miMatrizB);

        imprimirMatriz(miMatrizAB);
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

    public static void imprimirMatriz(int[][] matriz) {
        System.out.println("\nLa salida es:");
        for (int fila = 0; fila < matriz.length; fila++) {
            System.out.printf("[%2d", matriz[fila][0]);
            for (int colum = 1; colum < matriz[0].length; colum++) {

                System.out.printf(", %2d", matriz[fila][colum]);
            }
            System.out.println("]");
        }
    }
}