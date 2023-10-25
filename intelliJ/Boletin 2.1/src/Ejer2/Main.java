package Ejer2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        int numElem = 0;

        System.out.println("¿Cuantos números desea introducir?");
        int numArray = sc.nextInt();

        int[] miArray = new int[numArray];
        for (int elem = 0; elem <= miArray.length - 1; elem++) {
            elem++;
            System.out.printf("\nIntroduzca un %dº número entero para colocar en la matriz\n", elem);
            elem--;
            miArray[elem] = sc.nextInt();
            if (miArray[elem] <= -1) {
                ans += miArray[elem];
                numElem++;
            }
        }
        sc.close();

        switch (numElem) {
            case 0:
                System.out.println("\nNo hay ningún elemento negativo en el vector.");
                break;
            case 1:
                System.out.println("\nHay un elemento negativo en la matriz.");
                System.out.println("Su valor es: " + ans);
                break;
            default:
                System.out.println("\nHay un total de " + numElem + " elementos negativos en la matriz.");
                System.out.println("La suma de esos elementos negativos da como resultado: " + ans);
        }
    }
}