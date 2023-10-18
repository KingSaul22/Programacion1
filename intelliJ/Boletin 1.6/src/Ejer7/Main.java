package Ejer7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un primer número mayor a 0");
        int numA = sc.nextInt();
        System.out.println("Introduce un segundo número mayor a 0");
        int numB = sc.nextInt();
        sc.close();

        if (numA < numB) {
            int numC = numA;
            numA = numB;
            numB = numC;
        }

        while (numB != 0) {
            int temp = numA;
            numA = numB;
            numB = temp % numB;
        }

        System.out.printf("El Máximo Común Divisor de %d y %d es %d", numA, numB, numB);
    }

}
