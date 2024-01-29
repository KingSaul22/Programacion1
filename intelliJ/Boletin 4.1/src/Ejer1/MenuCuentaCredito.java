package Ejer1;

import java.util.Scanner;

public class MenuCuentaCredito {
    private static final Scanner sc = new Scanner(System.in);
    private static CuentaCredito CC01;

    public static void main(String[] args) {
        crearCuentaCredito();
        byte opcion;

        do {
            System.out.print("""
                    
                    Seleccione una acción:
                      1. Ingresar dinero
                      2. Sacar dinero
                      3. Mostrar saldo y crédito
                      4. Salir
                    Selección:\s
                    """
            );
            opcion = sc.nextByte();

            switch (opcion) {
                case 1:
                    System.out.print("\nIntroduzca la cantidad a ingresar:");

                    break;

                case 2:

                    break;

                case 3:

                    break;
            }

        } while(opcion != 4);
    }

    private static void crearCuentaCredito() {
        double saldo, credito;

        System.out.println("Introduzca el saldo inicial, puede dejarlo vacio:");
        try {
            CC01 = new CuentaCredito(100);
        } catch (CuentaCreditoException e) {
            System.out.println(e.getMessage());
        }
    }
}
