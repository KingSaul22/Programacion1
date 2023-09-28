import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Cuál es tu nivel?");
        int lvlP = sc.nextInt();
        System.out.println("¿Cuántas misiones has completado?");
        int missP = sc.nextInt();

        if (lvlP > 10 && missP > 20) {
            System.out.println("Has desbloqueado las misiones especiales");
        } else {
            System.out.println("No cumples los requisitos");
        }
    }
}