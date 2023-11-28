import java.util.Scanner;


public class Main {

    /**
     * Scanner que recibe la entrada del teclado.
     */
    public static final Scanner sc = new Scanner(System.in);

    /**
     * Valor que se imprimirá para las casillas ocultas.
     */
    public static final char VALOR_OCULTO = '█';

    /**
     * Una matriz donde se almacena el 'tablero' con las distintas 'cartas'
     */
    private static char[][] barajaReal;

    /**
     * Una matriz booleana que indicara si una casilla de barajaReal[][] es visible o no.
     */
    private static boolean[][] casillaOculta;

    /**
     * Variable que determina si el juego se ha completado satisfactoriamente o no.
     */
    public static boolean victoria = true;

    /**
     * Se usará para determinar si se usa o on el modo PRO.
     */
    public static boolean modoPRO;

    /**
     * Tamaño del lado del tablero.
     */
    private static int tamBaraja;

    /**
     * Número de errores que puede cometer el usuario.
     */
    private static int numIntentos;


    /**
     * Linea principal de funcionamiento.
     * El juego consiste en encontrar las parejas de una baraja.
     * Se han preparado tres modos de dificultad que el usuario puede escoger.
     * Ademas, también existe la posibilidad de usar el modo PRO y obtener acceso a más parametros.
     */
    public static void main(String[] args) {

        System.out.println("Bienvenido a la prueba de Memoria Matricial.\nEl juego consiste en encontrar las parejas de cartas dentro de un tablero.\nSeleccione la dificultad:\n");
        System.out.println(" 1) Pruebame.\n 2) Normal.\n 3) Dificil.\n");

        modoJuego(getEnteroRango("Introduzca un número mayor que 0 y menor que ", 0, 3));   // Llamamos al método modoJuego() y le entregamos la dificultad seleccionada.


        if (modoPRO) {      // En el caso de que se haya desbloqueado el modo PRO, le damos a escoger distintos parametros.

            System.out.println("Modificar el tamaño del lado para la baraja.");     // Escoja el tamaño de la matriz.
            tamBaraja = getEnteroRango("Introduzca un número mayor que 4 y menor que ", 5, 100);
            int auxTamBaraja = tamBaraja;   // Necesitamos un auxiliar para que en el caso en que no sea módulo de 2.

            if (tamBaraja % 2 != 0) {   // Si se da el caso de que no es módulo de 2,
                auxTamBaraja++;         // añadimos uno a la variable que será usada para las columnas.
            }                           // Así nos aseguramos de que haya parejas completas.
            barajaReal = new char[tamBaraja][auxTamBaraja];
            casillaOculta = new boolean[tamBaraja][auxTamBaraja];


            System.out.println("\nLa composición de la baraja afecta que tipos de caracteres se incluirán.\nSeleccione un modo:");
            System.out.println(" 1) Basico.\n 2) Extendido.\n");
            // Preguntamos por el contenido de la baraja
            if (getEnteroRango("Introduzca un número mayor que 0 y menor que ", 1, 2) == 2) {
                crearBarajaPRO();       // Llamamos al metodo PRO en caso de haber seleccionado la opción Extendido.
            } else {
                crearBaraja();
            }

            System.out.println("\nIntroduzca el número de intentos.");  // Damos a elegir el número de intentos
            numIntentos = getEnteroRango("Introduzca un número mayor que 0 y menor que ", 1, Integer.MAX_VALUE - 1);

        } else {    // En caso de haber seleccionado una dificultad estandar.
            barajaReal = new char[tamBaraja][tamBaraja];        // Se inicializan las matrices en función de la dificultad seleccionada,
            casillaOculta = new boolean[tamBaraja][tamBaraja];  // pruebame, normal o dificil.
            crearBaraja();                  // Se genera la baraja.
        }

        imprimirMatriz();     // Usado para hacer tests.


        System.out.println("\n\nTenga en cuenta que el número de errores que puedes cometer es limitado.\nDispones de " + numIntentos + ".\n");
        int auxNumIntentos = numIntentos;       // Una 'caja' donde almaceno el valor inicial del número de intentos con el fin de usarlo en el mensaje final.

        int filaA, columA, filaB, columB;       // Variables que se utilizarán para almacenar las coordenadas que especifique el usuario.

        mostrarJuego();     // Mostramos el tablero.
        do {

            System.out.println("\nSeleccione la coordenada para la primera casilla.\n");
            do {
                System.out.println("Escoja fila.");
                filaA = getEnteroRango("Introduzca un número igual o mayor a 0 y menor que ", 0, tamBaraja - 1);

                System.out.println("Escoja columna.");
                columA = getEnteroRango("Introduzca un número igual o mayor a 0 y menor que ", 0, tamBaraja - 1);

            } while (casillaNoValida(filaA, columA));   // Recogemos las coordenadas A del usuario y comprobamos si la casilla es valida. En caso de no ser valido, se repite.

            casillaOculta[filaA][columA] = true;        // Descubrimos la casilla en cuestión
            mostrarJuego();                             // y la mostramos.


            System.out.println("\nSeleccione la coordenada para la segunda casilla.\n");
            do {
                System.out.println("Escoja fila.");
                filaB = getEnteroRango("Introduzca un número igual o mayor a 0 y menor que ", 0, tamBaraja - 1);

                System.out.println("Escoja columna.");
                columB = getEnteroRango("Introduzca un número igual o mayor a 0 y menor que ", 0, tamBaraja - 1);

            } while (casillaNoValida(filaB, columB));   // Repetimos el proceso para las coordenadas B.

            casillaOculta[filaB][columB] = true;
            mostrarJuego();


            if (barajaReal[filaA][columA] == barajaReal[filaB][columB]) {
                System.out.println("Has acertado, sigue así!\n");
            } else {                                // En caso de que las casillas NO sean iguales,
                System.out.println("No son iguales...\n");
                numIntentos--;                          // Se pierde un intento y

                casillaOculta[filaA][columA] = false;   // se ocultan las casillas
                casillaOculta[filaB][columB] = false;

                if (numIntentos != 0) {     // Le indicamos si le queda un intento o más.
                    System.out.printf("Has perdido un intento, te quedan %d.\nSigue intentandolo.\n", numIntentos);
                }

                mostrarJuego();
            }

        } while (!gameEnd());   // Se continua el bucle de juego hasta que el modulo gameEND() devuelva true.
        sc.close();

        if (victoria) {     // Si el módulo gameEnd() determina que se ha completado el juego satisfactoriamente, feicitamos al jugador
            System.out.printf("Tras cometer %d fallos...\nHas salido victorioso!, sabia que no me decepcionarias.\nFELICIDADES", (auxNumIntentos - numIntentos));

        } else {            // En caso contrario, nos entristecemos.
            System.out.println("\nMe has fallado...\nTe has quedado sin intentos...\nEres un fracasado...");
        }

    }


    /**
     * Ajusta parametros según la dificultad seleccionada.
     *
     * @param dificultad Grado de dificultad [0, 3].
     */
    private static void modoJuego(int dificultad) {
        String nameDific = null;    // Aquí guardaremos el nombre de la dificultad escogida.

        switch (dificultad) {       // Según lo escogido por el usuario, seleccionaremos unos valores para el juego.
            case 1:
                nameDific = "prueba";
                tamBaraja = 2;      // Se modifica el tamaño del tablero
                numIntentos = 3;    // y el número de intentos.
                break;
            case 2:
                nameDific = "normal";
                tamBaraja = 4;
                numIntentos = 5;
                break;
            case 3:
                nameDific = "dificil";
                tamBaraja = 6;
                numIntentos = 7;
                break;
            case 0:
                modoPRO = true;     // Si se introduce 0, se activa el modo PRO
        }

        if (!modoPRO) {
            System.out.println("\nIniciando modo de " + nameDific + ".\nLa baraja será formada por una matriz de tamaño " + tamBaraja + "x" + tamBaraja + ".\n");
        } else {
            System.out.println("Has inicializado el modo PRO, a continuación se le habilitarán opciones avanzadas.\n");
        }
    }


    /**
     * Coloca letras de manera desordenada en la baraja.
     */
    private static void crearBaraja() {
        char letra = 65;    // En el código ASCI, las letras inician en el valor 65. siendo este la 'A'.
        int a, b;           // Dos variables que indicarán la posición en la que colocar las letras.

        for (int casilla = 0; casilla < barajaReal.length * barajaReal[0].length; casilla++) { // Insertaremos letras en toda la matriz, de ahí que necesitemos un bucle que se repita N * N veces

            if (casilla == (barajaReal.length * barajaReal[0].length / 2)) {       // En el caso de que hayamos colocado la mitad de las letras,
                letra = 65;                                                     // necesitamos empezar de nuevo por la A. Ya se habrán colocado una lera de cada, necesitamos dos.
            }

            letra = switch (letra) {    // En el caso de haber usado todas las letras mayusculas,
                case 91 -> 97;          // se usarán las letras minusculas.
                case 123 ->
                        65;         // Para no usar simbolos o números, en caso de que el tablero sea muy grande, se repetirá el ciclo.
                default -> letra;       //
            };

            a = (int) (Math.random() * barajaReal.length);      // Buscamos una posicion aleatoria, de ahí que generemos dos valores aleatorios
            b = (int) (Math.random() * barajaReal[0].length);      // que indicarán la posicion donde se almacenará la letra.

            if (barajaReal[a][b] == 0) {    // En el caso de que la casilla esté vacia,   El valor 0 representa nulo y es como se inicia las variables char cuyo valor no hemos insertado, tambien se puede usar '\u0000'
                barajaReal[a][b] = letra;   // añadimos la letra a esa posición y
                letra++;                    // pasamos a la siguiente letra
            } else {
                casilla--;                  // Si está ocupada, restamos 1 a casilla para repetir el ciclo y buscar una vacia.
            }
        }

    }


    /**
     * Coloca letras Y SIMBOLOS de manera desordenada en la baraja.
     */
    private static void crearBarajaPRO() {
        char letra = 33;    // Iniciamos en el valor 33. siendo este '!'.
        int a, b;           // Dos variables que indicarán la posición en la que colocar las letras.

        for (int casilla = 0; casilla < barajaReal.length * barajaReal[0].length; casilla++) { // Insertaremos letras en toda la matriz, de ahí que necesitemos un bucle que se repita N * N veces

            if (casilla == (barajaReal.length * barajaReal[0].length / 2)) {       // En el caso de que hayamos colocado la mitad de las letras,
                letra = 33;                                                     // necesitamos empezar de nuevo por la A. Ya se habrán colocado una lera de cada, necesitamos dos.
            }

            letra = switch (letra) {
                case 48 -> 58;      // Nos saltamos los números ya que estos se usarán para imprimir las coordenadas.
                case 124 -> 125;    // También saltamos " | " ya que se usa en la impresión de la baraja.
                case 132 -> 33;     // Repetimos el ciclo si es necesario.
                default -> letra;
            };      // Para mantener una serie de caracteres, en caso de que se llegue a cierto simbolo de la tabla ASCII, se repetiran letras.

            a = (int) (Math.random() * barajaReal.length);      // Buscamos una posicion aleatoria, de ahí que generemos dos valores aleatorios
            b = (int) (Math.random() * barajaReal[0].length);      // que indicarán la posicion donde se almacenará la letra.

            if (barajaReal[a][b] == 0) {    // En el caso de que la casilla esté vacia,   El valor 0 representa nulo y es como se inicia las variables char cuyo valor no hemos insertado, tambien se puede usar '\u0000'
                barajaReal[a][b] = letra;   // añadimos la letra a esa posición y
                letra++;                    // pasamos a la siguiente letra
            } else {
                casilla--;                  // Si está ocupada, restamos 1 a casilla para repetir el ciclo y buscar una vacia.
            }
        }

    }


    /**
     * Comprueba si la casilla seleccionada por el usuario ya ha sido despejada anteriormente.
     *
     * @param fila  La coordenada y.
     * @param colum La coordenada x.
     * @return true si la casilla no es valida.
     */
    private static boolean casillaNoValida(int fila, int colum) {
        if (!casillaOculta[fila][colum]) {      // Si la posicion de casillaOculta[][] vale false,
            return false;                       // la casilla no está ocupada y se puede descubir.
        }
        System.out.println("\nLa casilla seleccionada ya está descubierta, pruebe de nuevo.\n");
        return true;
    }


    /**
     * Comprueba si el juego ha finalizado.
     * Se revisa si quedan intentos o si se han despejado todas las casillas.
     *
     * @return Se devuelve true si el juego ha acabado.
     */
    private static boolean gameEnd() {
        if (numIntentos == 0) {     // Si el usuario se ha quedado sin intentos,
            victoria = false;       // ha fracasado y
            return true;            // se finaliza el juego.
        }

        for (int fila = 0; fila < casillaOculta.length; fila++) {               // Se repasan que casillas son visibles.
            for (int colum = 0; colum < casillaOculta[0].length; colum++) {

                if (!casillaOculta[fila][colum]) {                              // En el caso de que haya alguna oculta
                    return false;                                               // se continua con el juego.
                }
            }
        }

        return true;        // Se finaliza el juego de manera satisfactoria en caso de que sobren intentos y todas las casillas estén descubiertas.
    }


    /**
     * Imprime la baraja revisando que casillas serán descubiertas.
     */
    private static void mostrarJuego() {
        System.out.println();

        System.out.print(" X |");
        for (int cabecera = 0; cabecera < barajaReal[0].length; cabecera++) {   // Imprimimos una 'cabecera' con las coordenadas
            System.out.printf("%2s |", cabecera);                               // para facilitar el uso del programa.
        }
        System.out.println();


        for (int fila = 0; fila < barajaReal.length; fila++) {      // Imprimiremos la baraja.
            System.out.printf("%2s |", fila);                       // Tendremos en mente, hacer una barra lateral con las coordenadas.

            for (int colum = 0; colum < barajaReal[0].length - 1; colum++) { // Nos saltamos el último elemento de cada fila.

                if (casillaOculta[fila][colum]) {                            // En el caso de que una posición de la matriz casillaOculta[][] sea true,
                    System.out.printf("%2s |", barajaReal[fila][colum]);     // la casilla de la baraja con esa misma posición será impresa.
                } else {
                    System.out.printf("%2s |", VALOR_OCULTO);                // En caso contrario, se imprime VALOR_OCULTO.
                }

            }
            if (casillaOculta[fila][casillaOculta[0].length - 1]) {         // Imprimimos el último elemento de la fila con la misma lógica del if-else anterior. Añadimos un salto de linea.
                System.out.printf("%2s |\n", barajaReal[fila][barajaReal[0].length - 1]);
            } else {
                System.out.printf("%2s |\n", VALOR_OCULTO);
            }
        }

        System.out.print(" ¯¯¯");
        for (int cerrar = 0; cerrar < barajaReal[0].length; cerrar++) { // Creamos una linea con puros fines esteticos.
            System.out.print("¯¯¯¯");
        }
        System.out.println();
    }


    /**
     * Devuelve un número dentro de un rango.
     *
     * @param mensaje Cadena que se enviará al usuario
     * @param min     El valor mínimo que se puede escoger.
     * @param max     El valor máximo que se puede escoger.
     * @return Un valor entero dentro de rango.
     */
    private static int getEnteroRango(String mensaje, int min, int max) {    //TODO: Conseguir que, en caso de introducirse un enter vacio, se escriba el mensaje de nuevo.
        int num;    // Variable que almacenará el número entregado por el usuario.

        do {
            System.out.printf(mensaje + (max + 1) + ": ");

            while (!sc.hasNextInt()) {   // En el caso de que el dato leido por el escaner no sea un entero,
                System.out.println("Introduzca un valor adecuado.");
                sc.next();              // se le pedirá que introduzca otro input.
            }
            num = sc.nextInt();         // Siendo un entero, se almacena en 'num'.

        } while (num < min || num > max);            // El ciclo se repetira mientras el valor no sea un número incluido en el rango.

        return num;
    }


    /*public static int getEnteroRango(String mensaje, int min, int max) {
        int num;
        String datoNum;     //Recogeremos el número en un String
        do {
            System.out.printf(mensaje + (max + 1) + ": ");
            datoNum = sc.nextLine();

            while (datoNum.isEmpty() || !soloDigitos(datoNum)) {     //Se repite si el input está vacio o no son exclusivamente números,
                System.out.print("No se ha podido recoger ningún dato válido, pruebe de nuevo: ");
                datoNum = sc.nextLine();                            //recogemos otro input.
            }

            num = Integer.parseInt(datoNum);        //Transformamos a entero el String.
        } while (num < min || num > max);  //En el caso de que no cumpla el rango, se repite.

        return num;
    } // Módulo que devuelve un número entero de un rango.


    public static boolean soloDigitos(String dato) {
        int comprobante = 0;    // Un contador al que le sumaremos los digitos que encontremos en el String.
        char comprobado;        // Aquí guardaremos el caracter que examinaremos.

        for (int numA = 0; numA < dato.length(); numA++) {  // Queremos repasar el String.
            comprobado = dato.charAt(numA);         // Almacenamos el caracter que vamos a examinar.

            for (int numB = 48; numB < 58; numB++) {     // Lo compararemos con los numeros [0, 9]
                                                         // Empezamos en el 48, ya que así figura en el código ASCII.
                if (comprobado == numB) {                // En el caso de que conincida con un número,
                    comprobante++;                       // añadimos uno al contador.
                }
            }
        }
                                                // Si comprobante es igual al número de caracteres, quiere decir que todos son números
        return comprobante == dato.length();    // y devuelve true.
    }   //Comprueba que el dato recogido en getEnteroRango() sean solo números. */   // Método alternativo que envia un mensaje cuando se da a enter sin escribir nada.


    /**
     * Imprime el tablero inicial con fines de testeo.
     */
    private static void imprimirMatriz() {
        System.out.println();

        for (int fila = 0; fila < barajaReal.length; fila++) {
            System.out.print("|");
            for (int colum = 0; colum < barajaReal[0].length - 1; colum++) {

                System.out.printf("%2s |", barajaReal[fila][colum]);
            }
            System.out.printf("%2s |\n", barajaReal[fila][barajaReal[0].length - 1]);

        }
    }

}