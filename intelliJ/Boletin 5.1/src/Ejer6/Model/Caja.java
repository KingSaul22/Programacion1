package Ejer6.Model;

import Ejer6.Excepciones.CajaException;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Caja {
    private Queue<Integer> clientes;
    private int numCaja;
    private boolean activa;

    public Caja(int numCaja) {
        //this.clientes = new ArrayDeque<>();
        this.clientes = new LinkedList<>();
        this.numCaja = numCaja;
        this.activa = false;
    }

    public boolean isActiva() {
        return activa;
    }

    /**
     * Método que cambia el estado de la caja a cerrado
     * @throws CajaException En caso de que la caja ya esté cerrada o haya clientes que atender
     */
    public void cerrar() throws CajaException {
        if (!activa) throw new CajaException("La caja ya está cerrada");
        if (!clientes.isEmpty()) throw new CajaException("Todavía hay clientes en la caja");

        activa = false;
    }

    /**
     * Método que cambia el estado de la caja a abierto
     * @throws CajaException En caso de que la caja ya esté abierta
     */
    public void abrir() throws CajaException {
        if (activa) throw new CajaException("La caja ya está abierta");
        activa = true;
    }

    /**
     * Método que libera la cabeza de la cola clientes y devuelve su número
     * @return El número del cliente
     * @throws CajaException Cuando la caja está cerrada o no tiene clientes
     */
    int clienteAtendido() throws CajaException {
        if (!activa) throw new CajaException("La caja seleccionada está cerrada");
        //if (clientes.isEmpty()) throw new CajaException("La caja no tiene clientes");
        try {
            return clientes.remove();
        }catch (NoSuchElementException e){
            throw new CajaException("La caja no tiene clientes");
        }
    }

    /**
     * Método que añade un cliente a la {@link Caja#clientes cola}
     * @param numCliente El cliente en cuestiíon
     */
    void nuevoCliente(int numCliente) {
        clientes.add(numCliente);
    }

    /**
     *
     * @return Tamaño de la {@link Caja#clientes cola de clientes}
     */
    int getNumClientes() {
        return clientes.size();
    }
}
