import java.util.Scanner;

public class MiEntradaSalida {
    private static Scanner scanner = new Scanner(System.in);

    public static char leerChar(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.next().charAt(0);
    }

    public static int leerEnteroEnRango(int inicio, int fin){
        int num;
        do {
            System.out.print("Introduce un número entre " + inicio + " y " + fin + ": ");
            num = scanner.nextInt();
        } while (num < inicio || num > fin);
        return num;
    }
}
