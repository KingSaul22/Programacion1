package Ejer12;

import java.util.Scanner;

import static java.lang.Character.isLetter;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String correo;

        do {
            correo = sc.nextLine();

            if (correoIsValid(correo)) {
                System.out.println("Su correo es valido.");

            } else {
                System.out.println("Correo no valido.");
            }

            System.out.println("¿Desea intentar otra dirección? \n(s / n)");
        } while (sc.nextLine().equals("s"));
        sc.close();
    }

    private static boolean correoIsValid(String correo) {
        boolean validez = true;

        if (!isLetter(correo.charAt(0))) {
            validez = false;
            System.out.println("El usuario no cumple con el formato adecuado:");
            System.out.println("  · Estar formado por, al menos, un caracter.\n" +
                    "  . Comenzar por una letra.\n" +
                    "  · Solo puede formarse por letras, números y el caracter punto."
            );
            /*System.out.println("""
                    El usuario no cumple con el formato adecuado:
                      · Estar formado por, al menos, un caracter.
                      . Comenzar por una letra.
                      · Solo puede formarse por letras, números y el caracter punto.\
                    """
            );*/

        } else {
            String usuario = correo.split("@", 2)[0];

            if (usuario.matches(".*" + "[a-zA-Z0-9.]" + ".*")) {
                System.out.println("""
                        El usuario no cumple con el formato adecuado:
                          · Estar formado por, al menos, un caracter.
                          . Comenzar por una letra.
                          · Solo puede formarse por letras, números y el caracter punto.\
                        """
                );

                validez = false;
            }
        }


        String[] divideArroba = correo.split("@", 2);

        if ()

            return validez;
    }


}
