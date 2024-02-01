package Ejer4;

import EntradaSalida.Lectora;

import static java.lang.Character.toUpperCase;

public class Main {
    public static void main(String[] args) {
        Mago a = null, b = null;
        Clerigo c = null;

        try {
            a = new Mago(selectNombre(), selectRaza(), 15, 20, 100);
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        try {
            b = new Mago("Rodolfo", selectRaza(), 12, 19, 76);
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        try {
            c = new Clerigo("Rodolfa", b.getRaza(), 20, 15, 70, "Pepe");
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        try {
            a.aprendeHechizo(selectNombre());
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        try {
            a.aprendeHechizo(selectNombre());
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        try {
            b.aprendeHechizo(selectNombre());
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(a);
        System.out.println(b);

        try {
            a.lanzaHechizo(selectNombre(), b);
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        try {
            b.lanzaHechizo(selectNombre(), a);
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        try {
            c.lanzaCuracion(b);
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        try {
            a.lanzaHechizo(selectNombre(), b);
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    private static String selectNombre() {
        String nombre = Lectora.solicitarCadenaMinus("Escriba el nombre deseado: ").trim();

        while (nombre.isBlank() || nombre.length() > 15) {
            nombre = Lectora.solicitarCadenaMinus("Escriba un nombre valido e inferior en longitud a 15 caracteres: ").trim();
        }

        return nombre.replaceFirst(String.valueOf(nombre.charAt(0)), String.valueOf(toUpperCase(nombre.charAt(0))));
    }

    private static TRaza selectRaza() {
        System.out.print("""
                                
                Introduzca la raza de su personaje:
                  1. Humano
                  2. Elfo
                  3. Enano
                  4. Orco
                """
        );

        return switch (Lectora.leerEnteroDeRango("Selección: ", 1 + TRaza.values().length, 0)) {
            case 1 -> TRaza.HUMANO;
            case 2 -> TRaza.ELFO;
            case 3 -> TRaza.ENANO;
            default -> TRaza.ORCO;
        };
    }

}
