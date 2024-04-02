package Ejer15;

public class Main {
    public static void main(String[] args) {
        System.out.println("Indique la fila a revisar:");
        int posFila = 1;
        System.out.println("Indique la columna a revisar:");
        int posColum = 4;
        System.out.println();

        int[][] miMatriz = new int[4][5];
        int i = 1;
        for (int fila = 0; fila < miMatriz.length; fila++) {
            for (int colum = 0; colum < miMatriz[0].length; colum++) {
                miMatriz[fila][colum] = i;
                i++;
            }
        }
        imprimirMatriz(miMatriz);
        System.out.println();

        int posicion = numPosicion(miMatriz, posColum, posFila);

        System.out.println(posicion);
    }

    public static int numPosicion(int[][] matriz, int x, int y) {
        int posicion = 1;

        posicion += y * matriz[0].length;

        posicion += x;


        return posicion;
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
