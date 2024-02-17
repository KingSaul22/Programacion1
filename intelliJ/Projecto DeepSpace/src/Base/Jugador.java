package Base;

import ObjCartas.CartaConstruccion;

public class Jugador {
    private String nombre;
    private Planeta[] planetas;
    private CartaConstruccion[] construcciones;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
