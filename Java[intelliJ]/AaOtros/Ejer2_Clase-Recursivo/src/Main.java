import java.util.Scanner;


public class Main {
    //static int lvlN;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lvlN;

        do {

            System.out.println("Introduzca un número natural:");
            while (!sc.hasNextInt()) {
                System.out.println("Introduzca un número valido, por favor.");
                sc.next();
            }
            lvlN = sc.nextInt();
        } while (lvlN <= 0);
        sc.close();

        System.out.printf("El valor correspondiente al %dº dígito de la sucesión de fibonacci es %d.", lvlN, fibonacci(lvlN));
    }

    public static int fibonacci(int a) {

        if (a == 1 || a == 2) {
            return 1;
        }
        return fibonacci(a - 2) + fibonacci(a - 1);
    }


}