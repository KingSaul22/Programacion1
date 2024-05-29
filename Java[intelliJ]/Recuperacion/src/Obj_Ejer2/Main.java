package Obj_Ejer2;

import Obj_Ejer2.Enums.TAnimales;
import Obj_Ejer2.Enums.TProductos;
import Obj_Ejer2.Enums.TSalud;
import Obj_Ejer2.Excepciones.GranjaException;
import Obj_Ejer2.Model.Alimentacion;
import Obj_Ejer2.Model.Animal;
import Obj_Ejer2.Model.Granja;
import Obj_Ejer2.Model.Producto;
import utils.MiEntradaSalida;

import java.util.List;

public class Main {
    private static Granja granja;

    public static void main(String[] args) {
        granja = new Granja("Patrocinio");
        int opcion;
        do {
            mostrarMenu();
            opcion = MiEntradaSalida.leerEnteroDeRango("Selección", 1, 9);
            switch (opcion) {
                case 1:
                    nuevoAnimal();
                    break;
                case 2:
                    alimentarAnimal();
                    break;
                case 3:
                    chequearAnimal();
                    break;
                case 4:
                    listarSaludAnimales();
                    break;
                case 5:
                    nuevoProducto();
                    break;
                case 6:
                    reponerProducto();
                    break;
                case 7:
                    venderProducto();
                    break;
                case 8:
                    mostrarProductos();
                    break;

            }
        } while (opcion != 9);

        System.out.println("\nGracias por pasarte por aquí.");
    }

    private static void nuevoAnimal() {
        TAnimales tipoAnimal = MiEntradaSalida.leerEnum("Seleccione el tipo de animal", TAnimales.values());
        int edad = MiEntradaSalida.leerEnteroPositivo("Edad del animal");
        try {
            granja.aniadirAnimal(tipoAnimal, edad);
            System.out.println("Animal añadido correctamente");
        } catch (GranjaException e) {
            System.out.println("No se ha añadido el animal.\n" + e.getMessage());
        }
    }

    private static void alimentarAnimal() {
        int seleccionAnimal = seleccionarIdAnimal();
        System.out.println("Escoja la alimentación del animal.");
        Alimentacion.TAlimentacion tipoAlimentacion = MiEntradaSalida.leerEnum("Selección", Alimentacion.TAlimentacion.values());

        granja.alimentarAnimal(tipoAlimentacion, seleccionAnimal);
    }

    private static void chequearAnimal() {
        int seleccionAnimal = seleccionarIdAnimal();
        System.out.println("Introduzca la salud del animal.");
        TSalud estadoSalud = MiEntradaSalida.leerEnum("Selección", TSalud.values());

        granja.chequearAnimal(estadoSalud, seleccionAnimal);
    }

    private static void listarSaludAnimales() {
        System.out.println("Listado de los animales y su salud");
        granja.getAnimales().forEach(animal -> System.out.println(
                "  · ID: " + animal.getId() + " -> SALUD: " + animal.getId()));
    }

    private static void mostrarListadoAnimales(List<Animal> animales) {
        System.out.println("Listado de los animales:");
        for (int i = 0; i < animales.size(); i++) {
            System.out.println((i + 1) + ". " + animales.get(i));
        }
    }

    private static int seleccionarIdAnimal() {
        List<Animal> animales = granja.getAnimales();
        mostrarListadoAnimales(animales);
        return MiEntradaSalida.leerEnteroDeRango("Selección", 1, animales.size());
    }

    private static void nuevoProducto() {
        TProductos tipoProducto = MiEntradaSalida.leerEnum("Tipo de producto", TProductos.values());
        String nombre = MiEntradaSalida.leerCadena("Nombre del producto");
        double precio = MiEntradaSalida.leerDoublePositivo("Precio del producto");
        int cantidadBase = MiEntradaSalida.leerEnteroPositivo("Cantidad inicial del producto");

        try {
            granja.registrarProducto(nombre, precio, cantidadBase, tipoProducto);
        } catch (GranjaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void reponerProducto() {
        List<Producto> productos = granja.getProductos();
        mostrarListadoProductos(productos);
        Producto seleccionProducto = productos.get(
                MiEntradaSalida.leerEnteroDeRango("Selección", 1, productos.size()) - 1);
        int cantidad = MiEntradaSalida.leerEnteroPositivo("Cantidad de unidades a añadir");

        try {
            granja.reponerStockProducto(seleccionProducto, cantidad);
        } catch (GranjaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void venderProducto() {
        List<Producto> productos = granja.getProductosDisponibles();
        mostrarListadoProductos(productos);
        Producto seleccionProducto = productos.get(
                MiEntradaSalida.leerEnteroDeRango("Selección", 1, productos.size()) - 1);
        int cantidad = MiEntradaSalida.leerEnteroPositivo("Cantidad de unidades a vender");

        try {
            granja.venderProducto(seleccionProducto, cantidad);
        } catch (GranjaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarProductos() {
        System.out.println("Productos de la granja " + granja.getNombre() + ":");
        for (Producto producto : granja.getProductos()) System.out.println(producto);
    }

    private static void mostrarListadoProductos(List<Producto> productos) {
        System.out.println("Listado de los productos");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i));
        }
    }

    private static void mostrarMenu() {
        System.out.printf("""
                Opciones de la granja %s
                  1. Añadir Animal
                  2. Alimentar Animal
                  3. Realizar Chequeo
                  4. Listar la salud de los animales
                  5. Añadir Producto
                  6. Reponer Producto
                  7. Vender Producto
                  8. Listar todos los productos
                  9. Salir
                """, granja.getNombre());
    }
}
