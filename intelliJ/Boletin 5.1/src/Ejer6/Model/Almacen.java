package Ejer6.Model;

import Ejer6.Excepciones.CajaException;

public class Almacen {
    private static final int NUM_DE_CAJAS = 20;
    private Caja[] cajas;
    private int cantidadClientes = 0;

    public Almacen() {
        cajas = new Caja[NUM_DE_CAJAS];
        for (int i = 0; i < NUM_DE_CAJAS; i++) {
            cajas[i] = new Caja(i + 1);
        }
    }

    /**
     * Método que compara el número de clientes entre cajas y busca la más vacía
     * @return La pocición de la caja con menos clientes.
     * @throws CajaException Cuando no hay {@link Caja cajas} abiertas.
     */
    private int cajaMasVacia() throws CajaException {
        int numCaja = -1;

        for (int i = 0; i < NUM_DE_CAJAS; i++) {
            if (cajas[i].isActiva()) {
                numCaja = i;
                break;
            }
        }
        if (numCaja == -1) throw new CajaException("No hay ninguna caja abierta");

        for (int i = numCaja + 1; i < NUM_DE_CAJAS; i++) {
            if (cajas[i].isActiva() && cajas[i].getNumClientes() < cajas[numCaja].getNumClientes()) {
                numCaja = i;
            }
        }

        return numCaja;
    }

    /**
     * Método que asigna un cliente a una {@link Caja caja}
     * @return Una cadena que incluye el número del cliente y la caja asignada
     * @throws CajaException Propagada desde {@link Almacen#cajaMasVacia()}
     */
    public String aniadirCliente() throws CajaException {
        int numCaja = cajaMasVacia();
        cajas[numCaja].nuevoCliente(++cantidadClientes);
        return "Es usted el cliente número " + cantidadClientes + " y debe ir a la caja " + numCaja + 1;
    }

    /**
     * Método que, ha una {@link Caja caja} en cuestión, elimina la cabeza de la cola de clientes
     * @param numCaja La posición de la caja en el array + 1
     * @return Una cadena que muestra que el cliente ha sido atendido
     * @throws CajaException Propagada desde {@link Caja#clienteAtendido()}
     */
    public String atenderCliente(int numCaja) throws CajaException {
        return "El cliente con número " + cajas[--numCaja].clienteAtendido() + " ha sido atendido.";
    }

    /**
     * Método que cambiará el estado de la caja a cerrado
     * @param numCaja La posición de la caja en el array + 1
     * @throws CajaException Propagada desde {@link Caja#cerrar()}
     */
    public void cerrarCaja(int numCaja) throws CajaException {
        cajas[--numCaja].cerrar();
    }

    /**
     * Método que cambiará el estado de la caja a abierta
     * @param numCaja La posición de la caja en el array + 1
     * @throws CajaException Propagada desde {@link Caja#abrir()}
     */
    public void abrirCaja(int numCaja) throws CajaException {
        cajas[--numCaja].abrir();
    }
}
