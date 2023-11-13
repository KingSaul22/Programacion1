import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static int numJugadores = 4;
    public static int dadoIgual = 0;
    public static int i = -1;
    public static int nombreTrue = 0;
    public static int carasDado = 6;
    public static int[] misJugadores;
    public static String[] nombreJugadores;

    public static void main(String[] args) {
        System.out.println("Bienvenido al juego de la Oca.\nAntes de simular la partida puede editar algunos valores si lo desea.\n\n");

        char ans;       //Una variable para almacenar la respuesta del usuario
        {
            System.out.println("NUMERO DE JUGADORES\n\nPor defecto, el juego cuenta con 4 jugadores (Amarillo, Verde, Rojo y Naranja) pero puedes cambiar el número de jugadores y sus nombres se lo deseas.");
            ans = getRespuestaSN(); //Llamamos al módulo que solo devolverá 's' o 'n'

            if (ans == 's') {       //Si la persona quiere modificar el número de jugadores y sus nombres:
                numJugadores = getEnteroMayorQue(2);    //El número de jugadores cambiará de 4 al deseado por la persona
                misJugadores = new int[numJugadores];       //El array misJugadores tendrá un tamaño especificado por el usuario
                misJugadores[0] = 1;                        //A la posición 0, le damos el valor 1, esto nos será util a la hora de seleccionar el orden

                System.out.println("\n\nLos nombres deben cumplir una serie de aspectos:\n ·La longitud máxima es de 10 caracteres y la mínima de 5.\n ·La primera letra debe ser mayuscula.\n ·Siempre debe acabar con dos números.\n ·No se puede repetir un nombre.");
                nombreJugadores = new String[numJugadores];                                   //El array nombreJugadores tendrá un tamaño especificado por el usuario
                for (nombreTrue = 0; nombreTrue < nombreJugadores.length; nombreTrue++) {     //Repasaremos el Array donde almacenaremos los nombres de los jugadores
                    nombreJugadores[nombreTrue] = getNombre();                          //En cada posición almacenamos un nombre que es proporcionado por el módulo getNombre()
                    if (reglasNombre(nombreJugadores[nombreTrue])) {                    //En el caso de que el nombre no cumpla las reglas,
                        nombreTrue--;                                                   //restamos 1 al indice para que el for repase de nuevo la posición.
                        System.out.println("El nombre no cumple todas las condiciones, pruebe de nuevo.");
                    } else if (nombreTrue > 0) {                                          //En el caso de que se cumplan las reglas y no sea el primer nombre introducido:
                        if (nombreRepetido(nombreJugadores[nombreTrue])) {               //Se llama al método que comprueba si se ha repetido el nombre.
                            System.out.println("Ese nombre ya esta seleccionado, introduzca otro.");
                            nombreTrue--;                                               //En caso de que esté repetido, restamos 1 al indice para que el for repase de nuevo la posición.
                        }
                    }
                }
                System.out.println("Nombres recogidos y almacenados.\n");

            } else {        //En el caso de que el usuario no quiera cambiar el número y nombre de los jugadores,
                misJugadores = new int[numJugadores];   //Creamos un Array con el tamaño estandar, 4 jugadores
                misJugadores[0] = 1;            //A la posición 0, le damos el valor 1, esto nos será util a la hora de seleccionar el orden

                //nombreJugadores = new String{"Amarillo", "Verde", "Rojo", "Naranja"};
                nombreJugadores = new String[numJugadores];   //Creamos un Array con el tamaño estandar, 4 jugadores
                nombreJugadores[0] = "Amarillo";
                nombreJugadores[1] = "Verde";               //Almacenamos una serie de nombres predeterminados
                nombreJugadores[2] = "Rojo";
                nombreJugadores[3] = "Naranja";

                System.out.println("Se usaran los nombres por defecto: Amarillo, Verde, Rojo y Naranja.\n");
            }
        }           //Se pregunta a la persona el número de jugadores y sus nombres

        {
            System.out.println("TIPO DE DADO\n\nPor defecto, el dado usado tiene 6 caras pero puedes cambiarlo si lo deseas.");
            ans = getRespuestaSN();         //Se recoge la respuesta del usuario
            if (ans == 's') {               //Si desea cambiar el número de las caras del dado,
                carasDado = getEnteroMayorQue(2);   //recogemos ese número
            }
            System.out.printf("\nLa partida se desarrollará usando un dado de %d caras.\n\n", carasDado);
        }           //Se pregunta a la persona si desea cambiar de dado
        sc.close();     //No se usará más el escaner

        int[] primeraTirada = dadoAleatorio();                      // Se guarda la primera tirada para calcular el orden de salida
        int almacen = 0;

        for (int elem = 1; elem < primeraTirada.length; elem++) {       //Se repasa el array con la primera tirada

            if (primeraTirada[almacen] < primeraTirada[elem]) {         //Este bucle conpara el dado de cada jugador

                misJugadores[almacen] = 0;                              //Y se le coloca en misJugadores el valor 1 al primer jugador de la lista que haya sacado el número máximo
                misJugadores[elem] = 1;
                almacen = elem;
            }
        }         // Se revisará quién tiene el número más alto

        for (int elem = almacen + 1; elem < primeraTirada.length; elem++) {
            if (primeraTirada[almacen] == primeraTirada[elem]) {        //En el caso de que haya más jugadores con la tirada maxima,
                misJugadores[elem] = 1;                                 //también se les otorga un 1
            }
        }   //Todos los jugadores que tengan la misma tirada máxima, también tendrán un 1 guardado en misJugadores[]

        while (repetirTirada()) {

            for (int elem = 0; elem < misJugadores.length; elem++) {

                if (misJugadores[elem] == 1) {          // Si un jugador esta empatado tendrá un '1'
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

    }

    public static int getEnteroMayorQue(int min) {
        int num;
        String datoNum;     //Recogeremos le número en un String
        do {
            System.out.printf("Introduzca un número mayor que %d: ", min - 1);
            datoNum = sc.nextLine();

            while (datoNum.isEmpty() || soloDigitos(datoNum)) {     //Si el input está vacio o no son exclusivamente números
                System.out.print("No se ha podido recoger ningún dato válido, pruebe de nuevo: ");
                datoNum = sc.nextLine();                            //Recogemos otro input
            }

            num = Integer.parseInt(datoNum);        //Transformamos a entero el String
        } while (num < min);  //En el caso de que no cumpla con el mínimo, se repite.

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

    public static char getRespuestaSN() {
        String respTotal;  //Se almacenara aquí la respuesta
        System.out.print("Responda con 's' o 'n': ");
        do {
            respTotal = sc.nextLine(); //Se recoge el input

            if (!respTotal.equalsIgnoreCase("s") && !respTotal.equalsIgnoreCase("n")) {      //Si no es la respuesta deseada
                System.out.println("No se ha detectado una respuesta valida('s' o 'n').");                          //Enviamos un mensaje al usuario
                System.out.print("Pruebe de nuevo: ");                  //Se le pide de nuevo
            }
        } while (!respTotal.equalsIgnoreCase("s") && !respTotal.equalsIgnoreCase("n"));      //Si no es la respuesta deseada se repite

        return respTotal.toLowerCase().charAt(0);  //Se devuelve la respuesta en minusculas
    }   //Comprueba que la respuesta sea 's' o 'n'.

    public static String getNombre() {
        String respuesta;       //Se almacenará el nombre
        do {
            System.out.println("\nIntroduzca un nombre: ");
            respuesta = sc.nextLine();
        } while (respuesta.length() <= 1);  //Se comprueba que la respuesta no esté vacia, y que tenga al menos dos caracteres, de está manera no habrá errores en reglasNombres()

        return respuesta;  //Se devuelve lo que se haya escrito
    }   //Devuelve un nombre para un jugador.

    public static boolean reglasNombre(String name) {
        int reglasRotas = 0;                    //Variable donde almacenamos si se rompe una regla
        char letterA = name.charAt(0);                  //Almacenamos la primera letra del nombre introducido
        char LetterB = name.toLowerCase().charAt(0);    //Al macenamos la primera letra en minusculas

        if (letterA == LetterB) {           //Si la primera letra es igual a ella misma en minuscula
            System.out.println("La primera letra está en minuscula.");  //Quiere decir que rompe una regla
            reglasRotas++;
        }

        if (name.length() >= 11 || name.length() <= 4) {        //Se comprueba la longitud del nombre
            System.out.println("La longitud es incorrecta, los nombre deben incluir más de 4 carcteres y menos de 11.");
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

    public static boolean nombreRepetido(String nombre) {
        int repetido = 0;       //Aquí almacenaremos las veces que se ha repetido el nombre

        for (int copia = nombreTrue - 1; copia >= 0; copia--) {       //Repasaremos el array desde; la posición del nombre recibido menos 1, hasta la posicion 0
            if (nombre.equals(nombreJugadores[copia])) {             //Si el nombre recibido es igual a uno ya seleccionado,
                repetido++;                                         //Se sumará uno al contador repetido.
            }
        }
        return repetido >= 1;  //Devuelve True si se ha repetido
    }    //Revisará que no se repita el nombre.

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
        return misJugadores[i] <= 63; //Devuelve True mientras no llega a la meta
    }     //Revisará si el jugador que acaba de terminar su turno ha llegado a la meta.

}