package Ejer1;

import java.util.Scanner;

public class MenuCuentaCredito {
    private static CuentaCredito CC01;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        CuentaCredito cuenta = crearCuentaCredito();
        byte opcion;
        double dinero;

        do {
            imprimirMenu();
            opcion = sc.nextByte();

            switch (opcion) {
                case 1:
                    System.out.print("\nIntroduzca la cantidad a ingresar: ");
                    dinero = sc.nextDouble();

                    try {
                        cuenta.ingresarDinero(dinero);
                    } catch (CuentaException | CuentaCreditoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("\nIntroduzca la cantidad a sacar: ");
                    dinero = sc.nextDouble();

                    try {
                        cuenta.sacarDinero(dinero);
                    } catch (CuentaException | CuentaCreditoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println(cuenta);
                    break;
            }

        } while (opcion != 4);
        sc.close();
    }

    private static void imprimirMenu() {
        System.out.print("""
                                    
                Seleccione una acción:
                  1. Ingresar dinero
                  2. Sacar dinero
                  3. Mostrar saldo y crédito
                  4. Salir
                Selección:\s"""
        );

    }

    private static CuentaCredito crearCuentaCredito() {
        CuentaCredito cuenta = new CuentaCredito();
        double saldo, credito;

        System.out.println("Introduzca el saldo inicial, puede dejarlo vacio:");
        try {
            CC01 = new CuentaCredito(100);
        } catch (CuentaCreditoException e) {
            System.out.println(e.getMessage());
        }

        return cuenta;
    }
}
