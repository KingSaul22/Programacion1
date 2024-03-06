package Ejer6;

import Ejer6.Excepciones.CajaException;
import Ejer6.Model.Almacen;

import java.util.Scanner;

public class Main {
    private static final Scanner SC = new Scanner(System.in);
    private static final Almacen ALMACEN = new Almacen();

    public static void main(String[] args) {
        int opcion;
        do {
            imprimirMenu();
            opcion = seleccionarOpcion();
            System.out.println();

            switch (opcion) {
                case 1 -> abrirCaja();
                case 2 -> cerrarCaja();
                case 3 -> nuevoCliente();
                case 4 -> atenderCliente();
                default -> SC.close();
            }
        } while (opcion != 5);
        System.out.println("\n¡Gracias por usar el programa!");
    }

    private static void abrirCaja() {
        try {
            int caja = getEnteroRango(1, 20, "Introduzca el número de la caja");
            ALMACEN.abrirCaja(caja);
            System.out.println("La caja número " + caja + " ha sido abierta.");
        } catch (CajaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void cerrarCaja() {
        try {
            int caja = getEnteroRango(1, 20, "Introduzca el número de la caja");
            ALMACEN.cerrarCaja(caja);
            System.out.println("La caja número " + caja + " ha sido cerrada.");
        } catch (CajaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void nuevoCliente() {
        try {
            System.out.println(ALMACEN.aniadirCliente());
        } catch (CajaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void atenderCliente() {
        try {
            System.out.println(ALMACEN.atenderCliente(getEnteroRango(1, 20, "Introduzca el número de la caja")));
        } catch (CajaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getEnteroRango(int min, int max, String mensaje) {
        int numero = min - 1;
        do {
            System.out.println(mensaje);
            try {
                System.out.print("Selección: ");
                numero = Integer.parseInt(SC.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Solo números");
            }
        } while (numero < min || numero > max);

        return numero;
    }

    private static void imprimirMenu() {
        System.out.println("""
                                
                Seleccione una opción:
                  1. Abrir caja
                  2. Cerrar caja
                  3. Nuevo Cliente
                  4. Atender Cliente
                  5. Salir""");
    }

    private static int seleccionarOpcion() {
        int opcion = -1;
        do {
            System.out.print("Selección [1 - 5]: ");
            try {
                opcion = Integer.parseInt(SC.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduzca un número");
            }
        } while (opcion < 1 || opcion > 5);

        return opcion;
    }
}
