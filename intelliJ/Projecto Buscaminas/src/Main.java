import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static long crono;
    public static int tamTabla;
    public static int numMina;
    public static String[][] tablero;
    public static String[][] ubiMinas;
    public static boolean minaTocada = false;

    public static void main(String[] args) {

        System.out.println("Indique la dificultad del juego.");
        //String ans = sc.nextLine();
        modoJuego(sc.nextLine());

        tablero = new String[tamTabla + 1][tamTabla + 1];
        ubiMinas = new String[tamTabla + 1][tamTabla + 1];

        rellenoBase(tablero);
        imprimirMatriz(tablero);
        System.out.println();

        rellenoBase(ubiMinas);
        generarMinas();
        imprimirMatriz(ubiMinas);

        int filaUser;       //Creo dos variables que almacenarán la fila
        int columUser;      //y columna que el usuario quierre dedspejar.

        cronometro("iniciar");

        while (endGame() && !minaTocada) {
            System.out.print("\nIntroduzca la fila deseada: ");
            filaUser = sc.nextInt();
            System.out.print("\nIntroduzca la columna deseada: ");
            columUser = sc.nextInt();
            System.out.println();

            if (!bombaTocada(filaUser, columUser)) {

                if (tablero[filaUser][columUser].equals("░░")) {
                    System.out.println("Esa casilla ya está descubierta, pruebe otra.");

                } else {
                    despejarCasilla(filaUser, columUser);
                    imprimirMatriz(tablero);
                }
            } else {
                minaTocada = true;
                System.out.println("La casilla seleccionada contenia una mina.");
                tablero[filaUser][columUser] = "XX";
                imprimirMatriz(tablero);
            }
        }
        cronometro("pausar");
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

            if (ubiMinas[filRand][colRand].equals("MN")) {
                i--;
            } else {
                ubiMinas[filRand][colRand] = "MN";
            }
        }
    }       //Se ubican las minas

    public static boolean bombaTocada(int fil, int col) {
        return ubiMinas[fil][col].equals("MN");
    }

    public static void despejarCasilla(int fil, int col) {

        if (ubiMinas[fil][col].equals("██")) {
            comprobarAlrededor(fil, col);
        }
    }

    public static void comprobarAlrededor(int fila, int colum) {

        tablero[fila][colum] = "░░";

    }

    public static boolean endGame() {
        int oculto = 0;
        for (int fila = 1; fila < tablero.length; fila++) {
            for (int colum = 1; colum < tablero[0].length; colum++) {
                if (tablero[fila][colum].equals("██")) {
                    oculto++;
                }
            }
        }

        return oculto > numMina;
    } //Comprueba si se ha despejado el tablero exitosamente.
    //Puede que no sea necesario teniendo en cuenta que despejarCasilla() comprueba si has tocado una mina o no

    public static void cronometro(String funcion){

        switch (funcion){
            case "imprimir":

                break;
            case "iniciar":
                crono = System.currentTimeMillis();
                break;
            case "pausar":
                crono = System.currentTimeMillis() - crono;
        }
    }

}