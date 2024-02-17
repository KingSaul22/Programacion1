package ObjCartas;

public class CartaConstrEscudo extends CartaConstruccion{
    //TODO: duda, no funciona -> private final int PRECIO_ESCUDO = 5;
    private static final int PRECIO_ESCUDO = 5;
    private int defensa = 20;
    public CartaConstrEscudo(String nombre, int sumar){
        super(nombre, PRECIO_ESCUDO);
        sumarDefensa(sumar);
    }

    public void sumarDefensa(int sumar){
        defensa += sumar;
    }

    public int getDefensa() {
        return defensa;
    }
}
