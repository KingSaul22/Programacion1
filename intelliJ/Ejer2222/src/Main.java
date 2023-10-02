import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        do {
            System.out.println("Introduzca un número entre 0 y 10");
            while (!sc.hasNextInt()) {
                System.out.println("El dato introducido no es valido.");
                sc.next();
            }
            num = sc.nextInt();
        } while (num < 0 || num > 10);

        sc.close();

        for (int i = 1; i <= 10; i++) {

            System.out.printf("%2d * %2d = %3d\n", i, num, num * i);
        }
    }
}
