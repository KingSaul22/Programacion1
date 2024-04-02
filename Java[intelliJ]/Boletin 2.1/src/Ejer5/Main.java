package Ejer5;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        final int numRandom = 1001;

        System.out.println("¿Cuantos números desea introducir?");
        int numArray = sc.nextInt();
        sc.close();
        System.out.println();

        int[] miArray = new int[numArray];

        for (int elem = 0; elem <= miArray.length - 1; elem++) {
            miArray[elem] = r.nextInt(numRandom);
            System.out.println(miArray[elem]);
        }
    }

}