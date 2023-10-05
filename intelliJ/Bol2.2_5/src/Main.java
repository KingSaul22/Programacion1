import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //int oro = 60;
        //int nivel = 2;
        double vida = 100;
        //String arma = "chocolate";

        System.out.println("Ingresa el daño recibido:");
        while (!sc.hasNextDouble()) {
            System.out.println("Introduzca un número valido, por favor.");
            sc.next();
        }
        double dmg = sc.nextInt();
        sc.close();

        System.out.println("La salud actual del jugador es de "+ (vida - dmg));
    }


}