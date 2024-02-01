package Ejer3;

public class Main {
    public static void main(String[] args) {
        Mago a, b;
        Clerigo c;

        try {
            a = new Mago("Carlos Juan", TRaza.ORCO, 15, 20, 100);
        } catch (PersonajeException e) {
            throw new RuntimeException(e);
        }

        try {
            b = new Mago("Rodolfo", TRaza.ENANO, 12, 19, 76);
        } catch (PersonajeException e) {
            throw new RuntimeException(e);
        }

        try {
            c = new Clerigo("Rodolfa", TRaza.ENANO, 20, 15, 70, "Pepe");
        } catch (PersonajeException e) {
            throw new RuntimeException(e);
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    private static String selectNombre() {

    }

    private static String selectRaza() {

    }
    

}
