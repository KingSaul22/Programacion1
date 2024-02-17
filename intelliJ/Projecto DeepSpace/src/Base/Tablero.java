package Base;

import Excepciones.IllegalPlayerName;
import ObjCartas.CartaNave;
import ObjCartas.CartaNaveAtaque;
import ObjCartas.CartaNaveCarga;
import ObjCartas.CartaNaveTransporte;

public class Tablero {
    private final int CAPACIDAD_MAZO_NAVES = 4;
    private CartaNave[] MazoNaves = new CartaNave[CAPACIDAD_MAZO_NAVES];
    private int navesGeneradas = 0;
    private Jugador[] jugadores;

    public Tablero(int numJugadores) {
        this.jugadores = new Jugador[numJugadores];
        generarMazoNaves();
    }

    private void generarMazoNaves() {
        byte tipoNave;
        for (byte i = 0; i < CAPACIDAD_MAZO_NAVES; i++) {
            tipoNave = (byte) (Math.random() * 3);
            switch (tipoNave) {
                case 0 -> MazoNaves[i] = new CartaNaveAtaque("Ataque" + ++navesGeneradas);
                case 1 -> MazoNaves[i] = new CartaNaveTransporte("Ataque" + ++navesGeneradas);
                case 2 -> MazoNaves[i] = new CartaNaveCarga("Ataque" + ++navesGeneradas);
            }
        }
    }

    public void newPlayer(Jugador jugador) throws IllegalPlayerName {
        for (byte i = 0; i < jugadores.length; i++) {
            if (jugadores[i].getNombre().equals(jugador.getNombre())) {
                throw new IllegalPlayerName("El nombre del jugador ya está ocupado");
            }
            if (jugadores[i] == null) {
                jugadores[i] = jugador;
                break;
            }
        }
    }
}
