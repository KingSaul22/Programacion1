package Ejer6;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num1;
        int num2;
        int numC;
        int ans = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca un número.");
        while (!sc.hasNextInt()) {
            System.out.println("Introduzca un número entero, por favor.");
            sc.next();
        }
        num1 = sc.nextInt();

        System.out.println("Introduzca otro número.");
        while (!sc.hasNextInt()) {
            System.out.println("Introduzca un número entero, por favor.");
            sc.next();
        }
        num2 = sc.nextInt();
        sc.close();

        if (num1 > num2) {
            numC = num1;
            num1 = num2;
            num2 = numC;
        }
        if (num1 < 0) {
            num1 = num1 * -1;
            num2 = num2 * -1;
        }

        for (int i = 1; i <= num1; i++) {
            ans += num2;

        }
        System.out.println("El producto de los números introducidos es: " + ans);
    }
}