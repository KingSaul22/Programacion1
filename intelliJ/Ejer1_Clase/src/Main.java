import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numA, numB, numC;
        int i = 2;
        int j = 0;

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
            if (numA % i == 0 && numB % i == 0) {
                System.out.printf("Los números %d y %d no son números primos, tienen común divisor %d.", numA, numB, i);
                j++;
            } else {
                i++;
            }
            //i++;
        } while (i <= (numB / 2) && 0 == j);

        if (j <= 0) {
            System.out.printf("Los números %d y %d son números primos.", numA, numB);
        }
    }
}