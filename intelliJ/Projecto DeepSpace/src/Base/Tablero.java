package Base;

import Enums.TMateriales;
import Excepciones.ExceptionCompraCarta;
import Excepciones.IllegalPlayerName;
import ObjCartas.CartaNave;
import ObjCartas.CartaNaveAtaque;
import ObjCartas.CartaNaveCarga;
import ObjCartas.CartaNaveTransporte;

public class Tablero {
    private final int CAPACIDAD_MAZO_NAVES = 4;
    public static final int CAPACIDAD_SISTEMA_SOLAR = 10;
    private CartaNave[] mazoNaves = new CartaNave[CAPACIDAD_MAZO_NAVES];
    private Planeta[] sistemaSolar = new Planeta[CAPACIDAD_SISTEMA_SOLAR];
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
                case 0 -> mazoNaves[i] = new CartaNaveAtaque("Ataque" + ++navesGeneradas);
                case 1 -> mazoNaves[i] = new CartaNaveTransporte("Transporte" + ++navesGeneradas);
                case 2 -> mazoNaves[i] = new CartaNaveCarga("Carga" + ++navesGeneradas);
            }
        }
    }

    public String getMazoNaves() {
        StringBuilder naves = new StringBuilder();
        for (int i = 0; i < CAPACIDAD_MAZO_NAVES; i++)
            naves.append("\n  ").append(i + 1).append(". ").append(mazoNaves[i].getNombre())
                    .append(" (").append(mazoNaves[i].getPrecio()).append(" oro)");

        return naves.toString();
    }

    public CartaNave getCartaNave(int posCarta) {
        return mazoNaves[posCarta];
    }

    public void retirarCartaMazoNaves(int posCarta) {
        byte tipoNave = (byte) (Math.random() * 3);
        switch (tipoNave) {
            case 0 -> mazoNaves[posCarta] = new CartaNaveAtaque("Ataque" + ++navesGeneradas);
            case 1 -> mazoNaves[posCarta] = new CartaNaveTransporte("Transporte" + ++navesGeneradas);
            case 2 -> mazoNaves[posCarta] = new CartaNaveCarga("Carga" + ++navesGeneradas);
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

    public Jugador getJugadorPosicion(int posicion) {
        return jugadores[posicion];
    }

    public String getPlanetasJugador(int posicion) {
        StringBuilder cadenaPlanetas = new StringBuilder("\nLista de planetas poseidos por el jugador: ").append(jugadores[posicion].getNombre());

        for (int i = 0; i < CAPACIDAD_SISTEMA_SOLAR; i++)
            if (sistemaSolar[i].getConquistador() == jugadores[posicion])
                cadenaPlanetas.append("\n  ").append(i).append(" ").append(sistemaSolar[i].toString());

        return cadenaPlanetas.toString();
    }

    public String getPlanetasTablero() {
        StringBuilder cadenaPlanetas = new StringBuilder("\nLista de planetas en el Sistema Solar: ");

        for (int i = 0; i < CAPACIDAD_SISTEMA_SOLAR; i++)
            cadenaPlanetas.append("\n  ").append(i).append(" ").append(sistemaSolar[i].toString());

        return cadenaPlanetas.toString();
    }

    public void masMaterial(TMateriales material, int posPlaneta, int posJugador) throws ExceptionCompraCarta {
        if (jugadores[posJugador] != sistemaSolar[posPlaneta].getConquistador()) {
            throw new ExceptionCompraCarta("El planeta seleccionado no te pertenece");
        }

        sistemaSolar[posPlaneta].masMaterial(material);
    }

    public void nuevaNaveOrbital(CartaNave nave, int posPlaneta, int posJugador) throws ExceptionCompraCarta {
        if (jugadores[posJugador] != sistemaSolar[posPlaneta].getConquistador()) {
            throw new ExceptionCompraCarta("El planeta seleccionado no te pertenece");
        }
        sistemaSolar[posPlaneta].nuevaNaveOrbital(nave);
    }

    public void establecerOrdenJugadores(int[] posiciones) {
        Jugador[] posicionReal = new Jugador[jugadores.length];
        for (int i = 0; i < jugadores.length; i++) posicionReal[i] = jugadores[posiciones[i]];
        jugadores = posicionReal;
    }

    public void generarPlanetas() {
        for (int i = 0; i < CAPACIDAD_SISTEMA_SOLAR; i++) {
            sistemaSolar[i] = new Planeta("Planeta " + (i + 1));
        }
    }

    public void primerPlaneta() {
        int planeta;
        for (int i = 0; i < jugadores.length; i++) {
            planeta = (int) (Math.random() * CAPACIDAD_SISTEMA_SOLAR);
            if (sistemaSolar[planeta].getConquistador() == null) {
                sistemaSolar[planeta].setConquistador(jugadores[i]);
            } else {
                i--;
            }
        }
    }
}
