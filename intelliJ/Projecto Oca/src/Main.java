
public class Main {

    public static int[] misJugadores = {1, 0, 0, 0};
    public static int dadoIgual = 0;
    public static final int numJugadores = 4;
    public static final int carasDado = 6;

    public static void main(String[] args) {
        //int amarillo = 0, Verde = 1, Rojo = 2, Naranja = 3;
        int almacen = 0;

        //int[] misJugadores = {1, 0, 0, 0};

        int[] primeraTirada = dadoAleatorio();

        for (int elem = 0; elem < primeraTirada.length; elem++) {

            if (elem != 0 && primeraTirada[almacen] < primeraTirada[elem]) {

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

        System.out.println("Tirada uno:");
        System.out.println(primeraTirada[0]);
        System.out.println(primeraTirada[1]);
        System.out.println(primeraTirada[2]);
        System.out.println(primeraTirada[3]);

        System.out.println();
        System.out.println();

        /*for (int elem = 0; elem < misJugadores.length; elem++) {
            if (misJugadores[elem] == 1) {
                primeraTirada[elem] = miDado();
                System.out.println(primeraTirada[elem]);
            }
        }*/


        while (repetirTirada()) {

            for (int elem = 0; elem < misJugadores.length; elem++) {
                if (misJugadores[elem] == 1) {
                    primeraTirada[elem] = miDado();
                    System.out.println(primeraTirada[elem]);
                    System.out.println();
                }
            }

            for (int elem = 0; elem < primeraTirada.length; elem++) {

                if (elem != 0 && primeraTirada[almacen] < primeraTirada[elem]) {

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
        }

        System.out.println(primeraTirada[0]);
        System.out.println(primeraTirada[1]);
        System.out.println(primeraTirada[2]);
        System.out.println(primeraTirada[3]);

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(misJugadores[0]);
        System.out.println(misJugadores[1]);
        System.out.println(misJugadores[2]);
        System.out.println(misJugadores[3]);

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
        dadoIgual=0;

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

}