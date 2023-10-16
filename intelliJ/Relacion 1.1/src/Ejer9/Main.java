package Ejer9;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double precioF;
        char tipo;

        do {
            System.out.println("Indica la clase del producto. (A, B, C)");
            tipo = sc.nextLine().charAt(0);
        } while (tipo != 'A' && tipo != 'B' && tipo != 'C');

        System.out.println("¿Cuál es el precio del producto?");
        double precio = sc.nextDouble();

        switch (tipo) {
            case 'A':
                precioF = precio * 0.93;
                System.out.println("Su producto tiene un 7% de descuento. \nEl precio final es: " + precioF);
                break;
            case 'C':
                precioF = precio * 0.88;
                System.out.println("Su producto tiene un 12% de descuento. \nEl precio final es: " + precioF);
                break;
            default:
                if (precio < 500) {
                    precioF = precio * 0.91;
                    System.out.println("Su producto tiene un 12% de descuento. \nEl precio final es: " + precioF);
                } else {
                    precioF = precio * 0.91;
                    System.out.println("Su producto tiene un 9% de descuento. \nEl precio final es: " + precioF);
                }
                break;

        }

        /* Tanto el switch como el if funciona

        if (tipo == 'A') {
            precioF = precio * 0.93;
            System.out.println("Su producto tiene un 7% de descuento. \nEl precio final es: " + precioF);
        } else if (tipo == 'C' || precio < 500) {
            precioF = precio * 0.88;
            System.out.println("Su producto tiene un 12% de descuento. \nEl precio final es: " + precioF);
        } else {
            precioF = precio * 0.91;
            System.out.println("Su producto tiene un 9% de descuento. \nEl precio final es: " + precioF);
        }
        */
    }

}
