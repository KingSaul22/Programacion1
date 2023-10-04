import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int ans = 0;

        do {
            System.out.println("Introduzca un número positivo");
            while (!sc.hasNextInt()) {
                System.out.println("El dato instroducido no es valido, pruebe de nuevo: ");
                sc.next();
            }
            num = sc.nextInt();
        } while (num <= 0);

        sc.close();

        for (int i = 1; i <= num; i++) {
            ans += i;

        }
        System.out.printf("La suma de los primeros %d naturales es: %d", num, ans);
    }
}