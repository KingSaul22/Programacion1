package Base;

import Enums.TMateriales;
import Excepciones.ExceptionCompraCarta;
import Interfaces.Atacable;
import ObjCartas.CartaConstrEscudo;
import ObjCartas.CartaConstrMina;
import ObjCartas.CartaNave;

import javax.swing.plaf.PanelUI;

/**
 * Clase Planeta
 */
public class Planeta implements Atacable {
    private final int NUM_MAX_MINAS = 10;
    private final int MAX_NAVES_ORBITALES = 100;
    private final CartaConstrMina[] MINAS = new CartaConstrMina[NUM_MAX_MINAS];
    private CartaNave[] mazoCavesOrbitales = new CartaNave[MAX_NAVES_ORBITALES];
    private int navesOrbitales = 0;
    private CartaConstrEscudo escudo = null;
    private int numPiedra = 5;
    private int numHierro = 4;
    private int numCombustible = 2;
    private int habitantes = 30;
    private String nombre;
    private Jugador conquistador = null;

    public Planeta(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Jugador getConquistador() {
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

    public void nuevaNaveOrbital(CartaNave nave) throws ExceptionCompraCarta {
        if (navesOrbitales == 100) throw new ExceptionCompraCarta("El planeta elegido no tiene espacio para orbitar");

        for (int i = 0; i < MAX_NAVES_ORBITALES; i++) {
            if (mazoCavesOrbitales[i] == null){
                mazoCavesOrbitales[i] = nave;
                navesOrbitales++;
                break;
            }
        }
    }

    public void despedidaNaveOrbital() {
        navesOrbitales--;
    }

    public void setConquistador(Jugador conquistador) {
        this.conquistador = conquistador;
    }


    /**
     * Añadira una carta de mina al planeta
     *
     * @param mina Acepta una carta de mina
     * @throws ExceptionCompraCarta En caso de no haber espacios para minas
     */
    public void newMina(CartaConstrMina mina) throws ExceptionCompraCarta {
        boolean incluida = false;

        for (int i = 0; i < NUM_MAX_MINAS; i++) {
            if (MINAS[i] == null) {
                MINAS[i] = mina;
                incluida = true;
                break;
            }
        }
        if (!incluida) throw new ExceptionCompraCarta("No se pueden crear más minas en este planeta");
    }

    /**
     * Método que añade materiales al {@link Planeta planeta}.
     *
     * @param material material que se añadirá al planeta
     */
    public void masMaterial(TMateriales material) {
        switch (material) {
            case PIEDRA -> numPiedra++;
            case HIERRO -> numHierro++;
            case COMBUSTIBLE -> numCombustible++;
        }
    }

    @Override
    public String toString() {
        return "\nEl planeta " + nombre + ", " +
                (conquistador == null ? "se mantiene independiente." : ("ha sido conquistado por " + conquistador.getNombre() + ".")) +
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
