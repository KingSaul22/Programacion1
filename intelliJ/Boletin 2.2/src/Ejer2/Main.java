package Ejer2;

public class Main {
    public static void main(String[] args) {
        int[][] miMatriz = {{1, 3, 4, -1}, {1, 4, 54, 0}};

        System.out.printf("La suma de los elementos de la matriz es: %d.", sumaMatriz(miMatriz));
    }

    public static int sumaMatriz(int[][] matriz) {
        int suma = 0;
        for (int fila = 0; fila < matriz.length; fila++) {

            for (int colum = 0; colum < matriz[0].length; colum++) {

                suma += matriz[fila][colum];
            }
        }
        return suma;
    }
}