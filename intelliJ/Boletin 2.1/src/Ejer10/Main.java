package Ejer10;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final Random r = new Random();
    private static final int numRandom = 11;
    public static int tamArray;
    public static int[] miArray;
    public static int[] miArrayGood;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca el tamaño del array:");
        tamArray = sc.nextInt();

        miArray = new int[tamArray];
        insertarValor(miArray);
        Arrays.sort(miArray);

        miArrayGood = killDuplicados(miArray);
        System.out.println(Arrays.toString(miArray));
        System.out.println(Arrays.toString(miArrayGood));
    }

    private static void insertarValor(int[] arrayEnteros) {

        for (int elem = 0; elem <= arrayEnteros.length - 1; elem++) {

            arrayEnteros[elem] = r.nextInt(numRandom);
        }
    }

    private static int[] killDuplicados(int[] examinar) {
        int numDuplicados = examinar.length;
        for (int elem = 1; elem < examinar.length; elem++) {
            if (examinar[elem] == examinar[elem - 1]) {
                numDuplicados--;
            }
        }
        int[] arrayLimpio = new int[numDuplicados];
        int indiceLimp=1;
        arrayLimpio[0] = examinar[0];
        for (int elem = 1; elem < examinar.length; elem++) {
            if (examinar[elem] != examinar[elem-1]){
                arrayLimpio[indiceLimp] = examinar[elem];
                indiceLimp++;
            }
        }

        return arrayLimpio;
    }
}
