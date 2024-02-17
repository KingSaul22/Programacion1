import Base.Dado;
import Base.Jugador;
import Base.Tablero;
import Excepciones.IllegalPlayerName;
import Excepciones.IllegalValueException;
import utils.EntradaUsuario;

public class Main {
    private static final int LONG_MIN_JUGADOR = 4;
    private static final int LONG_MAX_JUGADOR = 10;
    private static Tablero tablero;
    private static Dado dadoA, dadoB, dadoC;

    public static void main(String[] args) {
        generarDadosDefault();
        generarTablero();
    }

    private static void generarTablero() {
        int opcion = EntradaUsuario.getEnteroMinMax("Introduzca el número de jugadores [2-4]\nSelección", 2, 4);
        tablero = new Tablero(opcion);
        generarJugadores(opcion);


    }

    private static void generarJugadores(int numJugadores) {
        String nombre;
        for (byte i = 1; i <= numJugadores; i++) {
            try {
                nombre = EntradaUsuario.getNombreLongitudMinMax("\nIntroduzca el nombre para el jugador " + i, LONG_MIN_JUGADOR, LONG_MAX_JUGADOR);
                tablero.newPlayer(new Jugador(nombre));
            } catch (IllegalPlayerName e){
                System.out.println(e.getMessage());
                i--;
            }
        }
    }

    private static void comprarNave() {
        int opcion;
        System.out.println("""
                                
                Seleccione el tipo de nave:
                  1. Ataque (5 de oro)
                  2. Transporte de carga (3 de oro)
                  3. Transporte de habitantes (2 de oro)""");
        opcion = EntradaUsuario.getEnteroMinMax("Selección", 1, 3);

        switch (opcion) {
            case 1:

                break;
            case 2:

                break;
            case 3:

        }
    }

    private static void comprarMaterial() {

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
