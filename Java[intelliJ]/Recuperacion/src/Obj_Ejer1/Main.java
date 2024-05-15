package Obj_Ejer1;

import Obj_Ejer1.Enums.TFamilia;
import Obj_Ejer1.Excepciones.TiendaException;
import Obj_Ejer1.Model.Tienda;
import utils.MiEntradaSalida;

public class Main {
    private static Tienda tienda;

    public static void main(String[] args) {
        tienda = new Tienda("Nintendo");
    }

    private static void crearCliente() {
        try {
            tienda.nuevoCliente(MiEntradaSalida.leerCadena("Introduzca el nombre del cliente"));
        } catch (TiendaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void crearMascota() {
        TFamilia familia = MiEntradaSalida.leerEnum("Seleccione tipo de mascota:", TFamilia.values());
        int edad = MiEntradaSalida.leerEnteroPositivo("Edad de la mascota");
        double precio = MiEntradaSalida.leerDoublePositivo("Introduzca el precio");
        try {
            tienda.nuevaMascota(MiEntradaSalida.leerCadena("Introduzca el nombre de la mascota"),
                    familia, edad, precio,
                    MiEntradaSalida.leerSN("¿Esta disponible para la venta?") == 'S');
        } catch (TiendaException e) {
            System.out.println(e.getMessage());
        }
    }
}
