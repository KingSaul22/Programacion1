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

    public int getNumJugadores() {
        return numJugadores;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Escudo: ").append(equipo)
                .append("\n  · Fundación: ").append(annoFundacion)
                .append("\n  · Tamaño del equipo: ").append(numJugadores);
        return sb.toString();
    }
}
