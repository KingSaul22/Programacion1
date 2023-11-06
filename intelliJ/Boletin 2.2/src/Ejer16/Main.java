package Ejer16;

public class Main {
    public static void main(String[] args) {
        int[][] miMatriz = {{1, 2}, {4, 6}, {8, 9}, {1, 3}, {6, 3}, {7, 9}};
        imprimirMatriz(miMatriz);

        int[][] posPares = casillasPares(miMatriz);
        imprimirMatriz(posPares);
    }

    public static int[][] casillasPares(int[][] matriz) {
        int[][] matrizPares = new int[matriz.length][matriz[0].length];
        int paresADY = 0;

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int colum = 0; colum < matriz[0].length; colum++) {

                for (int miniF = fila - 1; miniF < fila + 2; miniF++) {
                    for (int miniC = colum - 1; miniC < colum + 2; miniC++) {

                        if (miniF >= 0 && miniC >= 0 && miniF < matriz.length && miniC < matriz[0].length) {

                            if (matriz[miniF][miniC] % 2 == 0) {
                                paresADY++;
                            }

                        }
                    }
                }
                if (matriz[fila][colum] % 2 == 0) {
                    paresADY--;
                }

                matrizPares[fila][colum] = paresADY;
                paresADY = 0;
            }
        }

        return matrizPares;
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