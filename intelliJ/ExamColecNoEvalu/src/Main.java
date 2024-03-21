import Excepciones.RestauranteException;
import Model.Receta;
import Model.Restaurante;
import utils.MiEntradaSalida;

import java.util.Iterator;

public class Main {
    public static final String TOKEN_FINALIZACION = "fin";

    public static void main(String[] args) {
        Restaurante r = new Restaurante("Patrocinio");

        try {
            Receta a = new Receta("Azucar", 12);
            a.addPaso("Verter azucar en el bote para guardar azucar");
            a.addIngrediente("azucar", 100);
            r.incluirReceta(a);

            Receta b = new Receta("Sal", 20);
            b.addPaso("Verter sal en un vaso con agua");
            b.addPaso("Dejar que el agua se evapore");
            b.addPaso("Recoger en un bote la sal que obtenemos al evaporar el agua salada");
            b.addIngrediente("sal", 100);
            b.addIngrediente("agua", 1000);
            r.incluirReceta(b);

            Receta c = new Receta("Cerveza", 112);
            c.addPaso("Comprar cerveza");
            c.addPaso("Sentarte frente a la televisión");
            c.addPaso("Poner la Formula 1");
            c.addPaso("Beber cerveza");
            c.addPaso("Lamentarte de que gane siempre Max");
            c.addPaso("Llorar");
            c.addIngrediente("cerveza", 12);
            c.addIngrediente("pañuelos", 24);
            r.incluirReceta(c);

            Receta d = new Receta("El plan", 200);
            d.addPaso("Unirse a Alpine");
            d.addPaso("Ver el panorama");
            d.addPaso("Pegarle una colleja a Ocon");
            d.addPaso("Ir de vacaciones a Galicia");
            d.addPaso("Dejar Alpine");
            d.addIngrediente("talento", 10);
            d.addIngrediente("juventud", 90);
            r.incluirReceta(d);

            Receta e = new Receta("La mision", 2000);
            e.addPaso("Unirse a Aston Marin");
            e.addPaso("Ver el panorama");
            e.addPaso("Pegarle una colleja a Ocon");
            e.addPaso("Ir de vacaciones al simulador");
            e.addPaso("Dej...");
            e.addIngrediente("talento", 12);
            e.addIngrediente("juventud", 88);
            r.incluirReceta(e);

            r.masIngrediente("talento", 20);
            r.masIngrediente("juventud", 200);

            for (Receta plato : r.listaRecetasDisponibles()) System.out.println(plato);

        } catch (RestauranteException e) {
            System.out.println(e.getMessage());
        }


        int option;
        do {
            imprimirSelector();
            option = MiEntradaSalida.leerEnteroDeRango("Selección", 1, 8);
            switch (option) {
                case 1://Añadir Receta
                    r.incluirReceta(nuevaReceta());
                    break;
                case 2://Buscar Receta
                    try {
                        String receta = MiEntradaSalida.leerCadena("Introduzca el nombre de la receta");
                        if (r.recetaDisponible(receta)) {
                            System.out.println("La receta '" + receta + "' está disponible para cocinarse");
                        } else {
                            System.out.println("La receta '" + receta + "' no está disponible");
                        }
                    } catch (RestauranteException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3://Buscar receta
                    try {
                        Receta receta = r.getRecetaConcreta(MiEntradaSalida.leerCadena("Introduzca el nombre de la receta"));
                        boolean alfab = MiEntradaSalida.leerSN("¿Orden Alfabético? (s/n)") == 'S';
                        System.out.println(receta.imiprimirConOrden(alfab));
                    } catch (RestauranteException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4://Eliminar Paso
                    try {
                        Receta plato = r.getRecetaConcreta(MiEntradaSalida.leerCadena("Introduzca el nombre de la receta"));

                        int i = 0;
                        Iterator<String> it = plato.getPasos().iterator();
                        while (it.hasNext()) {
                            String paso = it.next();
                            System.out.printf("Paso número %d\n%s\n", ++i, paso);
                            if (MiEntradaSalida.leerSN("¿Desea borrar este paso? (s/n)") == 'S') it.remove();
                        }
                    } catch (RestauranteException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5://Recetas disponibles
                    try {
                        r.listaRecetasDisponibles().forEach(System.out::println);
                    } catch (RestauranteException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6://Comprar ingrediente
                    r.masIngrediente(
                            MiEntradaSalida.leerCadena("Introduzca el nombre del ingrediente"),
                            MiEntradaSalida.leerEnteroPositivo("Introduzca la cantidad comprada")
                    );
                    break;
                case 7://Añadir Pedido

            }

        } while (option != 8);
        System.out.println("Buenas noches, hasta mañana");
    }

    private static Receta nuevaReceta() {
        String nombre = MiEntradaSalida.leerCadena("Nombre de la receta");
        double duracion = MiEntradaSalida.leerDoublePositivo("Duración de la receta");
        Receta plato = new Receta(nombre, duracion);

        String cadena;
        int cantidad;
        do {
            cadena = MiEntradaSalida.leerCadena("Introduce el nombre del ingrediente");
            if (!cadena.equals(TOKEN_FINALIZACION)) {
                cantidad = MiEntradaSalida.leerEnteroPositivo("Introduzca la cantidad del ingrediente");
                plato.addIngrediente(cadena, cantidad);
            }
        } while (!cadena.equals(TOKEN_FINALIZACION));

        do {
            cadena = MiEntradaSalida.leerCadena("Introduce el paso a seguir");
            if (!cadena.equals(TOKEN_FINALIZACION)) {
                plato.addPaso(cadena);
            }
        } while (!cadena.equals(TOKEN_FINALIZACION));

        return plato;
    }

    private static void imprimirSelector() {
        System.out.println("""
                                
                Seleccione una opción:
                  1. Añadir Receta
                  2. Buscar Receta
                  3. Información sobre una Receta
                  4. Eliminar un Paso
                  5. Recetas posibles
                  6. Comprar Ingrediente
                  7. Añadir plato del cliente
                  8. Consumir plato
                  9. Salir""");
    }
}
