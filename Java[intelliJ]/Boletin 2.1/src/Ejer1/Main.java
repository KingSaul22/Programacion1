package Ejer1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;

        System.out.println("¿Cuantos números desea introducir?");
        int numArray = sc.nextInt();

        int[] miArray = new int[numArray];
        for (int elem = 0; elem <= miArray.length - 1; elem++) {
            System.out.printf("\nIntroduzca un %dº número entero para colocar en la matriz\n", elem++);
            elem--;
            miArray[elem] = sc.nextInt();
            if (elem % 2 == 0) {
                ans += miArray[elem];
            }
        }
        sc.close();
        System.out.println("La suma de los elementos en posiciones pares de la matriz da como resultado: " + ans);
    }
}
