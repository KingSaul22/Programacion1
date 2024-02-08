public class Main {
    public static void main(String[] args) {
        if (setColorFuente("#123456")) {
            System.out.println("Funciona");
        } else {
            System.out.println("No funciona");
        }
    }

    public static boolean setColorFuente(String colorFuente) {
        return colorFuente.matches("#%06X");
    }
}