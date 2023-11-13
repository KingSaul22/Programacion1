import java.util.Scanner;

public class Main {
    public static int[][] tablero;
    public static int tamTabla;
    public static int pcMina;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indique la dificultad del juego.");
        String ans = sc.nextLine();
        generarTablero(ans);
    }

    public static void generarTablero(String dificultad) {
        switch (dificultad) {
            case "facil":
                tamTabla = 10;
                pcMina = (int) (tamTabla * 0.1);
                break;
            case "moderado":
                tamTabla = 16;
                pcMina = (int) (tamTabla * 0.15);
                break;
            case "dificil":
                tamTabla = 22;
                pcMina = (int) (tamTabla * 0.25);
                break;
            case "imposible":
                tamTabla = 26;
                pcMina = (int) (tamTabla * 0.35);
        }
        tablero = new int[tamTabla + 1][tamTabla + 1];

    }
}