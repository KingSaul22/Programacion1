package Ejer6.Model;

import Ejer6.Excepciones.CajaException;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Caja {
    private Queue<Integer> clientes;
    private int numCaja;
    private boolean activa = false;

    public Caja(int numCaja) {
        clientes = new ArrayDeque<>();
        this.numCaja = numCaja;
    }

    public boolean isActiva() {
        return activa;
    }

    /**
     * Método que cambia el estado de la caja a cerrado
     * @throws CajaException En caso de que la caja ya esté cerrada o halla clientes que atender
     */
    public void cerrar() throws CajaException {
        if (!activa) throw new CajaException("La caja ya está cerrada");
        if (!clientes.isEmpty()) throw new CajaException("Todavía hay clientes en la caja");

        activa = false;
    }

    public void abrir() throws CajaException {
        if (activa) throw new CajaException("La caja ya está abierta");
        activa = true;
    }

    int clienteAtendido() throws CajaException {
        if (!activa) throw new CajaException("La caja seleccionada está cerrada");
        //if (clientes.isEmpty()) throw new CajaException("La caja no tiene clientes");
        try {
            return clientes.remove();
        }catch (NoSuchElementException e){
            throw new CajaException("La caja no tiene clientes");
        }
    }

    void nuevoCliente(int numCliente) {
        clientes.add(numCliente);
    }

    int getNumClientes() {
        return clientes.size();
    }
}
