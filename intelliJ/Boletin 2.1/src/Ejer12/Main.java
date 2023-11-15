package Ejer12;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final Random r = new Random();
    private static final int numRandom = 101;
    public static int tamArray = 10;

    public static void main(String[] args) {
        int[] miArray = new int[tamArray];
        insertarValor(miArray);
        System.out.println(Arrays.toString(miArray));

        ordenBurbuja(miArray);
        System.out.println(Arrays.toString(miArray));
    }

    private static void insertarValor(int[] arrayEnteros) {

        for (int elem = 0; elem <= arrayEnteros.length - 1; elem++) {

            arrayEnteros[elem] = r.nextInt(numRandom);
        }
    }

    public static void ordenBurbuja(int[] arrayEnteros) {
        int cajon;
        for (int i = 0; i < arrayEnteros.length - 1; i++) { //TODO: Calcular si se puede sumar -2 en lugar de -1

            for (int elem = 1; elem < arrayEnteros.length - i; elem++) {

                if (arrayEnteros[elem] < arrayEnteros[elem - 1]) {
                    cajon = arrayEnteros[elem];
                    arrayEnteros[elem] = arrayEnteros[elem - 1];
                    arrayEnteros[elem - 1] = cajon;
                }
            }
        }
    }
}