import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduzca un nombre de usuario.");
        String user = sc.nextLine();
        System.out.println("Introduzca una contraseña valida.");
        System.out.println("Debe tener un mínimo de 8 caracteres");
        String pass = sc.nextLine();

        while (pass.length() < 8){
            System.out.println("Contraseña incorrecta, intentelo de nuevo");
            pass = sc.nextLine();
        }
        sc.close();
        saluda(user);
    }

    public static void saluda(String user){
        System.out.println("La contraseña es correcta, cuenta inicializada.");
        System.out.println("Bienvenido, " + user + ".");
    }
}