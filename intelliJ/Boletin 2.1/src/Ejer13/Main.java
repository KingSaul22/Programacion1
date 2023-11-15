package Ejer13;

import java.util.Scanner;

public class Main {

    public static int[] pila;
    public static int numElem = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ans;
        int numUsuario;

        pila = new int[10];
        System.out.println("Introduzca el primer número");
        pila[0] = sc.nextInt();
        sc.nextLine();

        do {
            System.out.println("\nIndique si quiere apilar un número o desapilar el último introducido('apilar' 'desapilar')");
            System.out.println("También puede introducir 'exit' para finalizar el programa.");
            ans = sc.nextLine();

            switch (ans){
                case "apilar":
                    if (numElem == 10){
                        System.out.println("La pila está completa, no puedes apilar más.");
                    } else {
                        System.out.println("\nIntroduzca el número a añadir");
                        numUsuario = sc.nextInt();
                        sc.nextLine();
                        apilado(numUsuario);
                    }
                    break;
                case "desapilar":
                    if (numElem == 0){
                        System.out.println("La pila está vacia, no puedes desapilar más.");
                    }else {
                        desapilado();
                    }
            }

            /*if (numElem < 10 && ans.equalsIgnoreCase("apilar")) {
                System.out.println("\nIntroduzca el número a añadir");
                numUsuario = sc.nextInt();
                sc.nextLine();
                apilado(numUsuario);

            } else if (numElem > 0 && ans.equalsIgnoreCase("desapilar")) {
                desapilado();

            } else if (numElem == 10 && ans.equalsIgnoreCase("apilar")) {
                System.out.println("La pila está completa, no puedes apilar más.");

            } else if (numElem == 0 && ans.equalsIgnoreCase("desapilar")) {
                System.out.println("La pila está vacia, no puedes desapilar más.");
            }*///Ambos métodos funcionan

        } while (!ans.equalsIgnoreCase("exit"));
        sc.close();

    }

    public static void desapilado() {
        System.out.println("El último elemento ha sido eliminado de la pila.");
        numElem--;

        if (numElem == 0) {
            System.out.println("No hay elementos en la pila.");
        } else {
            imprimirPila();
        }
    }

    public static void apilado(int num) {
        pila[numElem] = num;
        numElem++;

        imprimirPila();
    }

    public static void imprimirPila() {
        System.out.print("Pila -> [" + pila[0]);
        for (int elem = 1; elem < numElem; elem++) {
            System.out.print(", " + pila[elem]);
        }
        System.out.println("]");
    }
}
