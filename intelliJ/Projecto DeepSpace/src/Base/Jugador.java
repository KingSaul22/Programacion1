package Base;

import Excepciones.IllegalValueException;
import ObjCartas.CartaConstruccion;

public class Jugador {
    private String nombre;
    private Planeta[] planetas;
    private CartaConstruccion[] construcciones;
    private int oro = 3;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public void setNewCartaConstruccion(CartaConstruccion construccion){

    }

    /**
     *
     * @return El nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que resta a la cartera de oro del jugador
     * @param gasto cantidad que se quiere gastar
     * @throws IllegalValueException Si no hay suficiente dinero o el gasto es negativo
     */
    public void gastarOro(int gasto) throws IllegalValueException {
        if (gasto < 0) throw new IllegalValueException("No son posibles los gastos negativos");
        if (gasto > oro) throw new IllegalValueException("No se disponen de los fondos suficientes");
        oro -= gasto;
    }

    /**
     * Método que suma al fondo de oro del jugador
     * @param ganancia Oro que se quiere añadir
     */
    public void conseguirOro(int ganancia) {
        oro += ganancia;
    }
}
