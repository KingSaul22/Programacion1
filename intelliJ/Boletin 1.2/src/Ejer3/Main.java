package Ejer3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Introduzca la nota de su primer examen.");
        Scanner sc = new Scanner(System.in);
        double not1 = sc.nextDouble();

        System.out.println("Introduzca la segunda nota:");
        double not2 = sc.nextDouble();

        System.out.println("Introduzca la tercera nota:");
        double not3 = sc.nextDouble();

        float media = (float) ((not1+not2+not3)/3);
        System.out.println("Tú nota media es:\n" + media);
    }
}