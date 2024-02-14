package Base;

public class Planeta {
    private final int NUM_MAX_MINAS = 10;
    private final Mina[] MINAS = new Mina[NUM_MAX_MINAS];
    private int numPiedra = 5;
    private int numHierro = 4;
    private int numCombustible = 2;
    private int habitantes = 30;
    private String nombre;
    private String conquistador = null;


    private String getNombre() {
        return nombre;
    }

    private String getConquistador() {
        return conquistador;
    }

   /* @Override
    public String toString() {
        return String.format("""
                El planeta %s, %s.
                Su número de habitantes es de %d
                """, nombre, conquistador == null ? "se mantiene independiente" : "ha sido conquistado por " + conquistador,
                habitantes
        );
    }

    @Override
    public String toString() {
        return "\nEl planeta " + nombre + ", " +
                conquistador == null ? "se mantiene independiente" : "ha sido conquistado por " + conquistador +
                "\nSu número de habitantes es de " + habitantes +
                "\n"
        ;
    }*/ //TODO: toString de Base.Planeta
}
