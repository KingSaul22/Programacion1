package Ejer1;

import java.util.Scanner;

public class MenuCuentaCredito {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        byte opcion;

        do {
            System.out.println("""
                    
                    Seleccione una acción:
                      1. Ingresar dinero.
                      2. Sacar dinero.
                      3. Mostrar saldo y crédito.
                      4. Salir.
                    """
            );
            opcion = sc.nextByte();

            switch (opcion) {
                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;
            }

        } while(opcion != 4);
    }
}
