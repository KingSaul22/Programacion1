package Ejer1;

import static java.lang.Character.toLowerCase;

public class Caracter {
    public static void main(String[] args) {
        String caracteres = "Hola mundo";
        char caracter = 'o';

        System.out.printf("En la cadena '%s' hay %d ocurrencias  del caracter '%c'.", caracteres, contarCaracter(caracteres, caracter), caracter);
    }

    public static int contarCaracter(String cadena, char letra) {
        int ocurrencia = 0;

        cadena = cadena.toLowerCase();
        letra = toLowerCase(letra);

        for (int i = 0; i< cadena.length(); i++){
            if (cadena.charAt(i) == letra) {
                ocurrencia++;
            }
        }

        return ocurrencia;
    }
}
