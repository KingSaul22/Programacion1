package Ejer4b;

import Ejer4b.Enums.TRaza;
import Ejer4b.Excepciones.IllegalValueException;
import Ejer4b.Modelo.Clerigo;
import Ejer4b.Modelo.Mago;
import Ejer4b.Modelo.Personaje;
import EntradaSalida.Lectora;

public class Main {
    private static final int MAX_PERSONAJES = 100;
    private static Personaje[] personajes = new Personaje[MAX_PERSONAJES];

    public static void main(String[] args) {
        int opcion;
        do {
            imprimirMenu();
            opcion = EntradaSalida.Lectora.leerEnteroDeRango("Selección", 7, 1);

            switch (opcion) {
                case 1 -> altaPersonaje();
                case 2 -> magoAprende();
                case 3 -> magoLanza();
                case 4 -> clerigoCura();
                case 5 -> listadoPersonajes();
                case 6 -> listadoPersonajesMayorVida();
            }
        } while (opcion != 7);
    }

    private static void altaPersonaje() {
        int posNuevoPersonaje = -1;
        for (int i = 0; i < MAX_PERSONAJES; i++) {
            if (personajes[i] == null) {
                posNuevoPersonaje = i;
                break;
            }
        }

        if (posNuevoPersonaje < 0) {
            System.out.println("No hay espacio para más personajes");
        } else {
            Personaje personaje = null;
            boolean ok = false;
            String nombre;
            do {
                nombre = EntradaSalida.Lectora.solicitarCadenaMinus("Introduzca el nombre para el personaje");
                for (int i = 0; i < MAX_PERSONAJES; i++) {
                    if (personajes[i] == null) {
                        ok = true;
                        break;
                    } else if (personajes[i].getNombre().equals(nombre)) {
                        System.out.println("Ese nombre ya está en uso");
                        break;
                    }
                }
            } while (!ok);
            TRaza raza = selectRaza();

            int fuerza, inteligencia, vidaMaxima;
            int opcion;
            ok = false;
            do {
                System.out.println("\nSeleccione la profesión del personaje:\n  1. Mago\n  · 2. Clérigo");
                opcion = EntradaSalida.Lectora.leerEnteroDeRango("Selección", 1, 2);

                fuerza = EntradaSalida.Lectora.leerEntero("Introduzca un valor para la fuerza de tu personaje");
                inteligencia = EntradaSalida.Lectora.leerEntero("Introduzca un valor para la inteligencia de tu personaje");
                vidaMaxima = EntradaSalida.Lectora.leerEntero("Introduzca un valor para la vida máxima de tu personaje");

                if (opcion == 1) {
                    try {
                        personaje = new Mago(nombre, raza, fuerza, inteligencia, vidaMaxima);
                        ok = true;
                    } catch (IllegalValueException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    String dios = Lectora.solicitarCadenaMayus("Introduzca el nombre del dios al que sirves");
                    try {
                        personaje = new Clerigo(nombre, raza, fuerza, inteligencia, vidaMaxima, dios);
                        ok = true;
                    } catch (IllegalValueException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } while (!ok);
            personajes[posNuevoPersonaje] = personaje;
        }
    }

    private static void magoAprende() {
        String nombre, hechizo;
        boolean ok = false;
        do {
            nombre = Lectora.solicitarCadenaMinus("Introduzca el nombre del mago");
            hechizo = Lectora.solicitarCadenaMinus("Introduzca el nombre del hechizo");
            for (int i = 0; i < MAX_PERSONAJES; i++){

            }
        } while (!ok);
    }

    private static void magoLanza() {

    }

    private static void clerigoCura() {
    }

    private static void listadoPersonajes() {
        for (int i = 0; i < MAX_PERSONAJES && personajes[i] != null; i++) {
            System.out.println(personajes[i]);
        }
    }

    private static void listadoPersonajesMayorVida() {
    }

    private static TRaza selectRaza() {
        System.out.print("""
                                
                Introduzca la raza de su personaje:
                  1. Humano
                  2. Elfo
                  3. Enano
                  4. Orco
                """
        );

        return switch (Lectora.leerEnteroDeRango("Selección: ", 1 + Ejer4.TRaza.values().length, 0)) {
            case 1 -> TRaza.HUMANO;
            case 2 -> TRaza.ELFO;
            case 3 -> TRaza.ENANO;
            default -> TRaza.ORCO;
        };
    }

    private static void imprimirMenu() {
        System.out.println("""
                                
                Seleccione una opción:
                  1. Alta de personaje
                  2. Mago aprende hechizo
                  3. Mago lanza hechizo
                  4. Clérigo cura a Mago
                  5. Mostrar el listado de personajes
                  6. Mostrar el listado ordenados por vida (mayor a menor)
                  7. Salir"""
        );
    }
}
