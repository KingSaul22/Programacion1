package Kata14;

import java.util.Arrays;

/**
 * Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.
 * <p><p>
 * array =<p>
 * [[1,2,3],<p>
 * [4,5,6],<p>
 * [7,8,9]]<p>
 * snail(array) #=> [1,2,3,6,9,8,7,4,5]
 * <p><p>
 * For better understanding, please follow the numbers of the next array consecutively:
 * <p>
 * array =<p>
 * [[1,2,3],<p>
 * [8,9,4],<p>
 * [7,6,5]]<p>
 * snail(array) #=> [1,2,3,4,5,6,7,8,9]
 */
public class Main {
    public static void main(String[] args) {
        //int[][] arrayTest = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arrayTest = {{}};

        System.out.println(Arrays.toString(snail(arrayTest)));
    }

    public static int[] snail(int[][] array) {
        if (array.length == 1 && array[0].length == 0) return new int[]{};


        int[] snail = new int[array.length * array.length];
        boolean[][] auxSnail = new boolean[array.length][array.length];
        int contSnail = 0;
        int fila = 0, colum = 0;

        int numIteraciones = 2 * array.length - 1;
        int auxIteracion = 0;


        for (int i = 0; i < numIteraciones; i++) {

            switch (auxIteracion) {
                case 0:
                    do {
                        snail[contSnail] = array[fila][colum];
                        auxSnail[fila][colum] = true;

                        contSnail++;
                        colum++;
                    } while (colum < array.length && !auxSnail[fila][colum]);

                    colum--;
                    fila++;
                    auxIteracion++;
                    break;
                case 1:
                    do {
                        snail[contSnail] = array[fila][colum];
                        auxSnail[fila][colum] = true;

                        contSnail++;
                        fila++;
                    } while (fila < array.length && !auxSnail[fila][colum]);

                    fila--;
                    colum--;
                    auxIteracion++;
                    break;
                case 2:
                    do {
                        snail[contSnail] = array[fila][colum];
                        auxSnail[fila][colum] = true;

                        contSnail++;
                        colum--;
                    } while (colum >= 0 && !auxSnail[fila][colum]);

                    colum++;
                    fila--;
                    auxIteracion++;
                    break;
                case 3:
                    do {
                        snail[contSnail] = array[fila][colum];
                        auxSnail[fila][colum] = true;

                        contSnail++;
                        fila--;
                    } while (fila >= 0 && !auxSnail[fila][colum]);

                    fila++;
                    colum++;
                    auxIteracion = 0;
            }
        }

        return snail;
    }
}
