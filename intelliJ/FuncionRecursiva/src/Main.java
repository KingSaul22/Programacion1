import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int num;

        do {
            System.out.println("Introduzca un igual o mayor que cero.");
            while (!sc.hasNextInt()) {
                System.out.println("El dato instroducido no es valido, pruebe de nuevo: ");
                sc.next();
            }
            num = sc.nextInt();
        } while (num < 0);

        sc.close();

        System.out.println("Su factorial es: " + factorial(num));
    }

    public static int factorial(int a) {
        if (a == 0 || a == 1) {
            return 1;
        }

        return a * factorial(a - 1);
    }
}