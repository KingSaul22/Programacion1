import java.util.Scanner;

public class ejemploErrores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora de suma y resta");
        System.out.println("Ingrese el primer número: ");
        int num1 = scanner.nextInt();

        System.out.println("Ingrese el segundo número: ");
        int num2 = scanner.nextInt();

        System.out.println("Ingrese la operación (suma o resta): ");
        scanner.nextLine();
        String operacion = scanner.nextLine();
        scanner.close();

        int resultado;

        if (operacion.equals("suma")) {
            resultado = num1 + num2;
            System.out.println("El resultado de la suma es: " + resultado);
        } else if (operacion.equals("resta")) {
            resultado = num1 - num2;
            System.out.println("El resultado de la resta es: " + resultado);
        } else {
            System.out.println("Operación no válida.");
        }

        //scanner.close();
    }
}