package Ejer15;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca el primer lado");
        float x = sc.nextFloat();
        System.out.println("Introduzca el segundo lado");
        float y = sc.nextFloat();
        System.out.println("Introduzca el tercer lado");
        float z = sc.nextFloat();

        if (x == y && y == z) {
            System.out.println("Es un triangulo equilatero");
        } else if (x == y || y == z || x == z) {
            System.out.println("Es un triangulo isósceles");
        } else {
            System.out.println("Es un triangulo escaleno");
        }

        /*String ans = switch (x,y,z) {
            case x==y || y==z:
                yield "Es un triangulo equilatero";
            case
        }*/
    }
}