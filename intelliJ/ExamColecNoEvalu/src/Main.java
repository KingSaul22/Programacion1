import Excepciones.RestauranteException;
import Model.Receta;
import Model.Restaurante;
import utils.MiEntradaSalida;

public class Main {
    public static final String TOKEN_FINALIZACION = "fin";

    public static void main(String[] args) {
        Restaurante r = new Restaurante("Patrocinio");

        int option;
        do {
            imprimirSelector();
            option = MiEntradaSalida.leerEnteroDeRango("Selección", 1, 7);
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
                case 3://Recetas disponibles
                    try {
                        Receta receta = r.getRecetaConcreta(MiEntradaSalida.leerCadena("Introduzca el nombre de la receta"));
                        System.out.println(receta);
                    } catch (RestauranteException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4://TODO: Eliminar Paso

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
            }

        } while (option != 7);
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
                  7. Salir""");
    }
}
