import Model.Receta;
import Model.Restaurante;
import utils.MiEntradaSalida;

public class Main {
    public static final String TOKEN_FINALIZACION = "fin";
    public static void main(String[] args) {
        Restaurante r = new Restaurante();

    }

    private static void nuevaReceta() {
        String nombre = MiEntradaSalida.leerCadena("Nombre de la receta");
        double duracion = MiEntradaSalida.leerDoublePositivo("Duración de la receta");
        Receta plato = new Receta(nombre, duracion);

        String cadena = null;
        int cantidad;
        do {
            cadena = MiEntradaSalida.leerCadena("Introduce el nombre del ingrediente");
            if (!cadena.equals(TOKEN_FINALIZACION)) {
                cantidad = MiEntradaSalida.leerEnteroPositivo("Introduzca la cantidad del ingrediente");
                plato.addIngrediente(cadena, cantidad);
            }
        } while(!cadena.equals(TOKEN_FINALIZACION));

        do {
            cadena = MiEntradaSalida.leerCadena("Introduce el paso a seguir");
            if (!cadena.equals(TOKEN_FINALIZACION)) {
                plato.addPaso(cadena);
            }
        } while(!cadena.equals(TOKEN_FINALIZACION));

        //TODO: Añadir la Receta al Menu del Restaurante
    }
}
