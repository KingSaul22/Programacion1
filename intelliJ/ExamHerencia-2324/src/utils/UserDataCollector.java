package utils;

import java.util.Arrays;
import java.util.Scanner;

public class UserDataCollector {

    public static Scanner sc = new Scanner(System.in);
    
    /**
     * Muestra un mensaje por pantalla y solicita un entero. Repite la operación 
     * hasta que se introduce un número entero válido
     * @param mensaje El mensaje que se mostrará
     * @return el número introducido por el cliente
     */
    public static int getEntero(String mensaje) {
        System.out.print(mensaje + ": ");
        
        int entero = 0;
        boolean ok = false;
        
        while (!ok) {
            try {
                entero = Integer.parseInt(sc.nextLine());
                ok = true;
            }
            catch (NumberFormatException e) {
                System.out.print("Error. Introduce un número entero: ");
            }
        }
        
        return entero;
    }
    
    /**
     * Muestra un mensaje por pantalla y solicita un entero comprendido entre min y max.
     * Repite la operación hasta que se introduce un número entero comprendido entre min y max.
     * @param mensaje El mensaje que se mostrará
     * @param min El mínimo entero aceptado
     * @param max El máximo entero aceptado
     * @return el número introducido por el cliente
     */
    public static int getEnteroMinMax(String mensaje, int min, int max) {
        int enteroIntroducido = UserDataCollector.getEntero(mensaje); 
        while (enteroIntroducido < min || enteroIntroducido > max) {
            System.out.println("Por favor, introduce un número entre " + min + " y " + max);
            enteroIntroducido = UserDataCollector.getEntero(mensaje);
        }
        
        return enteroIntroducido;
    }
    
    /**
     * Muestra un mensaje por pantalla y solicita una cadena.
     * Repite la operación hasta que se introduce una cadena válida.
     * @param mensaje El mensaje que se mostrará
     * @return La cadena introducida por el usuario
     */
    public static String getString(String mensaje) {
        String cadena = null;
        
        while (cadena == null || cadena.isBlank()) {
            System.out.print(mensaje + ": ");
            cadena = sc.nextLine();
        }
        
        return cadena;
    }
    
    /**
     * Muestra un mensaje por pantalla y solicita una cadena que debe
     * estar comprendida entre una serie de opciones válidas
     * Repite la operación hasta que se introduce una cadena válida.
     * @param mensaje El mensaje que se mostrará
     * @param opciones Las opciones aceptadas
     * @return La cadena introducida por el usuario
     */
    public static String getStringDeOpciones(String mensaje, String[] opciones) {
        boolean ok = false;
        String opcionElegida = null;
        
        while (!ok) {
            System.out.println(Arrays.toString(opciones));
            opcionElegida = UserDataCollector.getString(mensaje);
            
            for (int i = 0; i < opciones.length && !ok; i++) {
                if (opcionElegida.equalsIgnoreCase(opciones[i])) {
                    ok = true;
                }
            }
        
        }
        
        return opcionElegida;
    }
    
    /**
     * Método que muestra un mensaje y simplemente espera que el usuario pulse enter
     * @param mensaje El mensaje que se mostrará
     */
    public static void getTecla(String mensaje) {
        System.out.print(mensaje);
        sc.nextLine();
    }

}