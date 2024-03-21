import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import Excepciones.MazoException;
import Model.Cromo;
import Model.Escudo;
import Model.Jugador;
import Model.Mazo;

public class Main {

    public static String REAL_MADRID = "Real Madrid";
    public static String REAL_BETIS = "Real Betis";
    public static String BARCELONA = "Barcelona";

    // Se eliminan tildes para facilitar encontrar los nombres
    private static Jugador modric = new Jugador("1", "Modric", REAL_MADRID, 170);
    private static Jugador benzema = new Jugador("2", "Benzema", REAL_MADRID, 181);
    private static Jugador curtois = new Jugador("3", "Curtois", REAL_MADRID, 196);
    private static Jugador joaquin = new Jugador("4", "Joaquin", REAL_BETIS, 175);
    private static Jugador canales = new Jugador("5", "Canales", REAL_BETIS, 180);
    private static Jugador fekir = new Jugador("6", "Fekir", REAL_BETIS, 170);
    private static Jugador panda = new Jugador("7", "Borja Iglesias", REAL_BETIS, 189);
    private static Jugador dembele = new Jugador("8", "Dembele", BARCELONA, 176);
    private static Jugador busquets = new Jugador("9", "Busquets", BARCELONA, 187);
    private static Jugador gabi = new Jugador("10", "Gabi", BARCELONA, 172);

    private static Escudo realMadrid = new Escudo("11", REAL_MADRID, 1895, 4);
    private static Escudo realBetis = new Escudo("12", REAL_BETIS, 1897, 4);
    private static Escudo barcelona = new Escudo("13", BARCELONA, 1896, 6);

    private static ArrayList<Cromo> todos = new ArrayList<>(
            List.of(modric, benzema, curtois, joaquin, canales, fekir, panda, dembele, busquets, gabi, realMadrid, realBetis, barcelona)
    );

    public static void main(String[] args) {
        Mazo m1 = new Mazo();
        Mazo m2 = new Mazo();


        // El mazo 1 es el nuestro, el mazo 2 es otro
        m2.addCromo(modric);
        m2.addCromo(joaquin);
        m2.addCromo(realMadrid);
        m2.addCromo(gabi);
        m2.addCromo(panda);

        // Ahora vamos a crear un array para permitir mostrar todos los cromos

        Scanner sc = new Scanner(System.in);

        /*
         * OJO, IMPORTANTE: Si hubiese que controlar excepciones no est� hecho aqu�
         */
        boolean fin = false;
        while (!fin) {
            try {
                System.out.println(menu());
                System.out.print("\n�Qu� desea hacer?: ");
                int op = Integer.parseInt(sc.nextLine());

                switch (op) {
                    case 1:
                        System.out.println("\n¿Qué cromo desea añadir?: ");
                        mostrarCromos();

                        String nombre = sc.nextLine();
                        Cromo c = get(nombre);

                        m1.addCromo(c);

                        break;
                    case 2:
                        System.out.println("¿Cuál de tus cromos quieres cambiar?: ");
                        mostrarCromosDeMazo(m1);
                        String nombreCromoParaCambiar = sc.nextLine();
                        Cromo cromoParaCambiar = get(nombreCromoParaCambiar);

                        System.out.println("¿Por qué cromo quieres cambiarlo?: ");
                        mostrarCromosDeMazo(m2);
                        String nombreCromoDelOtro = sc.nextLine();
                        Cromo cromoDelOtro = get(nombreCromoDelOtro);

                        m1.intercambiar(cromoParaCambiar, cromoDelOtro);

                        /*
                         * Aqu� habr�a que "restar" ese cromo del mazo 2, pero obviaremos esto para
                         * facilitar el problema
                         */


                        break;
                    case 3:
                        System.out.println("Mezclando m1 con m2");
                        m1.mezclar(m2);
                        break;
                    case 4:
                        System.out.println("Actualmente tienes " + m1.contarDiferentes() + " cromos diferentes");
                        break;
                    case 5:
                        System.out.println("�De qu� equipo quieres mostrar los cromos?: ");
                        String equipoMostrar = sc.nextLine();
                        m1.cromosDeUnEquipo(equipoMostrar).stream().forEach(System.out::println);
                        break;
                    case 6:
                        System.out.println("�De qu� equipo quieres mostrar la altura media?: ");
                        String equipoAltura = sc.nextLine();
                        System.out.println(m1.alturaMedia(equipoAltura));
                        break;
                    case 7:
                        m1.getLista().stream().forEach(System.out::println);
                        break;
                    case 8:
                        m1.ordenar().stream().forEach(System.out::println);
                        break;
                    case 9:
                        m1.equipoCompleto().stream().forEach(System.out::println);
                        break;
                    case 10:
                        System.out.println("Que tenga un buen d�a.");
                        fin = true;
                        break;
                    default:
                        System.err.println("Opción inválida.");
                }
            } catch (MazoException e) {
                System.err.println("\n" + e.getMessage());
            }
        }

        sc.close();


    }

    private static String menu() {
        return "\n(1) A�adir nuevo cromo"
                + "\n(2) Intercambiar dos cromos"
                + "\n(3) Mezclar con otro mazo"
                + "\n(4) Contar cromos diferentes"
                + "\n(5) Mostrar los cromos de un equipo dado"
                + "\n(6) Calcular la altura media"
                + "\n(7) Mostrar lista de cromos"
                + "\n(8) Mostrar los cromos ordenados"
                + "\n(9** Extra) Mostrar equipos completos"
                + "\n(10) Salir";
    }

    private static void mostrarCromos() {
        todos.stream().map(Cromo::getNombre).forEach(System.out::println);
    }

    private static void mostrarCromosDeMazo(Mazo m) {
        m.getLista().forEach(System.out::println);
    }

    /**
     * TODO: recorrer todos los cromos de la lista "todos" y devolver aqu�l cromo
     * cuyo nombre coincide con el pasado por par�metro
     *
     * @param nombre el nombre del cromo buscado
     * @return El cromo correspondiente
     */
    private static Cromo get(String nombre) {

    }

}