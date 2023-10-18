package Ejer8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca el valor A.");
        int numA = sc.nextInt();
        System.out.println("Introduzca el valor B.");
        int numB = sc.nextInt();
        System.out.println("Introduzca el valor C.");
        int numC = sc.nextInt();
        sc.close();

        float ansA;
        float ansB;

        float numX = (float) (numB * numB) - (4 * numB * numC);

        if (numX >= 0) {
            numX = (float) Math.sqrt(numX);
            ansA = (-numB + numX) / (2 * numA);
            ansB = (-numB - numX) / (2 * numA);

            System.out.printf("El resultado de la ecuación con los datos introducidos es %f y %f", ansA, ansB);
        } else {
            System.out.println("El cálculo da números imaginarios.");
        }
    }
}
