package Ejer16;

public class Main {
    public static void main(String[] args) {
        int[][] miMatriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        imprimirMatriz(miMatriz);

        int[][] posPares = casillasPares(miMatriz);
        imprimirMatriz(posPares);
    }

    public static int[][] casillasPares(int[][] matriz) {
        int[][] matrizPares = new int[matriz.length][matriz[0].length];

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int colum = 0; colum < matriz[0].length; colum++) {
                if (matriz[fila][colum] % 2 == 0){

                }

                /*for (int miniF = 0; miniF < matriz.length; miniF++) {
                    for (int minC = 0; minC < matriz[0].length; minC++) {


                    }
                }*/
            }
        }

    }

    public static void imprimirMatriz(int[][] matriz) {
        System.out.print("\nLa salida es:\n");
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int colum = 0; colum < matriz[0].length; colum++) {

                System.out.printf(" %2d", matriz[fila][colum]);
            }
            System.out.println();
        }
    }
}