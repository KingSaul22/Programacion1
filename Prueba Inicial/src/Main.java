import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Hola, ¿cómo te llamas?");
        String nombre = teclado.nextLine();
        System.out.println("Encantado de conocerte, " + nombre + ". ¿Desde qué ciudad vienes?");
        String ciudad = teclado.nextLine();
        System.out.println("Wow, " + ciudad + " es una ciudad muy bonita");
        System.out.println("Me gusta como suena, tanto " + nombre + " como " + ciudad + " son palabras agradables de oir.");
    }

}