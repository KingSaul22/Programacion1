import utils.MiEntradaSalida;

public class Main {
    public static void main(String[] args) {

    }

    private static void nuevaReceta() {
        String nombre = MiEntradaSalida.leerCadena("Nombre de la receta");
        double duracion = MiEntradaSalida.leerDoublePositivo("Duración de la receta");
    }
}
