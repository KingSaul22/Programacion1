package Model;

public class Jugador extends Cromo {
    private String nombre;
    private String equipo; //TODO[DUDA]: ¿Por qué no Equipo equipo ?
    private int altura;

    public Jugador(String id, String nombre, String equipo, int altura) {
        super(id);
        this.nombre = nombre;
        this.equipo = equipo;
        this.altura = altura;
    }

    @Override
    public String getEquipo() {
        return equipo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public int getAltura() {
        return altura;
    }
}
