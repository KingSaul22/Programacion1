package Ejer2;

import EntradaSalida.Lectora;

public class MenuVehiculo {
    private static final int MAX_VEHICULOS = 200;
    private static final Vehiculo[] listaVehiculos = new Vehiculo[MAX_VEHICULOS];
    private static int vehiculosAlta = 0;

    public static void main(String[] args) {
        int opcion;

        do {
            imprimirMenu();
            opcion = Lectora.leerEnteroDeRango("Selección: ", 5, 0);

            switch (opcion) {
                case 1 -> darAltaVehiculo();
                case 2 -> calculoPrecio();
                case 3 -> listarVehiculos();
                default -> System.out.println("Felices sueños");
            }

        } while (opcion != 4);
    }

    private static void imprimirMenu() {
        System.out.println("""
                                
                Escoge una opción:
                  1. Alta de Vehículo
                  2. Cálculo de precio de alquiler
                  3. Listar todos los vehículos
                  4. Salir"""
        );
    }

    private static void darAltaVehiculo() {
        int seleccionUsuario;
        System.out.println("\nEstos son los vehículos disponibles:");

        int opcion = 0;
        for (TipoVehiculo t : TipoVehiculo.values()) {
            System.out.println(" " + ++opcion + ". " + String.valueOf(t).toLowerCase());
        }

        seleccionUsuario = Lectora.leerEnteroDeRango("Selección: ", 1 + TipoVehiculo.values().length, 0);

        switch (seleccionUsuario) {
            case 1:
                listaVehiculos[vehiculosAlta++] = new Coche(setMatricula(), setGama(), setCombustible());
                break;

            case 2:
                try {
                    listaVehiculos[vehiculosAlta++] = new Microbus(setMatricula(), setGama(), setPlazas());
                } catch (VehiculoException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 3:
                try {
                    listaVehiculos[vehiculosAlta++] = new Furgoneta(setMatricula(), setGama(), setPma());
                } catch (VehiculoException e) {
                    System.out.println(e.getMessage());
                }
        }
    }

    private static void calculoPrecio() {
        int posVehiculo;

        String matricula = Lectora.solicitarCadenaMayus("Introduzca la matrícula del vehículo: ");
        int dias = Lectora.leerEnteroDeRango("Introduzca el número de días alquilado", 365, 1);

        for (posVehiculo = 0; posVehiculo < vehiculosAlta; posVehiculo++) {

            if (listaVehiculos[posVehiculo].getMatricula().equals(matricula)) break;
        }

        if (posVehiculo != vehiculosAlta) {
            System.out.printf("""
                                    
                    El vehículo seleccionado con matricula: %s
                    y tras ser usado por %d dias;
                    conlleva un precio total de %.2f€
                    """, matricula, dias, listaVehiculos[posVehiculo].getPrecioAlquiler(dias)
            );
        } else {
            System.out.println("Su matricula no ha sido detectada");
        }
    }

    private static void listarVehiculos() {

        for (int i = 0; i < vehiculosAlta; i++) {

            System.out.println(listaVehiculos[i]);
        }

    }

    private static String setMatricula() {
        //TODO: Comprobar si existe la matricula.
        return Lectora.solicitarCadenaMayus("\nIntroduzca la matricula:");
    }

    private static Gama setGama() {
        System.out.print("""
                                
                Introduzca la gama de su vehículo:
                  1. Baja
                  2. Media
                  3. Alta
                """
        );

        return switch (Lectora.leerEnteroDeRango("Selección: ", 1 + Gama.values().length, 0)) {
            case 1 -> Gama.BAJA;
            case 2 -> Gama.MEDIA;
            default -> Gama.ALTA;
        };
    }

    private static Combustible setCombustible() {
        System.out.print("""
                                
                Introduzca el combustible de su vehículo:
                  1. Diesel
                  2. Gasolina
                """
        );

        return switch (Lectora.leerEnteroDeRango("Selección: ", 1 + Combustible.values().length, 0)) {
            case 1 -> Combustible.DIESEL;
            default -> Combustible.GASOLINA;
        };

        /*if (Lectora.leerEnteroDeRango("Selección: ", Combustible.values().length, 1) == 1) {
            return Combustible.DIESEL;
        }
        return Combustible.GASOLINA;*/
    }

    private static int setPlazas() {

        return Lectora.leerEnteroDeRango("Introduzca el número de plazas: ", Integer.MAX_VALUE, 1);
    }

    private static int setPma() {

        return Lectora.leerEnteroDeRango("Introduzca el Peso Máximo Permitido: ", Integer.MAX_VALUE, 300);
    }
}
