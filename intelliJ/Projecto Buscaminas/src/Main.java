import java.util.Scanner;

public class Main {
    public static int[][] tablero;
    public static int tamTabla = 65;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indique la dificultad del juego.");

        String ans = sc.nextLine();


        generarTablero(ans);
    }

    public static void generarTablero(String dificultad) {
        switch (dificultad){
            case "facil":
                tamTabla = 10;
                break;
            case "moderado":
                tamTabla = 16;
                break;
            case "dificil":
                tamTabla = 22;
                break;
            case "imposible":
                tamTabla = 26;
        }
        tablero = new int[tamTabla][tamTabla];

    }
}