package Ejer8;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int i = 0;
        double ans = Double.MAX_VALUE;

        System.out.println("¿Cuantos números desea introducir?");
        do {
            System.out.println("Introduzca un número positivo");
            while (!sc.hasNextInt()) {
                System.out.println("El dato instroducido no es valido, pruebe de nuevo: ");
                sc.next();
            }
            num = sc.nextInt();
        } while (num <= 0);

        do {
            i++;
            System.out.printf("\nIntroduzca el %dº número", i);
            double numI = sc.nextDouble();
            if (numI < ans) {
                ans = numI;
            }
            num--;
        } while (num > 0);
        sc.close();

        System.out.println("El número más pequeño es: " + ans);
    }
}