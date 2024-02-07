package Ejer4;

import EntradaSalida.Lectora;

import java.util.Arrays;

import static java.lang.Character.toUpperCase;

public class Main {
    private static final Personaje[] personajes = new Personaje[100];
    private static final int[] vidaPersonajes = new int[100];
    private static final int[] indiceVidaPJ = new int[100];
    private static byte numPersonajes = 0;

    public static void main(String[] args) {
        for (int i = 0; i < indiceVidaPJ.length; i++) indiceVidaPJ[i] = i;

        byte opcion;
        do {
            imprimirMenu();
            opcion = Lectora.leerSeleccionDeRango("Selección: ", 8, 0);

            switch (opcion) {
                case 1 -> altaPersonaje();
                case 2 -> magoAprende();
                case 3 -> magoOlvida();
                case 4 -> clerigoCura();
                case 5 -> imprimirPersonajes();
                case 6 -> imprimirPersonajesOrdenados();
            }

        } while (opcion != 7);
        /*Mago a = null, b = null;
        Clerigo c = null;

        try {
            a = new Mago(selectNombre(), selectRaza(), 15, 20, 100);
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        try {
            b = new Mago("Rodolfo", selectRaza(), 12, 19, 76);
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        try {
            c = new Clerigo("Rodolfa", b.getRaza(), 20, 15, 70, "Pepe");
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        try {
            a.aprendeHechizo(selectNombre());
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        try {
            a.aprendeHechizo(selectNombre());
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        try {
            b.aprendeHechizo(selectNombre());
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(a);
        System.out.println(b);

        try {
            a.lanzaHechizo(selectNombre(), b);
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        try {
            b.lanzaHechizo(selectNombre(), a);
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        try {
            c.lanzaCuracion(b);
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        try {
            a.lanzaHechizo(selectNombre(), b);
        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);*/
    }

    private static void imprimirMenu() {
        System.out.println("""
                                
                Escoge una opción:
                  1. Alta de personaje
                  2. Mago aprende hechizo
                  3. Mago lanza hechizo
                  4. Clérigo cura a Mago
                  5. Mostrar el listado de personajes
                  6. Mostrar el listado de personajes ordenados por puntos actuales de mayor a menor
                  7. Salir
                """
        );
    }

    private static void altaPersonaje() {
        System.out.println("""
                                
                Seleccione la profesión de su personaje:
                  1. Mago
                  2. Clérigo
                  """
        );

        if (1 == Lectora.leerSeleccionDeRango("Selección: ", 3, 0)) {

            try {
                personajes[numPersonajes++] = new Mago(selectNombre(), selectRaza(),
                        Lectora.leerEnteroPositivo("Introduzca el nivel de fuerza"),
                        Lectora.leerEnteroPositivo("Introduzca el nivel de inteligencia"),
                        Lectora.leerEnteroPositivo("Introduzca el nivel de vida máxima")
                );
                vidaPersonajes[numPersonajes - 1] = personajes[numPersonajes - 1].getVidaActual();
            } catch (PersonajeException e) {
                System.out.println(e.getMessage());
                numPersonajes--;
            }

        } else {

            try {
                personajes[numPersonajes++] = new Clerigo(selectNombre(), selectRaza(),
                        Lectora.leerEnteroPositivo("Introduzca el nivel de fuerza"),
                        Lectora.leerEnteroPositivo("Introduzca el nivel de inteligencia"),
                        Lectora.leerEnteroPositivo("Introduzca el nivel de vida máxima"),
                        selectNombre()
                );
                vidaPersonajes[numPersonajes - 1] = personajes[numPersonajes - 1].getVidaActual();
            } catch (PersonajeException e) {
                System.out.println(e.getMessage());
                numPersonajes--;
            }
        }
    }

    private static void magoAprende() {
        String nombre = selectNombre();
        int pj = -1;

        for (int i = 0; i < numPersonajes; i++) {
            if (nombre.equals(personajes[i].getNombre())) {
                pj = i;
                break;
            }
        }

        if (pj == -1) {
            System.out.println("El personaje introducido no existe.");

        } else if (personajes[pj] instanceof Clerigo) {
            System.out.println("El personaje seleccionado no puede aprender un hechizo, es un Clérigo.");

        } else {
            Mago mago = (Mago) personajes[pj];

            try {
                mago.aprendeHechizo(selectNombre());
                personajes[pj] = mago;
            } catch (PersonajeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void magoOlvida() {
        String nombre = selectNombre();
        int pj1 = -1;

        for (int i = 0; i < numPersonajes; i++) {
            if (nombre.equals(personajes[i].getNombre())) {
                pj1 = i;
                break;
            }
        }

        if (pj1 == -1) {
            System.out.println("El personaje introducido no existe.");

        } else if (personajes[pj1] instanceof Clerigo) {
            System.out.println("El personaje seleccionado no puede tiene hechizos, es un Clérigo.");

        } else {
            Mago mago = (Mago) personajes[pj1];

            System.out.println("Selecciona el personaje victima del hechizo.");

            nombre = selectNombre();
            int pj2 = -1;

            for (int i = 0; i < numPersonajes; i++) {
                if (nombre.equals(personajes[i].getNombre())) {
                    pj2 = i;
                    break;
                }
            }

            if (pj2 == -1) {
                System.out.println("El personaje especificado no existe");
            } else {
                try {
                    mago.lanzaHechizo(selectNombre(), personajes[pj2]);
                    personajes[pj1] = mago;
                    vidaPersonajes[pj2] = personajes[pj2].getVidaActual();
                } catch (PersonajeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private static void clerigoCura() {
        String nombre = selectNombre();
        int pj = -1;

        for (int i = 0; i < numPersonajes; i++) {
            if (nombre.equals(personajes[i].getNombre())) {
                pj = i;
                break;
            }
        }

        if (pj == -1) {
            System.out.println("El personaje introducido no existe.");

        } else if (personajes[pj] instanceof Mago) {
            System.out.println("El personaje seleccionado no puede curar, es un Mago.");

        } else {
            Clerigo clerigo = (Clerigo) personajes[pj];

            System.out.println("Selecciona el personaje que recibirá la curación.");

            nombre = selectNombre();
            pj = -1;

            for (int i = 0; i < numPersonajes; i++) {
                if (nombre.equals(personajes[i].getNombre())) {
                    pj = i;
                    break;
                }
            }

            if (pj == -1) {
                System.out.println("El personaje especificado no existe");

            } else if (personajes[pj] instanceof Clerigo) {
                System.out.println("El personaje especificado no puede recibir curaciones, es un clerigo");

            } else {
                try {
                    clerigo.lanzaCuracion(personajes[pj]);
                    vidaPersonajes[pj] = personajes[pj].getVidaActual();
                } catch (PersonajeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private static void imprimirPersonajes() {
        System.out.println("La lista de personajes existentes:");
        for (int i = 0; i < numPersonajes; i++) {
            System.out.println(personajes[i]);
        }
    }

    private static void imprimirPersonajesOrdenados() {
        System.out.println("La lista de personajes existentes, ordenados segun sus puntos de vida actuales:");
        /*
        TODO: imprimirPersonajesOrdenados()
        Tengo un array con la vida de los personajes y uno con los indices.
        El objetivo es ordenar el de los indices e imprimir los personajes siguiendo el orden de esos indices
        */
        /*
        Arrays.sort(indiceVidaPJ, (a, b) -> Integer.compare(vidaPersonajes[b], vidaPersonajes[a]));
        https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/util/Arrays.html#sort(T%5B%5D,int,int,java.util.Comparator)
        for (int i = 0; i < numPersonajes; i++) {
            System.out.println(personajes[indiceVidaPJ[i]]);
        }
        */

        boolean[] imprimidoPJ = new boolean[numPersonajes];
        int imprimir;
        for (int i = 0; i < numPersonajes; i++) {
            imprimir = 0;
            for (int j = i; j < numPersonajes && !imprimidoPJ[i]; j++) {

                if ((j != i && !imprimidoPJ[j])) {


                }
            }
            if (!imprimidoPJ[i]) {
                System.out.println(personajes[i]);
                imprimidoPJ[i] = true;
            }
        }
    }

    private static String selectNombre() {
        String nombre = Lectora.solicitarCadenaMinus("Escriba el nombre deseado: ").trim();

        while (nombre.isBlank() || nombre.length() > 15) {
            nombre = Lectora.solicitarCadenaMinus("Escriba un nombre valido e inferior en longitud a 15 caracteres: ").trim();
        }

        return nombre.replaceFirst(String.valueOf(nombre.charAt(0)), String.valueOf(toUpperCase(nombre.charAt(0))));
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

        return switch (Lectora.leerEnteroDeRango("Selección: ", 1 + TRaza.values().length, 0)) {
            case 1 -> TRaza.HUMANO;
            case 2 -> TRaza.ELFO;
            case 3 -> TRaza.ENANO;
            default -> TRaza.ORCO;
        };
    }

}
