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

        rellenoBase(tablero);

    }

    public static void imprimirMatriz(int[][] matriz) {

        for (int fila = 0; fila < matriz.length; fila++) {
            System.out.println(Arrays.toString(matriz[fila]));
        }

    }       //Imprime una matriz dada.

    public static void modoJuego(String dificultad) {
        int pcMina = 0;

        switch (dificultad) {   //TODO Simplificar el Switch y extraer lo que se pueda.
            case "facil":
                tamTabla = 10;
                pcMina = 10;
                break;
            case "moderado":
                tamTabla = 16;
                pcMina = 15;
                break;
            case "dificil":
                tamTabla = 22;
                pcMina = 25;
                break;
            case "imposible":
                tamTabla = 26;
                pcMina = 35;
                break;
            case "custom":
                System.out.println("Introduzca el tamaño del lado usado para el tablero cuadrado:");
                tamTabla = sc.nextInt();
                System.out.println("Introduzca el porcentaje de minas que se crearán:");
                pcMina = sc.nextInt();
        }

        numMina = (tamTabla ^ 2) * pcMina / 100;
        System.out.println("\nIniciando modo de juego " + dificultad + ".\nSe procederá a crear una tabla con un tamaño de " + tamTabla + "x" + tamTabla + ".\nUn " + pcMina + "% de sus casillas serán minas.\n");
    }       //Ajusta parametros según dificultad seleccionada

    public static void rellenoBase(int[][] matriz) {


    }
}