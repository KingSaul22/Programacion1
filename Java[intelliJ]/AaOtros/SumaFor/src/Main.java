import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
        int t = 0;

        for (int i = 1; i <= 10; i++) {
            t += i;
        }
        System.out.println("La suma de los primeros diez números es: " + t); */

        System.out.println("Introduce un número entero");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        int d = 2;
        while (i % d != 0) {
            d++;
        }
        if (i == d) {
            System.out.println(d + " es un número primo.");
        } else {
            System.out.println("El primer divisor es: " + d);
        }
    }
}