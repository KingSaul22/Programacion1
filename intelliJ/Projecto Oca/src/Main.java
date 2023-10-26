
public class Main {

    public static int[] misJugadores = {1, 0, 0, 0};
    public static String[] nombreJugadores = {"Amarillo", "Verde", "Rojo", "Naranja"};
    public static int dadoIgual = 0;
    public static final int numJugadores = 4;
    public static final int carasDado = 6;

    public static void main(String[] args) {
        int almacen = 0;

        int[] primeraTirada = dadoAleatorio();

        for (int elem = 1; elem < primeraTirada.length; elem++) {

            if (primeraTirada[almacen] < primeraTirada[elem]) {

                misJugadores[almacen] = 0;
                misJugadores[elem] = 1;
                almacen = elem;
            }
        }

        for (int elem = almacen + 1; elem < primeraTirada.length; elem++) {
            if (primeraTirada[almacen] == primeraTirada[elem]) {
                misJugadores[elem] = 1;
            }
        }

        while (repetirTirada()) {

            for (int elem = 0; elem < misJugadores.length; elem++) {

                if (misJugadores[elem] == 1) {
                    primeraTirada[elem] = miDado();
                } else {
                    primeraTirada[elem] = 0;
                }

            }

            for (int elem = almacen + 1; elem < primeraTirada.length; elem++) {

                if (primeraTirada[almacen] > primeraTirada[elem]) {
                    misJugadores[elem] = 0;
                } else if (primeraTirada[almacen] < primeraTirada[elem]) {
                    misJugadores[almacen] = 0;
                    almacen = elem;
                }
            }
        }

        System.out.println("Empieza el jugador " + nombreJugadores[almacen]);
        System.out.println("\nEl orden será el siguiente:");
        ordenarJugadores();
        ordenJugadores();


    }

    public static int[] dadoAleatorio() {                               //El módulo dadoAleatorio,
        int[] misTiradas = new int[numJugadores];                       //genera un Array de un tamaño
        //igual al del número de Jugadores.
        for (int elem = 0; elem < misTiradas.length; elem++) {
            misTiradas[elem] = (int) (Math.random() * (carasDado)) + 1; //Los valores del array serán números
        }                                                               //aleatorios de rango [1, 6] que son
        return misTiradas;                                              //las caras del dado.
    }

    public static int miDado() {

        return (int) (Math.random() * (carasDado)) + 1;
    }

    public static boolean repetirTirada() {
        dadoIgual = 0;

        for (int elem = 0; elem < misJugadores.length; elem++) {
            if (misJugadores[elem] == 1) {
                dadoIgual++;
            }
        }
        if (dadoIgual >= 2) {

            return true;
        }
        return false;
    }

    public static void ordenJugadores() {
        for (String elem : nombreJugadores) {
            System.out.println(elem);
        }
    }

    public static void ordenarJugadores() {
        String guardar;
        while(misJugadores[0] != 1){
            misJugadores[0]=misJugadores[1];
            misJugadores[1]=misJugadores[2];
            misJugadores[2]=misJugadores[3];
            misJugadores[3]=0;

            guardar= nombreJugadores[0];
            nombreJugadores[0]=nombreJugadores[1];
            nombreJugadores[1]=nombreJugadores[2];
            nombreJugadores[2]=nombreJugadores[3];
            nombreJugadores[3]=guardar;
        }
    }

}