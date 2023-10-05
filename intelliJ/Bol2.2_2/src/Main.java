import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double gC;

        System.out.println("Introduzca una temperatura en grados Celsius");
        gC = sc.nextDouble();

        //double gF = (gC * 9 / 5) + 32;
        //System.out.println("Grados Celsius: " + gC + "\nGrados Fahrenheir: " + gF);


        System.out.println("Grados Celsius: " + gC + "\nGrados Fahrenheir: " + ((gC * 9 / 5) + 32));
    }
}