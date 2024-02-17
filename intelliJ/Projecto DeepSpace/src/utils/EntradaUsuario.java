package utils;

import java.util.Scanner;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

public class EntradaUsuario {
    private static Scanner sc = new Scanner(System.in);

    public static int getEntero(String mensaje) {
        System.out.print(mensaje + ": ");

        int entero = 0;
        boolean ok = false;

        while (!ok) {
            try {
                entero = Integer.parseInt(sc.nextLine());
                ok = true;
            } catch (NumberFormatException e) {
                System.out.print("Error. Introduce un número entero: ");
            }
        }

        return entero;
    }

    public static int getEnteroMinMax(String mensaje, int min, int max) {
        int enteroIntroducido = EntradaUsuario.getEntero(mensaje);
        while (enteroIntroducido < min || enteroIntroducido > max) {
            System.out.println("Por favor, introduce un número entre " + min + " y " + max);
            enteroIntroducido = EntradaUsuario.getEntero("Selección");
        }

        return enteroIntroducido;
    }

    public static String getNombreLongitudMinMax(String mensaje, int caracterMinimo, int caracterMaximo) {
        System.out.print(mensaje + ": ");

        String cadena = null;
        boolean ok = false;

        while (!ok) {
            cadena = sc.nextLine().trim().toLowerCase();

            if (cadena.length() <= caracterMaximo && cadena.length() >= caracterMinimo && soloLetrasNumeros(cadena)) {
                ok = true;
            } else {
                if (cadena.length() < caracterMinimo) {
                    System.out.println("El nombre introducido tiene una longitud inferior a " + caracterMinimo + " caracteres");
                }
                if (cadena.length() > caracterMaximo) {
                    System.out.println("El nombre introducido tiene una longitud superior a " + caracterMaximo + " caracteres");
                }
                System.out.print("\nIntroduzca un nombre valido: ");
            }
        }

        return cadena.substring(0, 1).toUpperCase() + cadena.substring(1);
    }

    public static String getNombreLongMinMaxRecursiva(String mensaje, int caracterMinimo, int caracterMaximo) {
        System.out.print(mensaje + ": ");
        String cadena = sc.nextLine().trim();

        if (cadena.length() < caracterMinimo || cadena.length() > caracterMaximo || !soloLetrasNumeros(cadena)) {
            if (cadena.length() < caracterMinimo) {
                System.out.println("El nombre introducido tiene una longitud inferior a " + caracterMinimo + " caracteres");
            }
            if (cadena.length() > caracterMaximo) {
                System.out.println("El nombre introducido tiene una longitud superior a " + caracterMaximo + " caracteres");
            }
            System.out.println();
            cadena = getNombreLongMinMaxRecursiva(mensaje, caracterMinimo, caracterMaximo);
        }

        return cadena.substring(0, 1).toUpperCase() + cadena.substring(1);
    }

    private static boolean soloLetrasNumeros(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (!isLetter(cadena.charAt(i)) && !isDigit(cadena.charAt(i))) {
                System.out.println("La cadena proporcionada debe componerse exclusivamente por letras y números");
                return false;
            }
        }
        return true;
    }

    /*
    public static boolean reglasNombre(String name) {
        boolean reglasCumplidas = true;                    //Variable donde almacenamos si se rompe una regla
        char letterA = name.charAt(0);                  //Almacenamos la primera letra del nombre introducido
        char LetterB = name.toLowerCase().charAt(0);    //Al macenamos la primera letra en minusculas

        if (letterA == LetterB) {           //Si la primera letra es igual a ella misma en minuscula
            System.out.println("La primera letra está en minuscula.");  //Quiere decir que rompe una regla
            reglasCumplidas = false;
        }

        if (name.length() >= 11 || name.length() <= 4) {        //Se comprueba la longitud del nombre
            System.out.println("La longitud es incorrecta, los nombre deben incluir más de 4 carcteres y menos de 11.");
            reglasCumplidas = false;
        }

        letterA = name.charAt(name.length() - 1);   //Se almacena el último caracter del nombre
        LetterB = name.charAt(name.length() - 2);   //Se almacena el penúltimo caracter del nombre
        int numExiste = 0;              //En esta variable almacenaremos si el último o penúltimo caracter es un número
        char numA;
        for (int num = 0; num < 10; num++) {
            num += 48;              //Para almacenar el num en un char y realizar la comparación,
            numA = (char) num;      //necesitamos almacenar el equivalente en código ASCII
            if (letterA == numA) {          //Comparamos cada número con el último carcter,
                numExiste++;                //Si coinciden, se suma 1 a la variable numExiste
            }
            if (LetterB == numA) {          //Comparamos cada número con el penúltimo carcter,
                numExiste++;                //Si coinciden, se suma 1 a la variable numExiste
            }
            num -= 48;
        }
        if (numExiste != 2) {       //Si numExiste no ha llegado a 2 quiere decir que uno de los últimos caracteres no era un número
            System.out.println("Los dos últimos caracteres del nombre deben ser números.");
            reglasCumplidas = false;
        }

        return reglasCumplidas;  //Si se rompe una o más reglas se devuelve false
    }   //Devuelve True o False en función de si el nombre introducido cumple las reglas.
    */
}
