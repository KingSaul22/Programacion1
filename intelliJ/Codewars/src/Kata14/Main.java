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
        int[][] arrayTest = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(Arrays.toString(snail(arrayTest)));
    }

    public static int[] snail(int[][] array) {
        int[] snail = new int[array.length * array.length];
        boolean[][] auxSnail = new boolean[array.length][array.length];
        int contSnail = 0;

        //Si trazas lineas segun el orden, se crearán (n+n -1) lineas.
        int numIteraciones = 2 * array.length - 1;
        int auxiteracion = 0;

        int fila = 0, colum = 0;

        //System.arraycopy(array[0], 0, snail, 0, array.length);
        for (int i = 0; i < array.length; i++) {
            snail[i] = array[0][i];
            auxSnail[0][i] = true;
        }

        for (int i = 0; i < numIteraciones; i++) {
            switch (auxiteracion) {
                case 0:

                    do {
                        snail[contSnail] =array[fila][colum];

                        contSnail++;
                        colum++;
                    } while (colum < array.length && !auxSnail[fila][colum]);

                    colum--;
                    auxiteracion++;
                    break;
                case 1:

                    auxiteracion++;
                    break;
                case 2:


                    auxiteracion++;
                    break;
                case 3:

                    auxiteracion = 0;
            }
        }

        return snail;
    }
}
