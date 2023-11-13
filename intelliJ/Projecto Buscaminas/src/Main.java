import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //public static int[][] tablero;
    public static Scanner sc = new Scanner(System.in);
    public static int tamTabla;
    public static int numMina;

    public static void main(String[] args) {

        System.out.println("Indique la dificultad del juego.");
        String ans = sc.nextLine();
        modoJuego(ans);

        int[][] tablero = new int[tamTabla + 1][tamTabla + 1];
        imprimirMatriz(tablero);

    }

    public static void imprimirMatriz(int[][] matriz) {

        for (int fila = 0; fila < matriz.length; fila++) {
            System.out.println(Arrays.toString(matriz[fila]));
        }

    }       //Imprime una matriz dada.

    public static void modoJuego(String dificultad) {

        switch (dificultad) {   //TODO Simplificar el Switch y extraer lo que se pueda.
            case "facil":
                //System.out.println("\nEl modo de juego seleccionado es 'Facil'.\nSe procederá a crear una tabla con un tamaño de 10x10.\nUn 10% de sus casillas serán minas.\n");
                tamTabla = 10;
                numMina = 10;
                break;
            case "moderado":
                //System.out.println("\nEl modo de juego seleccionado es 'Moderado'.\nSe procederá a crear una tabla con un tamaño de 16x16.\nUn 15% de sus casillas serán minas.\n");
                tamTabla = 16;
                numMina = (int) ((tamTabla ^ 2) * 0.15);
                break;
            case "dificil":
                //System.out.println("\nEl modo de juego seleccionado es 'Dificil'.\nSe procederá a crear una tabla con un tamaño de 22x22.\nUn 25% de sus casillas serán minas.\n");
                tamTabla = 22;
                numMina = (int) ((tamTabla ^ 2) * 0.25);
                break;
            case "imposible":
                //System.out.println("\nEl modo de juego seleccionado es 'Imposible'.\nSe procederá a crear una tabla con un tamaño de 26x26.\nUn 35% de sus casillas serán minas.\n");
                tamTabla = 26;
                numMina = (int) ((tamTabla ^ 2) * 0.35);
                break;
            case "custom":
                System.out.println("Introduzca el tamaño del lado usado para el tablero cuadrado:");
                tamTabla = sc.nextInt();
                System.out.println("Introduzca el porcentaje de minas que se crearán:");
                double pcMina = sc.nextDouble() / 100;
                numMina = (int) ((tamTabla ^ 2) * pcMina);
                //System.out.println("\nIniciando modo de juego customizado.\nSe procederá a crear una tabla con un tamaño de " + tamTabla + "x" + tamTabla + ".\nUn " + (int) (pcMina * 100) + "% de sus casillas serán minas.\n");
        }

        System.out.println("\nIniciando modo de juego " + dificultad + ".\nSe procederá a crear una tabla con un tamaño de " + tamTabla + "x" + tamTabla + ".\nUn " + (int) (pcMina * 100) + "% de sus casillas serán minas.\n");
    }

    public static void rellenoBase(int[][] matriz) {


    }
}