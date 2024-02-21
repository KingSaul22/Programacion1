package Ejer4b;

import Ejer4b.Modelo.Personaje;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Personaje> personajes = new ArrayList<>();

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

    }

    private static void magoAprende() {

    }

    private static void magoLanza() {

    }

    private static void clerigoCura() {
    }

    private static void listadoPersonajes() {
    }

    private static void listadoPersonajesMayorVida() {
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
