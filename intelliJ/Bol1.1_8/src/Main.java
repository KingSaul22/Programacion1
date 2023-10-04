import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        float ans = 0;

        System.out.println("¿Cuantos números desea introducir?");

        do {
            System.out.println("Introduzca un número positivo");
            while (!sc.hasNextInt()) {
                System.out.println("El dato instroducido no es valido, pruebe de nuevo: ");
                sc.next();
            }
            num = sc.nextInt();
        } while (num <= 0);

        for (int i = 1; i <= num; i++) {
            System.out.println("Introduzca un número");
            float numI = Float.parseFloat(sc.next());
            if (numI < ans){
                ans = numI;
            }
        }
        System.out.println("El menos número es: " + ans);
    }
}