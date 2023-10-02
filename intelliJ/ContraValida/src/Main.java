import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Introduzca una contraseña valida.");
        System.out.println("Debe tener un mínimo de 8 caracteres");
        Scanner sc = new Scanner(System.in);
        String pass = sc.nextLine();

        while (pass.length() < 8){
            System.out.println("Contraseña incorrecta, intentelo de nuevo");
            pass = sc.nextLine();
        }
        sc.close();
        System.out.println("La contraseña es correcta.");
    }
}