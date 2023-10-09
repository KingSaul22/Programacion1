import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numA = 1;
        int ans = 1;
        int numB, lvlN;

        do {
            System.out.println("Introduzca un número natural:");
            while (!sc.hasNextInt()) {
                System.out.println("Introduzca un número valido, por favor.");
                sc.next();
            }
            lvlN = sc.nextInt();
        } while (lvlN <= 0);

        for (int i = 2; i < lvlN; i++) {
            /*if (ans != 0) {
                numC = ans;
            }*/
            numB = ans;
            ans += numA;
            numA = numB;
        }
        System.out.printf("El valor correspondiente al %dº dígito de la sucesión de fibonacci es %d.", lvlN, ans);
    }
}