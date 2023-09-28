package Ejer13;

import java.util.Scanner;

public class Comida {
    public static void comida(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answ;

        System.out.println("Comida favorita");
        String food = sc.nextLine();

        switch (food) {
            case "Pizza":
                answ = "¡Masa y queso!";
                break;
            case "Hamburguesa":
                answ = "Cerveza";
                break;
            case "Tacos":
                answ = "Picante";
                break;
            default:
                answ = "¡¡ERES UN MONSTRUOOO!!!!";
        }

        System.out.println(answ);
    }
}
