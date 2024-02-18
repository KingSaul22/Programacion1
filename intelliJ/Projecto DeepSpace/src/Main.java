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
    private static int turno = 0;

    public static void main(String[] args) {
        generarDadosDefault();
        generarTablero();
    }

    private static void generarTablero() {
        numJugadores = EntradaUsuario.getEnteroMinMax("Introduzca el número de jugadores [2-4]\nSelección", 2, 4);
        tablero = new Tablero(numJugadores);
        generarJugadores();
        tablero.ordenarJugadores(ordenJugadores());

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
        int[] resultadoDadoB = new int[numJugadores];
        int[] indicesJugadores = new int[numJugadores];
        int aux;
        for (int i = 0; i < numJugadores; i++) {
            resultadoDadoB[i] = dadoB.lanzar();
            indicesJugadores[i] = i;
        }

        for (int i = 1; i< numJugadores; i++){
            for (int j = 0; j< numJugadores; j++){
                if (resultadoDadoB[j] < resultadoDadoB[i]){
                    aux = resultadoDadoB[i];
                    resultadoDadoB[i] = resultadoDadoB[j];
                    resultadoDadoB[j] = aux;
                    aux = indicesJugadores[i];
                    indicesJugadores[i] = indicesJugadores[j];
                    indicesJugadores[j] = aux;
                }
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
                    tablero.getJugadorPosicion(turno / 2).gastarOro(nave.getPrecio());
                } catch (IllegalValueException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                tablero.retirarCartaMazoNaves(opcion);

                System.out.println("Seleccione el planeta al que asignará la nave");
                String tusPlanetas = tablero.getPlanetasJugador(turno / 2);
                int planeta;
                do {
                    System.out.println(tusPlanetas);
                    planeta = EntradaUsuario.getEnteroMinMax("\nIntroduce el número de tu planeta", 0, CAPACIDAD_SISTEMA_SOLAR);
                    try {
                        tablero.nuevaNaveOrbital(nave, planeta, turno / 2);
                        ok = true;
                    } catch (ExceptionCompraCarta e) {
                        System.out.println(e.getMessage());
                    }
                } while (!ok);
            }
        } while (opcion != 0 && !ok);
    }

    /**
     *
     */
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
            tablero.getJugadorPosicion(turno / 2).conseguirOro(1);
        } else {
            System.out.println("Dispones de 1 unidad de " + material.toString() + " que debes asignar a un planeta");
            String tusPlanetas = tablero.getPlanetasJugador(turno / 2);
            int planeta;
            boolean ok = false;
            do {
                System.out.println(tusPlanetas);
                planeta = EntradaUsuario.getEnteroMinMax("\nIntroduce el número de tu planeta", 1, CAPACIDAD_SISTEMA_SOLAR);

                try {
                    tablero.masMaterial(material, planeta, turno / 2);
                    ok = true;
                } catch (ExceptionCompraCarta e) {
                    System.out.println(e.getMessage());
                }
            } while (!ok);
        }
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
