package Ejer13;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ans;

        System.out.println("Comida favorita");
        String food = sc.nextLine();

        ans = switch (food) {
            case "Pizza" -> "¡Masa y queso!";
            case "Hamburguesa" -> "Cerveza";
            case "Tacos" -> "Picante";
            default -> "¡¡ERES UN MONSTRUOOO!!!!";
        };

        System.out.println(ans);
    }
}