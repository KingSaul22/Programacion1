package Ejer2;

import EntradaSalida.Lectora;

public class MenuVehiculo {
    private static final int MAX_VEHICULOS = 200;
    private static final Vehiculo[] listaVehiculos = new Vehiculo[MAX_VEHICULOS];

    public static void main(String[] args) {

        int opcion;

        do {
            imprimirMenu();
            opcion = Lectora.leerEnteroDeRango("", 4, 1);

            switch (opcion) {
                case 1:
                    darAltaVehiculo();

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

            }

        } while (opcion != 4);
    }

    private static void imprimirMenu() {
        System.out.println("""
                                
                Escoge una opción:
                  1. Alta de Vehículo
                  2. Cálculo de precio de alquiler
                  3. Listar todos los vehículos
                  4. Salir""");
    }

    private static void darAltaVehiculo() {
        int seleccionUsuario;
        System.out.println("Estos son los vehículos disponibles:");

        int opcion = 0;
        for (TipoVehiculo t : TipoVehiculo.values()) {
            System.out.println(" "+ ++opcion + ". " + String.valueOf(t).toLowerCase());
        }

        seleccionUsuario = Lectora.leerEnteroDeRango("Selección: ",TipoVehiculo.values().length, 1);

        switch (seleccionUsuario) {
            case 1:

                break;

            case 2:

                break;

            case 3:

        }
    }

}
