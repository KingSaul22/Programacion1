package Ejer11;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final Random r = new Random();
    private static final int numRandom = 101;
    public static int tamArray;
    //public static int[] miArrayA;
    //public static int[] miArrayB;
    public static int[] miArrayGood;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca el tamaño del array:");
        tamArray = sc.nextInt();

        int[] miArrayA = new int[tamArray];
        insertarValor(miArrayA);
        Arrays.sort(miArrayA);
        int[] miArrayLimpA = killDuplicados(miArrayA);

        int[] miArrayB = new int[tamArray];
        insertarValor(miArrayB);
        Arrays.sort(miArrayB);
        int[] miArrayLimpB = killDuplicados(miArrayB);

        System.out.println(Arrays.toString(miArrayLimpA));
        System.out.println(Arrays.toString(miArrayLimpB));

        miArrayGood = sumaArray(miArrayLimpA, miArrayLimpB);
        System.out.println(Arrays.toString(miArrayGood));
    }

    private static void insertarValor(int[] arrayEnteros) {

        for (int elem = 0; elem <= arrayEnteros.length - 1; elem++) {

            arrayEnteros[elem] = r.nextInt(numRandom);
        }
    }

    private static int[] sumaArray(int[] arrayA, int[] arrayB) {
        int numLimpio = 0;
        int indiceA = 0, indiceB = 0;

        do {
            if (arrayA[indiceA] == arrayB[indiceB]){
                numLimpio++;
                indiceA++;
                indiceB++;
            } else if (arrayA[indiceA] > arrayB[indiceB]) {
                indiceB++;
            } else {
                indiceA++;
            }

        } while(indiceA < arrayA.length && indiceB < arrayB.length);

        int[] arraySuma = new int[numLimpio];
        indiceA = 0;
        indiceB = 0;
        int indiceLimp = 0;
        do {
            if (arrayA[indiceA] == arrayB[indiceB]){
                arraySuma[indiceLimp]= arrayA[indiceA];
                indiceLimp++;
                indiceA++;
                indiceB++;
            } else if (arrayA[indiceA] > arrayB[indiceB]) {
                indiceB++;
            } else {
                indiceA++;
            }

        } while(indiceA < arrayA.length && indiceB < arrayB.length);



        return arraySuma;
    }

    private static int[] killDuplicados(int[] examinar) {
        int numDuplicados = examinar.length;
        for (int elem = 1; elem < examinar.length; elem++) {
            if (examinar[elem] == examinar[elem - 1]) {
                numDuplicados--;
            }
        }
        int[] arrayLimpio = new int[numDuplicados];
        int indiceLimp = 1;
        arrayLimpio[0] = examinar[0];
        for (int elem = 1; elem < examinar.length; elem++) {
            if (examinar[elem] != examinar[elem - 1]) {
                arrayLimpio[indiceLimp] = examinar[elem];
                indiceLimp++;
            }
        }

        return arrayLimpio;
    }
}