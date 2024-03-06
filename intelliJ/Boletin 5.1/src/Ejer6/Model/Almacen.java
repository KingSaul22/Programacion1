package Ejer6.Model;

import Ejer6.Excepciones.CajaException;

public class Almacen {
    private static final int NUM_CAJAS = 20;
    private Caja[] cajas;
    private int cantidadClientes = 0;

    public Almacen() {
        cajas = new Caja[NUM_CAJAS];
        for (int i = 0; i < NUM_CAJAS; i++) {
            cajas[i] = new Caja(i + 1);
        }
    }

    private int cajaMasVacia() throws CajaException {
        int numCaja = -1;

        for (int i = 0; i < NUM_CAJAS; i++) {
            if (cajas[i].isActiva()) {
                numCaja = i;
                break;
            }
        }
        if (numCaja == -1) throw new CajaException("No hay ninguna caja abierta");

        for (int i = numCaja + 1; i < NUM_CAJAS; i++) {
            if (cajas[i].isActiva() && cajas[i].getNumClientes() < cajas[numCaja].getNumClientes()) {
                numCaja = i;
            }
        }

        return numCaja;
    }

    public String aniadirCliente() throws CajaException {
        int numCaja = cajaMasVacia();
        cajas[numCaja].nuevoCliente(++cantidadClientes);
        return "Es usted el cliente número " + cantidadClientes + " y debe ir a la caja " + numCaja;
    }

    public String atenderCliente(int numCaja) throws CajaException {
        return "El cliente con número " + cajas[--numCaja].clienteAtendido() + " ha sido atendido.";
    }

    public void cerrarCaja(int numCaja) throws CajaException {
        cajas[--numCaja].cerrar();
    }

    public void abrirCaja(int numCaja) throws CajaException {
        cajas[--numCaja].abrir();
    }
}
