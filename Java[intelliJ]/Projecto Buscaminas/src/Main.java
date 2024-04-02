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

        System.out.println("Bienvenido al Buscaminas.\nIndique la dificultad del juego.");
        System.out.println(" 1) Facil.\n 2) Moderado.\n 3) Dificil.\n 4) Imposisble.\n 5) Custom.\n");
        //String ans = sc.nextLine();
        modoJuego(getEnteroRango(1, 5));

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
            System.out.print("Introduzca la columna deseada: ");
            columUser = sc.nextInt();
            System.out.println();

            if (!bombaTocada(filaUser, columUser)) {

                if (tablero[filaUser][columUser].equals("░░")) {
                    System.out.println("Esa casilla ya está descubierta, pruebe otra.");

                } else {
                    despejarCasilla(filaUser, columUser);
                    cronometro("imprimir");
                    imprimirMatriz(tablero);
                }
            } else {
                minaTocada = true;
                System.out.println("La casilla seleccionada contenia una mina.");
                tablero[filaUser][columUser] = "XX";
                cronometro("imprimir");
                imprimirMatriz(tablero);
            }
        }
        cronometro("pausar");
    }

    public static void imprimirMatriz(String[][] matriz) {
        //cronometro("imprimir");

        for (int fila = 0; fila < matriz.length; fila++) {
            System.out.print("[");
            for (int colum = 0; colum < matriz[0].length - 1; colum++) {
                System.out.printf("%2s|", matriz[fila][colum]);
            }
            System.out.printf("%2s]\n", matriz[fila][matriz[0].length - 1]);

        }

    }       //Imprime una matriz dada.

    public static void modoJuego(int dificultad) {
        int pcMina = 0;
        String nameDific = null;

        switch (dificultad) {
            case 1:
                nameDific = "facil";
                tamTabla = 10;
                pcMina = 10;
                break;
            case 2:
                nameDific = "moderado";
                tamTabla = 16;
                pcMina = 15;
                break;
            case 3:
                nameDific = "dificil";
                tamTabla = 22;
                pcMina = 25;
                break;
            case 4:
                nameDific = "imposible";
                tamTabla = 26;
                pcMina = 35;
                break;
            case 5:
                nameDific = "custom";
                System.out.println("Introduzca el tamaño del lado usado para el tablero cuadrado:");
                tamTabla = getEnteroRango(2, 99);
                System.out.println("Introduzca el porcentaje de minas que se crearán:");
                pcMina = getEnteroRango(1, 90);
        }

        numMina = tamTabla * tamTabla * pcMina / 100;
        System.out.println("\nIniciando modo de juego " + nameDific + ".\nSe procederá a crear una tabla con un tamaño de " + tamTabla + "x" + tamTabla + ".\nUn " + pcMina + "% de sus casillas serán minas.\n");
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

    public static void cronometro(String funcion) {

        switch (funcion) {
            case "imprimir":
                long caja = System.currentTimeMillis() - crono;
                long hor = caja / 3600000;
                caja -= hor * 3600000;
                long min = caja / 60000;
                caja -= min * 60000;
                long seg = caja / 1000;
                caja -= seg * 1000;

                System.out.print("Tiempo transcurrido: ");
                System.out.print(hor + ":");
                System.out.print(min + ":");
                System.out.print(seg + ".");
                System.out.println(caja);

                break;
            case "iniciar":
                crono = System.currentTimeMillis();
                break;
            case "pausar":
                crono = System.currentTimeMillis() - crono;
        }
    }

    public static int getEnteroRango(int min, int max) {
        int num;
        String datoNum;     //Recogeremos le número en un String
        do {
            System.out.printf("Introduzca un número entre (incluidos) %d y  %d: ", min, max);
            datoNum = sc.nextLine();

            while (datoNum.isEmpty() || soloDigitos(datoNum)) {     //Si el input está vacio o no son exclusivamente números
                System.out.print("No se ha podido recoger ningún dato válido, pruebe de nuevo: ");
                datoNum = sc.nextLine();                            //Recogemos otro input
            }

            num = Integer.parseInt(datoNum);        //Transformamos a entero el String
        } while (num < min || num > max);  //En el caso de que no cumpla con el mínimo, se repite.

        return num;
    } // Módulo que devuelve un número entero mayor a 'min'.

    public static boolean soloDigitos(String dato) {
        int comprobante = 0;
        char comprobado;
        for (int numA = 0; numA < dato.length(); numA++) {
            comprobado = dato.charAt(numA);

            for (int numB = 0; numB < 10; numB++) {
                numB += 48;
                if (comprobado == numB) {
                    comprobante++;
                }
                numB -= 48;
            }
        }

        return comprobante != dato.length();
    }   //Comprueba que el dato recogido en getEnteroMayorQue() sean solo números.
}