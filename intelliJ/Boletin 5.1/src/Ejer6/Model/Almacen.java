package Ejer6.Model;

import Ejer6.Excepciones.CajaException;

public class Almacen {
    private static final int NUM_CAJAS = 20;
    private Caja[] cajas;

    public Almacen() {
        cajas = new Caja[NUM_CAJAS];
        for (int i = 0; i < NUM_CAJAS; i++) {
            cajas[i] = new Caja(i + 1);
        }
    }

    public String atenderCliente(int numCaja) throws CajaException {
        return "El cliente con número " + cajas[--numCaja].clienteAtendido() + " ha sido atendido.";
    }

    public void cerrarCaja(int numCaja) throws CajaException {
        cajas[--numCaja].cerrar();
    }

    public void abrirCaja(int numCaja) throws CajaException{
        cajas[--numCaja].abrir();
    }
}
