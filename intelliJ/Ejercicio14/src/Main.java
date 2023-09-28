import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca un número");
        double num1 = sc.nextFloat();
        System.out.println("Introduzca un segundo número");
        double num2 = sc.nextFloat();
        System.out.println("Seleccione modo de calculadora; suma, resta, división o multiplicación");
        sc.nextLine();
        String modo = sc.nextLine();

        float fin = (float) switch (modo) {
            case "resta" -> num1 - num2;
            case "suma" -> num1 + num2;
            case "división" -> num1 / num2;
            default -> num1 * num2;
        };
        System.out.println("El resultado es: " + fin);
    }
}