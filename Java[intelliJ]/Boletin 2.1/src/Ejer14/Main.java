package Ejer14;

import java.util.Scanner;

public class Main {

    public static int[] cola;
    public static int numElem = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ans;
        int numUsuario;

        cola = new int[10];
        System.out.println("Introduzca el primer número");
        cola[0] = sc.nextInt();
        sc.nextLine();

        do {
            System.out.println("\nIndique si quiere encolar un número o desencolar el primero introducido('encolar' 'desencolar')");
            System.out.println("También puede introducir 'exit' para finalizar el programa.");
            ans = sc.nextLine();

            if (numElem < 10 && ans.equalsIgnoreCase("encolar")) {
                System.out.println("\nIntroduzca el número a añadir");
                numUsuario = sc.nextInt();
                sc.nextLine();
                encolado(numUsuario);

            } else if (numElem > 0 && ans.equalsIgnoreCase("desencolar")) {
                desencolado();

            } else if (numElem == 10 && ans.equalsIgnoreCase("encolar")) {
                System.out.println("La cola está completa, no puedes encolar más.");

            } else if (numElem == 0 && ans.equalsIgnoreCase("desencolar")) {
                System.out.println("La cola está vacia, no puedes desencolar más.");
            }
        } while (!ans.equalsIgnoreCase("exit"));
        sc.close();

    }

    public static void desencolado() {
        System.out.println("El primer elemento ha sido eliminado de la cola.");
        numElem--;

        if (numElem == 0) {
            System.out.println("No hay elementos en la cola.");
        } else {

            for (int elem = 0; elem < numElem; elem++) {
                cola[elem] = cola[elem + 1];
            }

            System.out.print("Cola -> [" + cola[0]);
            for (int elem = 1; elem < numElem; elem++) {
                System.out.print(", " + cola[elem]);
            }
            System.out.println("]");
        }
    }

    public static void encolado(int num) {
        cola[numElem] = num;
        numElem++;

        System.out.print("Cola -> [" + cola[0]);
        for (int elem = 1; elem < numElem; elem++) {
            System.out.print(", " + cola[elem]);
        }
        System.out.println("]");
    }
}