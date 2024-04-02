package Ejer10;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int ans = 1;

        do {
            System.out.println("Introduzca un igual o mayor que cero.");
            while (!sc.hasNextInt()) {
                System.out.println("El dato instroducido no es valido, pruebe de nuevo: ");
                sc.next();
            }
            num = sc.nextInt();
        } while (num < 0);
        sc.close();

        if (num > 1) {
            for (int i = 2; i <= num; i++) {
                ans = ans * i;
            }
        }

        System.out.println("El factorial de " + num + " es igual a " + ans);
    }
}