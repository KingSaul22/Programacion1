package Ejer3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Maquina a = new Maquina();

        int opcionEscogida;
        Scanner sc = new Scanner(System.in);

        do {
            mostrarMenu();
            opcionEscogida = sc.nextInt();

            switch (opcionEscogida){
                case 1:
                    if (a.getVasosRestante() > 0 && a.getCafeRestante() > 0){

                    } else {
                        System.out.println("Producto agotado");
                    }
                    break;

                case 2:
                    if (a.getVasosRestante() > 0 && a.getLecheRestante() > 0){

                    } else {
                        System.out.println("Producto agotado");
                    }
                    break;

                case 3:
                    if (a.getVasosRestante() > 0 && a.getCafeRestante() > 0 && a.getLecheRestante() > 0){

                    } else {
                        System.out.println("Producto agotado");
                    }
                    break;

                case 4:
                    System.out.println(a);
                    break;

                default:
                    System.out.println("Tenga un buen día, agente.");
            }

        } while (opcionEscogida != 5);

    }

    public static void mostrarMenu() {
        System.out.println("\nBienvenido a la máquina de café, escoja una opción:");
        System.out.println(" 1. Servir café solo. (" + Maquina.PRECIO_CAFE + "€)");
        System.out.println(" 2. Servir leche. (" + Maquina.PRECIO_LECHE + "€)");
        System.out.println(" 3. Servir café con leche. (" + Maquina.PRECIO_CAFE_LECHE + "€)");
        System.out.println(" 4. Consultar estado de la máquina.");
        System.out.println(" 5. Salir.\n");
    }
}
