import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numA, numB, numC;
        int i, j;

        System.out.println("Introduzca un primer número Natural");
        numA = sc.nextInt();
        System.out.println("Introduzca un segundo número Natural");
        numB = sc.nextInt();
        sc.close();

        if (numA > numB) {
            numC = numB;
            numB = numA;
            numA = numC;
        }

        /*for (int i = 2; i <= numB / 2; i++) {
            System.out.println(i);

        }*/

        do {

        } while (i <= numB / 2 || j  1)

    }
}