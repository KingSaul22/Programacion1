package utils;

import java.util.Scanner;

public class MiEntradaSalida {
    public static Scanner tc;

    static {
        tc = new Scanner(System.in);
    }

    public static int leerEnteroDeRango(String mensaje, int min, int max) {
        System.out.print(mensaje + ": ");

        int numLeido;
        do {
            numLeido = Integer.parseInt(tc.nextLine());
            if (numLeido < min || numLeido > max) {
                System.out.printf("Introduce un valor entre %d y %d, por favor: ", min, max);
            }
        } while (numLeido < min || numLeido > max);

        return numLeido;
    }

    public static int leerEntero(String mensaje) {
        System.out.println(mensaje + ": ");
        return Integer.parseInt(tc.nextLine());
    }

    public static int leerEnteroPositivo(String mensaje) {
        System.out.println(mensaje + ": ");

        int numLeido;
        do {
            numLeido = Integer.parseInt(tc.nextLine());
            if (numLeido <= 0) {
                System.out.println("Introduce un nuevo número positivo");
            }
        } while (numLeido <= 0);

        return numLeido;
    }


    public static double leerDoublePositivo(String mensaje) {
        System.out.println(mensaje + ": ");

        double numLeido;
        do {
            numLeido = Double.parseDouble(tc.nextLine());
            if (numLeido <= 0) {
                System.out.println("Introduce un nuevo número positivo");
            }
        } while (numLeido <= 0);

        return numLeido;
    }

    public static char leerSN(String mensaje) {
        System.out.println(mensaje + ": ");

        char sn;
        do {
            sn = tc.nextLine().toUpperCase().charAt(0);
        } while (sn != 'S' && sn != 'N');

        return sn;
    }

    public static String leerCadena(String mensaje) {
        System.out.println(mensaje + ":");
        String cadena = null;

        do {
            cadena = tc.nextLine();
        } while (cadena.isEmpty());

        return cadena;
    }

    public static boolean primo(int a) {
        boolean primo = true;

        for (int i = 2; i <= a / 2; ++i) {
            if (a % i == 0) {
                System.out.printf("El número %d es divisor de %d. ", i, a);
                primo = false;
                break;
            }
        }

        return primo;
    }
}