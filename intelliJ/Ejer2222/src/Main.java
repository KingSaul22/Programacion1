import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner();
        int num;

        do {
            System.out.println("Introduzca un número entre 0 y 10");

            num = Integer.parseInt(sc.nextLine());
        } while (num < 0 || num > 10);
        for (int i = 1; i <= 10; i++) {

            System.out.printf("%2d * %2d = %3d\n", num, i, num * i);
        }
    }
}