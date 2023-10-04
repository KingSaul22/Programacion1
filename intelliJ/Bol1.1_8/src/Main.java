import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        System.out.println("¿Cuantos números desea introducir?");

        do {
            System.out.println("Introduzca un número positivo");
            while (!sc.hasNextInt()) {
                System.out.println("El dato instroducido no es valido, pruebe de nuevo: ");
                sc.next();
            }
            num = sc.nextInt();
        } while (num <= 0);

        System.out.println(num);

        /*for (int i = 1; i <= 5; i++) {

            System.out.println("i = " + i);
        }*/
    }
}