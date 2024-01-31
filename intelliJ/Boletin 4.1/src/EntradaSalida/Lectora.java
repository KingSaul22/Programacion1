package EntradaSalida;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringJoiner;

public class Lectora {

    public static Scanner sc = new Scanner(System.in);

    /**
     * Este metodo se encarga de pedir al usuario un double por teclado, controlando las excepciones.
     *
     * @param mensaje Pasamos mensaje por parametro, el cual será el que se le muestre al usuario.
     * @return
     */
    public static double leerDouble(String mensaje) {
        //Mostrámos el mensaje por pantalla.

        //Declarámos las variables necesarias.
        double leerDouble = 0;
        boolean ok = false;
        //Hacemos un do, para controlar que se repita mientras ok sea falso
        do {
            System.out.println(mensaje);
            try {
                //pedimos el número y ponemos ok como true, si no fuera un número nos saltaría la excepción
                leerDouble = Double.parseDouble(sc.nextLine());
                ok = true;
                //Capturamos la excepción y mostrámos el error
            } catch (NumberFormatException e) {
                System.out.println("Tienes que introducir un número.");
            }
        } while (!ok);

        return leerDouble;
    }

    public static int leerEnteroDeRango(String mensaje, int numMax, int nunMin) {
        int opcionIntroducido = 0;
        boolean enRango = false;
        while (!enRango) {
            try {
                System.out.println(mensaje);
                opcionIntroducido = Integer.parseInt(sc.nextLine());
                if (opcionIntroducido > nunMin && opcionIntroducido < numMax) {
                    enRango = true;
                } else {
                    System.out.println("Numero fuera del rango.");

                }
            } catch (NumberFormatException e) {
                System.out.println("Tienes que introducir un número.");
            }
        }
        return opcionIntroducido;
    }

    public static int leerEnteroPositivo(String mensaje) {
        int enteroPositivo = 0;
        boolean ok = false;
        while (!ok) {
            System.out.println(mensaje);
            try {
                enteroPositivo = Integer.parseInt(sc.nextLine());
                if (enteroPositivo >= 0) {
                    ok = true;
                } else {
                    System.out.println("El numero introducido es negativo, intentelo de nuevo. ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Tienes que introducir un número.");
            }
        }

        return enteroPositivo;
    }

    public static double leerDoublePositivo(String mensaje) {
        double enteroPositivo = 0;
        boolean ok = false;
        while (!ok) {
            System.out.println(mensaje);
            try {
                enteroPositivo = Double.parseDouble(sc.nextLine());
                if (enteroPositivo >= 0) {
                    ok = true;
                } else {
                    System.out.println("El numero introducido es negativo, intentelo de nuevo. ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Tienes que introducir un número.");
            }
        }

        return enteroPositivo;
    }

    public static char leerCaracter(String mensaje) {
        char cracterIntroducido = ' ';
        boolean ok = false;
        while (!ok) {
            System.out.println(mensaje);
            try {
                cracterIntroducido = sc.next().charAt(0);
                ok = true;

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Esta fuera de rango");
            }
        }
        return cracterIntroducido;
    }

    public static char leerCaracterSN(String mensaje) {
        char cracterIntroducido = ' ';
        boolean ok = false;
        while (!ok) {
            System.out.println(mensaje);
            try {
                cracterIntroducido = sc.next().toUpperCase(Locale.ROOT).charAt(0);
                if (cracterIntroducido == 'S' || cracterIntroducido == 'N') {
                    ok = true;
                } else {
                    System.out.println("El caracter introducido debe ser S o N");
                }

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Esta fuera de rango");
            }
        }
        return cracterIntroducido;
    }

    public static String solicitarCadenaMayus(String mensaje) {
        String cadena = "";
        boolean ok = true;

        while (ok) {
            System.out.println(mensaje);
            try {
                cadena = sc.nextLine().toUpperCase();
                if (cadena.length() > 0) {
                    // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
                    ok = false;
                }
            } catch (NoSuchElementException e) {
                System.out.println("No has introducido elementos");
            }
        }

        return cadena;
    }

    public static String solicitarCadenaMinus(String mensaje) {
        String cadena = "";
        boolean ok = true;

        while (ok) {
            System.out.println(mensaje);
            try {
                cadena = sc.nextLine().toLowerCase();
                if (cadena.length() > 0) {
                    // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
                    ok = false;
                }
            } catch (NoSuchElementException e) {
                System.out.println("No has introducido elementos");
            }
        }

        return cadena;
    }

    public static String leerOpciones(String mensaje, String[] opciones) {
        int opcionElegida = 0;

        do {
            for (int i = 0; i < opciones.length; i++) {
                System.out.printf("%d = %s \n", i + 1, opciones[i]);
            }
            System.out.println(mensaje);
            opcionElegida = Integer.parseInt(sc.nextLine());
        } while (opcionElegida <= 0 && opcionElegida > opciones.length);

        return opciones[opcionElegida - 1];
    }

}
