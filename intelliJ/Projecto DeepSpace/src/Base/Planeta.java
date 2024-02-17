package Base;

import Interfaces.Atacable;
import ObjCartas.CartaConstrEscudo;
import ObjCartas.CartaConstrMina;

import javax.swing.plaf.PanelUI;

public class Planeta implements Atacable {
    private final int NUM_MAX_MINAS = 10;
    private final CartaConstrMina[] MINAS = new CartaConstrMina[NUM_MAX_MINAS];
    private CartaConstrEscudo escudo = null;
    private int numPiedra = 5;
    private int numHierro = 4;
    private int numCombustible = 2;
    private int habitantes = 30;
    private int navesOrbitales = 0;
    private String nombre;
    private String conquistador = null;


    private String getNombre() {
        return nombre;
    }

    private String getConquistador() {
        return conquistador;
    }

    @Override
    public void serAtacado(int damage) {

    }

    @Override
    public int getPuntosDefensa() {
        return 0;
    }

    public int getNavesOrbitales() {
        return navesOrbitales;
    }

    public void nuevaNaveOrbital() {
        navesOrbitales++;
    }

    public void despedidaNaveOrbital() {
        navesOrbitales--;
    }

    public void setConquistador(String conquistador) {
        this.conquistador = conquistador;
    }

    /* @Override
    public String toString() {
        return String.format("""
                El planeta %s, %s.
                Su número de habitantes es de %d
                """, nombre, conquistador == null ? "se mantiene independiente" : "ha sido conquistado por " + conquistador,
                habitantes
        );
    }*/


    @Override
    public String toString() {
        return "\nEl planeta " + nombre + ", " +
                (conquistador == null ? "se mantiene independiente." : ("ha sido conquistado por " + conquistador + ".")) +
                "\nSu número de habitantes es de " + habitantes +
                "\nEl planeta cuenta con las siguientes materias primas:\n  Unidades de piedra: " + numPiedra +
                "\n  Unidades de hierro: " + numHierro + "\n  Unidades de combustible: " + numCombustible +
                "\nEl planeta dispone de las siguientes minas:\n" + imprimirMinas() +
                (escudo == null ? ("\nEl paneta no dispone de escudo.") :
                        ("El planeta dispone de un escudo con " + escudo.getDefensa() + " puntos de defensa."))
                ;
    }

    private String imprimirMinas() {
        StringBuilder minas = new StringBuilder();

        for (int i = 0; i < NUM_MAX_MINAS; i++) {
            if (MINAS[i] == null) break;

            minas.append("\n  La mina número ").append(i).append(" es de tipo ").append(MINAS[i].getMateriaExtraida())
                    .append(".\n  Extrae por turno una cantidad de ").append(MINAS[i].getMinadoTurno()).append(" unidades.\n")
            ;
        }

        return minas.toString();
    }
}
