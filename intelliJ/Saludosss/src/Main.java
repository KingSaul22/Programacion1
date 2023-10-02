import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduzca un nombre de usuario.");
        String user = sc.nextLine();
        System.out.println("Introduzca una contraseña valida.\nDebe tener un mínimo de 8 caracteres.");
        String pass = sc.nextLine();

        while (pass.length() < 8){
            System.out.println("Contraseña incorrecta.\nIntentelo de nuevo.");
            pass = sc.nextLine();
        }
        sc.close();
        saluda(user);
    }

    public static void saluda(String user){
        System.out.println("\nLa contraseña es correcta, cuenta inicializada.\n\nBienvenido, " + user + ".");
    }
}
