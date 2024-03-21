package Model;

public class Escudo extends Cromo {
    private String equipo;
    private int annoFundacion;
    private int numJugadores;

    public Escudo(String id, String equipo, int annoFunndacion, int numJugadores) {
        super(id);
        this.equipo = equipo;
        this.annoFundacion = annoFunndacion;
        this.numJugadores = numJugadores;
    }

    public String getEquipo() {
        return getNombre();
    }

    @Override
    public String getNombre() {
        return equipo;
    }
}
