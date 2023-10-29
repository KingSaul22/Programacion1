import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static int numJugadores = 4;
    public static int carasDado = 6;
    public static int[] misJugadores;
    public static String[] nombreJugadores = {"Amarillo", "Verde", "Rojo", "Naranja"};
    public static int dadoIgual = 0, i = -1;

    public static void main(String[] args) {
        System.out.println("Bienvenido al juego de la Oca.\nAntes de simular la partida puede editar algunos valores si lo desea.\n");

        char ans;
        {
            System.out.printf("Por defecto, el juego cuenta con 4 jugadores (Amarillo, Verde, Rojo y Naranja) pero puedes cambiar el número de jugadores y sus nombres se lo deseas.\nResponda con 'n' o 's': ");
            ans = sc.nextLine().charAt(0);
            if (ans == 's') {
                System.out.println("Introduzca el número de jugadores mayor que dos:");
                numJugadores = getCarasDado(2);
                misJugadores = new int[numJugadores];
                misJugadores[0] = 1;


            }

        }           //Se pregunta a la persona el número de jugadores y sus nombres


        {
            System.out.printf("Por defecto, el dado usado tiene 6 caras pero puedes cambiarlo si lo deseas.\nResponda con 'n' o 's': ");
            ans = sc.nextLine().charAt(0);
            if (ans == 's') {
                carasDado = getCarasDado(2);
            }
            System.out.printf("\n La partida se desarrollará usando un dado de %d caras. \n\n", carasDado);
        }       //Se pregunta a la persona si desea cabiar de dado


        int almacen = 0;

        int[] primeraTirada = dadoAleatorio();                       // Se guarda la primera tirada para calcular el orden de salida

        for (int elem = 1; elem < primeraTirada.length; elem++) {

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


        while (jugadorMeta()) {                     // Este bucle se repetira hasta que un jugador haya llegado o superado la meta
            i++;                                    // El while ciclara cada turno, de ahí que necesite sumar un 1 al indice del Array misJugadores y nombreJugadores
            if (i == numJugadores) {                // Al sumar 1 cada vez, si queremos que empiece a leer desde la posición 0 debo declarar que i es igual a -1
                i = 0;                              // En el caso de que el índice sea igual que numJugadores, se empezará de nuevo el Array cambiando su valor a cero
            }

            almacen = miDado();                     // Reusamos la variable para ahorrar crear una nueva y llamamos al módulo miDado
            misJugadores[i] += almacen;             // Le sumamos a la posición el resultado del dado
            System.out.printf("\nEl jugador %s ha sacado un %d y pasa a la casilla %d\n", nombreJugadores[i], almacen, misJugadores[i]);

            while (misJugadores[i] % 4 == 0 && misJugadores[i] != 64) {     // Siempre que caiga en una casilla multiplo de 4 y no haya alcanzado la meta
                System.out.println("El jugador a caido en la casilla de la Oca, recibe tirada extra");
                almacen = miDado();                                         // El jugador recibe una tirada extra
                misJugadores[i] += almacen;
                System.out.printf("El jugador %s ha sacado un %d y pasa a la casilla %d\n", nombreJugadores[i], almacen, misJugadores[i]);
            }

            if (misJugadores[i] == 63) {    //En el caso de que caiga en la casilla calavera
                misJugadores[i] = 1;        //El jugador es enviado a la casilla de salida
                System.out.printf("El jugador %s ha caido en la casilla calavera.\nEmpieza desde el inicio.", nombreJugadores[i]);
            }
        } // Progresión del juego

        System.out.printf("\n\nEl ganador es el jugador %s.", nombreJugadores[i]);

    }

    public static int getCarasDado(int min) {
        int num;
        do {
            System.out.printf("Introduzca un número mayor que %d \n", min - 1);
            while (!sc.hasNextInt()) {
                System.out.println("El dato introducido no es reconocido como un número entero.");
                sc.next();
            }
            num = sc.nextInt();
        } while (num < min);
        return num;
    } // Módulo que devuelve un número entero mayor a 1

    public static int[] dadoAleatorio() {                               //El módulo dadoAleatorio,
        int[] misTiradas = new int[numJugadores];                       //genera un Array de un tamaño
        //                                                              //igual al del número de Jugadores.
        for (int elem = 0; elem < misTiradas.length; elem++) {
            misTiradas[elem] = miDado();                                //Los valores del array serán números
        }                                                               //aleatorios de rango [1, n] según
        return misTiradas;                                              //las caras del dado.
    }

    public static int miDado() {

        return (int) (Math.random() * (carasDado)) + 1;
    }   //Módulo básico que devuelve un número aleatorio a modo de dado

    public static boolean repetirTirada() {
        dadoIgual = 0;

        for (int elem = 0; elem < misJugadores.length; elem++) {
            if (misJugadores[elem] == 1) {          // Si un jugador a sacado el número máximo, se suma uno a la variable dadoIgual
                dadoIgual++;
            }
        }
        if (dadoIgual >= 2) {                       // En el caso de que haya dos jugadores o más que hayan coincidido se devuelve True

            return true;
        }
        return false;
    } //Módulo que devuelve True en caso de que dos jugadores hayan empatado en la tirada inicial.

    public static void ordenJugadores() {
        for (String elem : nombreJugadores) {
            System.out.println(elem);
        }
    }   //Imprime por pantalla los nombres de los jugadores

    public static void ordenarJugadores() {
        String guardar;                                 //Tras las tiradas, y si es el caso, el desempate; solo hay un jugador en la casilla de salida

        while (misJugadores[0] != 1) {                  //Se repite hasta que el jugador designado para salir primero este colocado en la posición 0 del Array
            misJugadores[0] = misJugadores[1];
            misJugadores[1] = misJugadores[2];          //Se mueve una posición atras a todos los valores del array donde guardamos las posiciones de los jugadores
            misJugadores[2] = misJugadores[3];          //Y al primer valor lo colocamos último
            misJugadores[3] = 0;

            guardar = nombreJugadores[0];
            nombreJugadores[0] = nombreJugadores[1];    //Hacemos lo mismo pero con los nombres
            nombreJugadores[1] = nombreJugadores[2];
            nombreJugadores[2] = nombreJugadores[3];
            nombreJugadores[3] = guardar;
        }
        misJugadores[1] = 1;
        misJugadores[2] = 1; //Colocamos a los jugadores ya ordenados en la casilla de salida
        misJugadores[3] = 1;

    }   //Reordena a los jugadores

    public static boolean jugadorMeta() {
        if (misJugadores[i] <= 63) {
            return true;
        }

        return false;
    }       //Revisará si un jugador ha llegado a la meta

}