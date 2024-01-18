package Ejer12;

import java.util.Scanner;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String correo;

        do {
            System.out.println("Introduzca el correo electronico.");
            correo = sc.nextLine();

            if (correoIsValid(correo)) {
                System.out.println("Su correo es valido.");

            } else {
                System.out.println("Correo no valido.");
            }

            System.out.println("¿Desea intentar otra dirección? \n(s / n)");
        } while (sc.nextLine().equalsIgnoreCase("s"));
        sc.close();
    }

    private static boolean correoIsValid(String correo) {
        if (!correo.contains("@")) {
            System.out.println("Formato de correo no detectado.");
            return false;
        } //Detecta si hay una arroba.
        boolean validez = true;

        //Validará la parte usuario.
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

            //if (usuario.matches(".*" + "[a-zA-Z0-9.]" + ".*")) {
            char character;
            for (int i = 1; i < usuario.length(); i++) {
                character = usuario.charAt(i);

                if (!isDigit(character) && !isLetter(character) && character != '.') {
                    validez = false;

                    System.out.println("""
                            El usuario no cumple con el formato adecuado:
                              · Estar formado por, al menos, un caracter.
                              . Comenzar por una letra.
                              · Solo puede formarse por letras, números y el caracter punto.\
                            """
                    );

                    break;
                }
            }
        }

        //Guarada lo siguiente al arroba, organización + fin.
        String organizacionFin = correo.split("@", 2)[1].replaceFirst("@", "");

        if (!organizacionFin.contains(".")) {
            System.out.println("No se detecta la parte final del correo, (falta un punto).");
            return false;
        } //Detecta si existe la parte fin.

        if (!isLetter(organizacionFin.charAt(0))) {
            validez = false;

            System.out.println("""
                    La organización no cumple con el formato adecuado:
                      · Estar formado por, al menos, un caracter.
                      . Comenzar por una letra.
                      · Solo puede formarse por letras y números.\
                    """);


            //} else if (organizacionFin.split("\\.", 3).length > 2) {
        } else if (organizacionFin.indexOf(".") != organizacionFin.lastIndexOf(".")) {
            validez = false;
            System.out.println("Se han detectado caracteres invalidos.");

        } else {
            String organizacion = organizacionFin.split("\\.", 2)[0];

            for (int i = 1; i < organizacion.length(); i++) {

                if (!isDigit(organizacion.charAt(i)) && !isLetter(organizacion.charAt(i))) {
                    System.out.println("""
                            La organización no cumple con el formato adecuado:
                              · Estar formado por, al menos, un caracter.
                              . Comenzar por una letra.
                              · Solo puede formarse por letras y números.\
                            """);
                    break;
                }
            } //Valida la parte 'organización'

            //String fin = organizacionFin.split("\\.", 2)[1].replaceFirst(".", "");
            String fin = organizacionFin.split("\\.", 2)[1];

            if (fin.length() > 3 || fin.length() < 2) {
                validez = false;

                System.out.println("""
                        La terminación del correo no cumple con el correcto formato:
                          · Estar formado explusivamente por letras.
                          · Tener una longitud de 2 o 3 caracteres.
                        """);

            } else {
                for (int i = 0; i < fin.length(); i++) {

                    if (!isLetter(fin.charAt(i))) {
                        validez = false;

                        System.out.println("""
                                La terminación del correo no cumple con el correcto formato:
                                  · Estar formado explusivamente por letras.
                                  · Tener una longitud de 2 o 3 caracteres.
                                """);

                        break;
                    }
                }
            }
        }


        return validez;
    }


}
