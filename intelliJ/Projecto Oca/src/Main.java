import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static int numJugadores = 4;
    public static int dadoIgual = 0;
    public static int i = -1;
    public static int carasDado = 6;
    public static int[] misJugadores;
    public static String[] nombreJugadores;

    public static void main(String[] args) {
        System.out.println("Bienvenido al juego de la Oca.\nAntes de simular la partida puede editar algunos valores si lo desea.\n\n");

        char ans;   //Una variable para almacenar la respuesta del usuario
        {
            System.out.println("NUMERO DE JUGADORES\n\nPor defecto, el juego cuenta con 4 jugadores (Amarillo, Verde, Rojo y Naranja) pero puedes cambiar el número de jugadores y sus nombres se lo deseas.");
            ans = getRespuestaSN(); //Llamamos al módulo que solo devolverá 's' o 'n'

            if (ans == 's') {       //Si la persona quiere modificar el número de jugadores y sus nombres:
                numJugadores = getEnteroMayorQue(2);    //El número de jugadores cambiará de 4 al deseado por la persona
                misJugadores = new int[numJugadores];       //El array misJugadores tendrá un tamaño especificado por el usuario
                misJugadores[0] = 1;                        //A la posición 0, le damos el valor 1, esto nos será util a la hora de seleccionar el orden
                //for (int elem = 1; elem < numJugadores; elem++) { //Al resto de posiciones le damos valor 0
                //    misJugadores[elem] = 0;
                //}

                System.out.println(" los nombres deben cumplir una serie de aspectos:\n ·La longitud máxima es de 10 caracteres y la mínima de 4.\n ·La primera letra debe ser mayuscula.\n ·Siempre debe acabar con dos números.");
                nombreJugadores = new String[numJugadores];                     //El array nombreJugadores tendrá un tamaño especificado por el usuario
                for (int elem = 0; elem < nombreJugadores.length; elem++) {     //Repasaremos el Array donde almacenaremos los nombres de los jugadores
                    nombreJugadores[elem] = getNombre();                        //En cada posición almacenamos un nombre que es proporcionado por el módulo getNombre()
                    if (reglasNombre(nombreJugadores[elem])) {                  //En el caso de que el nombre no cumpla las reglas,
                        elem--;                                                 //restamos 1 al indice para que el for repase de nuevo la posición.
                        System.out.println("El nombre no cumple todas las condiciones, pruebe de nuevo.");
                    }
                }
                System.out.println("Nombres recogidos y almacenados.\n");

            } else {        //En el caso de que el usuario no quiera cambiar el número y nombre de los jugadores,
                misJugadores = new int[numJugadores];

                //nombreJugadores = new String{"Amarillo", "Verde", "Rojo", "Naranja"};
                nombreJugadores = new String[numJugadores];
                nombreJugadores[0] = "Amarillo";
                nombreJugadores[1] = "Verde";
                nombreJugadores[2] = "Rojo";
                nombreJugadores[3] = "Naranja";

                System.out.println("Se usaran los nombres por defecto: Amarillo, Verde, Rojo y Naranja.\n");
            }
        }       //Se pregunta a la persona el número de jugadores y sus nombres

        {
            System.out.println("TIPO DE DADO\n\nPor defecto, el dado usado tiene 6 caras pero puedes cambiarlo si lo deseas.");
            ans = getRespuestaSN();
            if (ans == 's') {
                carasDado = getEnteroMayorQue(2);
            }
            System.out.printf("\nLa partida se desarrollará usando un dado de %d caras.\n\n", carasDado);
        }       //Se pregunta a la persona si desea cambiar de dado
        sc.close();

        int almacen = 0;

        int[] primeraTirada = dadoAleatorio();                       // Se guarda la primera tirada para calcular el orden de salida

        for (int elem = 1; elem < primeraTirada.length; elem++) {       //Se repasa

            if (primeraTirada[almacen] < primeraTirada[elem]) {

                misJugadores[almacen] = 0;
                misJugadores[elem] = 1;
                almacen = elem;
            }
        }         // Se revisará quién tiene el número más alto

        for (int elem = almacen + 1; elem < primeraTirada.length; elem++) {
            if (primeraTirada[almacen] == primeraTirada[elem]) {
                misJugadores[elem] = 1;
            }
        }   //Todos los jugadores que tengan la misma tirada máxima, también tendrán un 1 guardado en misJugadores[]

        while (repetirTirada()) {

            for (int elem = 0; elem < misJugadores.length; elem++) {

                if (misJugadores[elem] == 1) {          // Si un jugadore esta empatado tendrá un '1'
                    primeraTirada[elem] = miDado();     // Se le tira otro dado
                } else {
                    primeraTirada[elem] = 0;            // Si ya ha sido descartado para ocupar la posición de salida, se cambia el valor de su tirada a 0 para facilitar calculos posteriores.
                }
            }

            for (int elem = almacen + 1; elem < primeraTirada.length; elem++) {
                //En almacen está guardado el indice del primer jugador empatado
                if (primeraTirada[almacen] > primeraTirada[elem]) {             //En caso de que el jugador A haya conseguido un número mayor que el jugador B en la tirada de desempate
                    misJugadores[elem] = 0;                                     //Se coloca al jugador B en la casilla 0
                } else if (primeraTirada[almacen] < primeraTirada[elem]) {      //En caso contrario se le da al jugador A el 0
                    misJugadores[almacen] = 0;                                  //Ademas de meter en almacen el nuevo primer jugador para comparar con el siguien del Array si existe
                    almacen = elem;
                }
            }
        }   // Se hace un desempate si es necesario

        {
            System.out.println("Empieza el jugador " + nombreJugadores[almacen]);
            System.out.println("\nEl orden será el siguiente:");
            ordenarJugadores();
            ordenJugadores();
        }       //Se recalcula e imprime por pantalla el orden de los jugadores


        do {
            i++;                                    // El while ciclara cada turno, de ahí que necesite sumar un 1 al indice del Array misJugadores y nombreJugadores
            if (i == numJugadores) {                // Al sumar 1 cada vez, si queremos que empiece a leer desde la posición 0 debo declarar que i es igual a -1
                i = 0;                              // En el caso de que el índice sea igual que numJugadores, se empezará de nuevo el Array cambiando su valor a cero
            }

            almacen = miDado();                     // Reusamos la variable para ahorrar crear una nueva y llamamos al módulo miDado
            misJugadores[i] += almacen;             // Le sumamos a la posición el resultado del dado
            System.out.printf("\nEl jugador %s ha sacado un %d y pasa a la casilla %d\n", nombreJugadores[i], almacen, misJugadores[i]);

            while (misJugadores[i] % 4 == 0 && misJugadores[i] < 64) {     // Siempre que caiga en una casilla multiplo de 4 y no haya alcanzado la meta
                System.out.println("El jugador a caido en la casilla de la Oca, recibe tirada extra");
                almacen = miDado();                                         // El jugador recibe una tirada extra
                misJugadores[i] += almacen;
                System.out.printf("El jugador %s ha sacado un %d y pasa a la casilla %d\n", nombreJugadores[i], almacen, misJugadores[i]);
            }

            if (misJugadores[i] == 63) {    //En el caso de que caiga en la casilla calavera
                misJugadores[i] = 1;        //El jugador es enviado a la casilla de salida
                System.out.printf("El jugador %s ha caido en la casilla calavera.\nEmpieza desde el inicio.", nombreJugadores[i]);
            }
        } while (jugadorMeta());   //Simulador de la partida


        System.out.printf("\n\nEl ganador es el jugador %s.", nombreJugadores[i]);

        //sc.nextLine();
        //sc.close();
    }

    public static int getEnteroMayorQue(int min) {
        int num;
        do {
            System.out.printf("Introduzca un número mayor que %d: ", min - 1);
            while (!sc.hasNextInt()) {
                System.out.println("El dato introducido no es reconocido como un número entero.\nPruebe de nuevo:");
                sc.next();
            }
            num = sc.nextInt();
        } while (num < min);
        sc.nextLine();
        return num;
    } // Módulo que devuelve un número entero mayor a 'min'.

    public static char getRespuestaSN() {
        //char respuesta;
        String respTotal;
        do {
            System.out.print("Responda con 's' o 'n': ");
            respTotal = sc.next();
            if (respTotal.equalsIgnoreCase("s") && respTotal.equalsIgnoreCase("n")) {
                System.out.println("El carácter introducido no es 's' ni 'n'.");
            }
        } while (!respTotal.equalsIgnoreCase("s") && !respTotal.equalsIgnoreCase("n"));
        sc.nextLine();

        //respuesta = respTotal.toLowerCase().charAt(0);
        //return respuesta;
        return respTotal.toLowerCase().charAt(0);
    }   //Comprueba que la respuesta sea 's' o 'n'.

    public static String getNombre() {
        //String respuesta;
        //do{
            System.out.println("\nIntroduzca un nombre: ");
            //respuesta = sc.next();
        //} while (respuesta == null);
        //System.out.println("fuera");
        return sc.nextLine();
    }   //Devuelve un nombre para un jugador.

    public static boolean reglasNombre(String name) {
        int reglasRotas = 0;                    //Variable donde almacenamos si se rompe una regla
        char letterA = name.charAt(0);                  //Almacenamos la primera letra del nombre introducido
        char LetterB = name.toLowerCase().charAt(0);    //Al macenamos la primera letra en minusculas

        if (letterA == LetterB) {           //Si la primera letra es igual a ella misma en minuscula
            System.out.println("La primera letra está en minuscula.");  //Quiere decir que rompe una regla
            reglasRotas++;
        }

        if (name.length() >= 11 || name.length() <= 3) {        //Se comprueba la longitud del nombre
            System.out.println("La longitud es incorrecta, los nombre deben incluir más de 3 carcteres y menos de 10.");
            reglasRotas++;
        }

        letterA = name.charAt(name.length() - 1);   //Se almacena el último caracter del nombre
        LetterB = name.charAt(name.length() - 2);   //Se almacena el penúltimo caracter del nombre
        int numExiste = 0;              //En esta variable almacenaremos si el último o penúltimo caracter es un número
        char numA;
        for (int num = 0; num < 10; num++) {
            num += 48;              //Para almacenar el num en un char y realizar la comparación,
            numA = (char) num;      //necesitamos almacenar el equivalente en código ASCII
            if (letterA == numA) {          //Comparamos cada número con el último carcter,
                numExiste++;                //Si coinciden, se suma 1 a la variable numExiste
            }
            if (LetterB == numA) {          //Comparamos cada número con el penúltimo carcter,
                numExiste++;                //Si coinciden, se suma 1 a la variable numExiste
            }
            num -= 48;
        }
        if (numExiste != 2) {       //Si numExiste no ha llegado a 2 quiere decir que uno de los últimos caracteres no era un número
            System.out.println("Los dos últimos caracteres del nombre deben ser números.");
            reglasRotas++;
        }

        return reglasRotas > 0;  //Si se rompe una o más reglas se devuelve true
    }   //Devuelve True o False en función de si el nombre introducido cumple las reglas.

    public static int[] dadoAleatorio() {                               //El módulo dadoAleatorio,
        int[] misTiradas = new int[numJugadores];                       //genera un Array de un tamaño
        //                                                              //igual al del número de Jugadores.
        for (int elem = 0; elem < misTiradas.length; elem++) {
            misTiradas[elem] = miDado();                                //Los valores del array serán números
        }                                                               //aleatorios de rango [1, n] según
        return misTiradas;                                              //las caras del dado.
    }   //Devuelve un Array que contiene la primera tirada con la que se decidirá el orden de los jugadores.

    public static int miDado() {

        return (int) (Math.random() * (carasDado)) + 1;
    }   //Módulo básico que devuelve un número aleatorio a modo de dado.

    public static boolean repetirTirada() {
        dadoIgual = 0;

        for (int elem : misJugadores) {
            if (elem == 1) {          // Si un jugador a sacado el número máximo, se suma uno a la variable dadoIgual
                dadoIgual++;
            }
        }
        return dadoIgual >= 2;        // En el caso de que haya dos jugadores o más que hayan coincidido se devuelve True
    } //Módulo que devuelve True en caso de que dos jugadores hayan empatado en la tirada inicial.

    public static void ordenJugadores() {
        for (String elem : nombreJugadores) {
            System.out.println(elem);
        }
    }   //Imprime por pantalla los nombres de los jugadores.

    public static void ordenarJugadores() {
        String guardar;                                 //Tras las tiradas, y si es el caso, el desempate; solo hay un jugador en la casilla de salida
        int guardarB;

        while (misJugadores[0] != 1) {                  //Se repite hasta que el jugador designado para salir primero este colocado en la posición 0 del Array
            guardar = nombreJugadores[0];
            guardarB = misJugadores[0];                 //Se guardan los valores en primera posición.

            for (int i = 0; i < misJugadores.length - 1; i++) {     //Se guarda en la posición 0, el valor de la posición 1
                misJugadores[i] = misJugadores[i + 1];              //Se guarda en la posición uno, el valor de la posición 2
                nombreJugadores[i] = nombreJugadores[i + 1];        //Asi hasta que la penultima posición, recibe el valor de la última posición
            }
            nombreJugadores[nombreJugadores.length - 1] = guardar;
            misJugadores[misJugadores.length - 1] = guardarB;       //Se recolocan en última posición los valores guardados desde la primera posición
        }

        for (int elem = 0; elem < numJugadores; elem++) {      //Colocamos a los jugadores ya ordenados en la casilla de salida
            misJugadores[elem] = 1;
        }

    }   //Reordena a los jugadores.

    public static boolean jugadorMeta() {
        return misJugadores[i] <= 63;
    }       //Revisará si el jugador que acaba de terminar su turno ha llegado a la meta.

}