package Ejer1;

public class Main {
    public static void main(String[] args) {
        int[][] miMatriz = {{1, 3, 4, -1}, {1, 4, 54, 0}};

        if (tieneNegativo(miMatriz)) {
            System.out.println("Eseta matriz tiene algún valor negativo.");
        } else {
            System.out.println("No tiene nigún valor negativo.");
        }
    }

    public static boolean tieneNegativo(int[][] matriz) {
        for (int fila = 0; fila < matriz.length; fila++) {

            for (int colum = 0; colum < matriz[0].length; colum++) {

                if (matriz[fila][colum] < 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
