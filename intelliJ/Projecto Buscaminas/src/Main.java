import java.util.Scanner;

public class Main {
    //public static int[][] tablero;
    public static Scanner sc = new Scanner(System.in);
    public static int tamTabla;
    public static int numMina;
    public static String[][] tablero;
    public static String[][] ubiMinas;
    public static int minaTocada = 0;

    public static void main(String[] args) {

        System.out.println("Indique la dificultad del juego.");
        String ans = sc.nextLine();
        modoJuego(ans);

        tablero = new String[tamTabla + 1][tamTabla + 1];
        ubiMinas = new String[tamTabla + 1][tamTabla + 1];

        rellenoBase(tablero);
        imprimirMatriz(tablero);
        System.out.println();

        rellenoBase(ubiMinas);
        generarMinas();
        imprimirMatriz(ubiMinas);

        int filaUser;
        int columUser;

        while (endGame() && minaTocada == 0) {
            System.out.println("Introduzca la fila deseada.");
            filaUser = sc.nextInt();
            System.out.println("Introduzca la columna deseada.");
            columUser = sc.nextInt();

            bombaTocada(filaUser, columUser);
            despejarCasilla(filaUser, columUser);
            imprimirMatriz(tablero);
        }
    }

    public static void imprimirMatriz(String[][] matriz) {

        for (int fila = 0; fila < matriz.length; fila++) {
            System.out.print("[");
            for (int colum = 0; colum < matriz[0].length - 1; colum++) {
                System.out.printf("%2s|", matriz[fila][colum]);
            }
            System.out.printf("%2s]\n", matriz[fila][matriz[0].length - 1]);

        }

    }       //Imprime una matriz dada.

    public static void modoJuego(String dificultad) {
        int pcMina = 0;

        switch (dificultad) {
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

        numMina = tamTabla * tamTabla * pcMina / 100;
        System.out.println("\nIniciando modo de juego " + dificultad + ".\nSe procederá a crear una tabla con un tamaño de " + tamTabla + "x" + tamTabla + ".\nUn " + pcMina + "% de sus casillas serán minas.\n");
    }       //Ajusta parametros según dificultad seleccionada

    public static void rellenoBase(String[][] matriz) {
        matriz[0][0] = "X";
        for (int i = 1; i < matriz.length; i++) {
            matriz[0][i] = String.valueOf(i);
            matriz[i][0] = String.valueOf(i);
        }
        for (int fila = 1; fila < matriz.length; fila++) {
            for (int colum = 1; colum < matriz[0].length; colum++) {

                matriz[fila][colum] = "██";
            }
        }
    }       //Ajustes iniciales al tablero.

    public static void generarMinas() {
        int filRand;
        int colRand;
        for (int i = 0; i < numMina; i++) {
            filRand = (int) ((Math.random() * (ubiMinas.length - 1)) + 1);
            colRand = (int) ((Math.random() * (ubiMinas.length - 1)) + 1);
            ubiMinas[filRand][colRand] = "MN";
        }
    }       //Se ubican las minas

    public static void bombaTocada(int fil, int col) {
        if (ubiMinas[fil][col].equals("MN")) {
            minaTocada++;
        }
    }

    public static void despejarCasilla(int fil, int col) {


    }

    public static boolean endGame() {
        int oculto = 0;
        for (int fila = 1; fila < tablero.length; fila++) {
            for (int colum = 1; colum < tablero[0].length - 1; colum++) {
                if (tablero[fila][colum].equals("██")) {
                    oculto++;
                }
            }
        }
        return oculto > 10;
    } //Comprueba si se ha despejado el tablero exitosamente.
    //Puede que no sea necesario teniendo en cuenta que despejarCasilla() comprueba si has tocado una mina o no

}