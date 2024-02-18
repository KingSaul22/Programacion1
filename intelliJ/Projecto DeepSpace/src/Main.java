import Base.Dado;
import Base.Jugador;
import Base.Tablero;
import Enums.TMateriales;
import Excepciones.ExceptionCompraCarta;
import Excepciones.IllegalPlayerName;
import Excepciones.IllegalValueException;
import ObjCartas.CartaNave;
import utils.EntradaUsuario;

import static Base.Tablero.CAPACIDAD_SISTEMA_SOLAR;

public class Main {
    private static final int LONG_MIN_JUGADOR = 4;
    private static final int LONG_MAX_JUGADOR = 10;
    private static Tablero tablero;
    private static int numJugadores;
    private static Dado dadoA, dadoB, dadoC;
    private static final int RONDA_MAXIMA = 20;
    private static int accion = 0, turno = 0, ronda = 0;

    public static void main(String[] args) {
        generarDadosDefault();
        inicializarTablero();
        int opcion;
        do {
            if (accion == 2) {
                accion = 0;
                if (turno == numJugadores - 1) {
                    ronda++;
                    turno = 0;
                } else {
                    turno++;
                }
            }

            System.out.println("\nRonda actual: " + ronda + "/" + RONDA_MAXIMA);
            System.out.println("Juega: " + tablero.getJugadorPosicion(turno).getNombre());
            imprimirMenu();
            opcion = EntradaUsuario.getEnteroMinMax("Selección", 1, 12);

            switch (opcion) {
                case 12:
                    accion = 2;
                    System.out.println("Saltas tu turno");
                    break;
                case 1:
                    comprarNave();
                    break;
                case 2:
                    comprarConstruccion();
                    break;
                case 3:
                    if (tablero.getJugadorPosicion(turno).getOro() == 0) {
                        System.out.println("No se dispone de los fondos necesarios");
                    } else {
                        comprarMaterial();
                    }
                    break;
                case 4:
                    construir();
                    break;
                case 5:
                    moverNave();
                    break;
                case 6:
                    atacar();
                    break;
                case 7:
                    transportarCarga();
                    break;
                case 8:
                    transportarPersonas();
                    break;
                case 9:
                    mejorarNave();
                    break;
                case 10:
                    reparar();
                    break;
                case 11:
                    System.out.println(tablero.getPlanetasTablero());
            }


        } while (!endGame());
    }

    private static void reparar() {
    }

    private static void mejorarNave() {
    }

    private static void transportarPersonas() {
    }

    private static void transportarCarga() {
    }

    private static void atacar() {
    }

    private static void moverNave() {
        //TODO: Mover naves, la interfaz Atacador puede moverse a planetas ajenos
    }

    private static void construir() {
        //TODO: Excepcion con mazo vacio
    }

    /**
     * Método que comprueba que el juego ha finalizado
     * <p>
     * Se finalizará el juego si solo queda un jugador con planetas o se ha alcanzado el número de rondas máximo.
     *
     * @return True cuando se acaba el juego
     */
    private static boolean endGame() {
        int jugadoresVivos = numJugadores;
        for (int i = 0; i < numJugadores; i++) {
            if (tablero.getPlanetasJugador(i).isEmpty()) numJugadores--;
        }

        return numJugadores == 1 || ronda == RONDA_MAXIMA;
    }

    private static void inicializarTablero() {
        numJugadores = EntradaUsuario.getEnteroMinMax("Introduzca el número de jugadores [2-4]\nSelección", 2, 4);
        tablero = new Tablero(numJugadores);
        generarJugadores();
        tablero.establecerOrdenJugadores(ordenJugadores());
        tablero.generarPlanetas();
        System.out.println(tablero.getPlanetasTablero());
        System.out.println("\nAsignando un planeta de manera aleatoria a cada jugador.");
        tablero.primerPlaneta();
    }

    private static void generarJugadores() {
        String nombre;
        for (byte i = 1; i <= numJugadores; i++) {
            try {
                nombre = EntradaUsuario.getNombreLongitudMinMax("\nIntroduzca el nombre para el jugador " + i, LONG_MIN_JUGADOR, LONG_MAX_JUGADOR);
                tablero.newPlayer(new Jugador(nombre));
            } catch (IllegalPlayerName e) {
                System.out.println(e.getMessage());
                i--;
            }
        }
    }

    private static int[] ordenJugadores() {
        //TODO: Corregir fallo con 3 y 4 jugadores método ordenJugadores()
        int[] resultadoDadoB = new int[numJugadores];
        int[] indicesJugadores = new int[numJugadores];
        int aux;
        for (int i = 0; i < numJugadores; i++) {
            resultadoDadoB[i] = dadoB.lanzar();
            indicesJugadores[i] = i;
        }

        for (int i = 1; i < numJugadores; i++) {
            for (int j = 0; j < numJugadores; j++) {
                if (resultadoDadoB[j] < resultadoDadoB[i]) {
                    aux = resultadoDadoB[i];
                    resultadoDadoB[i] = resultadoDadoB[j];
                    resultadoDadoB[j] = aux;
                    aux = indicesJugadores[i];
                    indicesJugadores[i] = indicesJugadores[j];
                    indicesJugadores[j] = aux;
                }
            }
        }

        boolean[] jugadoresFijos = new boolean[numJugadores];
        if (resultadoDadoB[0] == resultadoDadoB[1]) jugadoresFijos[0] = true;
        if (resultadoDadoB[numJugadores - 1] == resultadoDadoB[numJugadores - 2])
            jugadoresFijos[numJugadores - 1] = true;


        int contRepetido = 0;
        boolean ok;
        for (int i = 0; i < numJugadores - 1; i++) {
            if (resultadoDadoB[i] == resultadoDadoB[i + 1] && !jugadoresFijos[i]) {
                for (int j = i; j < numJugadores; j++) {
                    if (resultadoDadoB[i] != resultadoDadoB[j]) break;
                    contRepetido++;
                }
                do {
                    for (int j = i; j < contRepetido; j++) {
                        resultadoDadoB[j] = dadoB.lanzar();
                    }
                    for (int k = i; k < i + contRepetido; k++) {
                        if (!jugadoresFijos[k]) {
                            for (int m = 0; m < numJugadores && !jugadoresFijos[m]; m++) {
                                if (resultadoDadoB[m] < resultadoDadoB[k]) {
                                    aux = resultadoDadoB[k];
                                    resultadoDadoB[k] = resultadoDadoB[m];
                                    resultadoDadoB[m] = aux;
                                    aux = indicesJugadores[k];
                                    indicesJugadores[k] = indicesJugadores[m];
                                    indicesJugadores[m] = aux;
                                }
                            }
                        }
                    }

                    int contRepetB = 0;
                    for (int j = i; j < i + contRepetido - 1; j++) {
                        if (resultadoDadoB[j] != resultadoDadoB[j + 1] && !jugadoresFijos[j]) {
                            if (j != 0) {
                                if (!jugadoresFijos[j - 1] && resultadoDadoB[j] != resultadoDadoB[j - 1]) {
                                    jugadoresFijos[j] = true;
                                }
                            } else {
                                jugadoresFijos[j] = true;
                            }
                        }
                    }

                    ok = true;
                    for (int j = i; j < i + contRepetido - 1; j++) {
                        if (!jugadoresFijos[j]) {
                            ok = false;
                            break;
                        }
                    }


                } while (!ok);

                for (int j = i; j < i + contRepetido; j++) jugadoresFijos[j] = true;

            } else {
                jugadoresFijos[i] = true;
            }
        }

        return indicesJugadores;
    }

    private static void comprarNave() {
        int opcion = 0;
        boolean ok = false;
        do {
            System.out.println("\nSeleccione la carta del mazo de naves:" + tablero.getMazoNaves() + "\n  0. Cancelar");
            opcion = EntradaUsuario.getEnteroMinMax("Selección", 0, 4);
            if (opcion != 0) {
                CartaNave nave = tablero.getCartaNave(opcion - 1);
                try {
                    tablero.getJugadorPosicion(turno).gastarOro(nave.getPrecio());
                } catch (IllegalValueException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                tablero.retirarCartaMazoNaves(opcion);

                System.out.println("Seleccione el planeta al que asignará la nave");
                String tusPlanetas = tablero.getPlanetasJugador(turno);
                int planeta;
                do {
                    System.out.println(tusPlanetas);
                    planeta = EntradaUsuario.getEnteroMinMax("\nIntroduce el número de tu planeta", 0, CAPACIDAD_SISTEMA_SOLAR);
                    try {
                        tablero.nuevaNaveOrbital(nave, planeta, turno);
                        ok = true;
                    } catch (ExceptionCompraCarta e) {
                        System.out.println(e.getMessage());
                    }
                } while (!ok);
            }
        } while (opcion != 0 && !ok);

        if (opcion != 0) accion++;
    }

    private static void comprarConstruccion() {
        //TODO: Crear método para comprar cartas de construcción
    }

    private static void comprarMaterial() {
        System.out.println("\nA continuación se le dará una unidad de un material aleatorio");
        byte opcion = (byte) (Math.random() * 4 + 1);
        TMateriales material = null;

        switch (opcion) {
            case 1 -> material = TMateriales.PIEDRA;
            case 2 -> material = TMateriales.HIERRO;
            case 3 -> material = TMateriales.COMBUSTIBLE;
            case 4 -> material = TMateriales.ORO;
        }
        if (opcion == 4) {
            System.out.println("\nSe ha añadido uno de oro a tus fondos");
            tablero.getJugadorPosicion(turno).conseguirOro(1);
        } else {
            System.out.println("Dispones de 1 unidad de " + material.toString() + " que debes asignar a un planeta");
            String tusPlanetas = tablero.getPlanetasJugador(turno);
            int planeta;
            boolean ok = false;
            do {
                System.out.println(tusPlanetas);
                planeta = EntradaUsuario.getEnteroMinMax("\nIntroduce el número de tu planeta", 1, CAPACIDAD_SISTEMA_SOLAR);

                try {
                    tablero.masMaterial(material, planeta, turno);
                    ok = true;
                } catch (ExceptionCompraCarta e) {
                    System.out.println(e.getMessage());
                }
            } while (!ok);
        }

        accion++;
    }

    private static void generarDadosDefault() {
        //Crear variables final para los dados default(?)
        try {
            dadoA = new Dado(4, 2);
            dadoB = new Dado(12, 1);
            dadoC = new Dado(6, 10);
        } catch (IllegalValueException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void imprimirMenu() {
        System.out.println("""
                                
                Seleccione una de las siguientes acciones:
                  1. Comprar carta de nave
                  2. Comprar carta de construcción
                  3. Coger una carta del mazo de materias primas
                  4. Construir
                  5. Mover una nave de un planeta a otro
                  6. Atacar
                  7. Transportar carga
                  8. Transportar personas
                  9. Mejorar una nave
                 10. Reparar
                 11. Mostrar la información de los planetas
                 12. Pasar turno"""
        );
    }
}
