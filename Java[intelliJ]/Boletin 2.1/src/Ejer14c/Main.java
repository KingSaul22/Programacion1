package Ejer14c;

import java.util.Scanner;

public class Main {
    public static final int TAM_COLA = 10;
    public static int[] cola = new int[TAM_COLA];
    public static int primerElemento = 0;
    public static int numElementos = 0;
    public static int inicio = 0;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        while (opcion != 4) {
            menu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduce un número");
                    int num = sc.nextInt();
                    encolar(num);
                }
                case 2 -> {
                    int numDesencolado = desencolar();
                    System.out.println("Has desencolado el número " + numDesencolado);
                }
                case 3 -> mostrarCola();
                case 4 -> System.out.println("Adiós");
                default -> System.out.println("Elige una opción válida");
            }
        }
    }

    public static void encolar(int num) {
        if (numElementos < TAM_COLA) {
            cola[(primerElemento + numElementos) % TAM_COLA] = num;
            numElementos++;
        } else {
            System.out.println("La cola está llena");
        }
    }

    public static int desencolar() {
        if (numElementos > 0) {
            int numDesencolado = cola[inicio];
            inicio = (inicio + 1) % TAM_COLA;
            numElementos--;
            primerElemento++;
            return numDesencolado;
        } else {
            System.out.println("No hay elementos en la cola");
            return -1;
        }
    }

    public static void mostrarCola() {
        int almacen = inicio;

        System.out.print("Cola --> [");
        for (int i = 0; i < numElementos; i++) {
            System.out.print(cola[inicio]);
            inicio = (inicio + 1) % TAM_COLA;
            if (i < numElementos - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        inicio = almacen;
    }

    public static void menu() {
        System.out.println("¿Qué deseas hacer?");
        System.out.println("1) Encolar");
        System.out.println("2) desencolar");
        System.out.println("3) Mostrar");
        System.out.println("4) salir");
    }

}