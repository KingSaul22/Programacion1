package Ejer3;

public class Maquina {

    private static final int MAX_DEPOS_CAFE = 50;
    private static final int MAX_DEPOS_LECHE = 50;
    private static final int MAX_DEPOS_VASOS = 80;
    private static final double MONEDERO_INICIAL = 150;
    protected static final double PRECIO_CAFE = 1;
    protected static final double PRECIO_LECHE = 0.8;
    protected static final double PRECIO_CAFE_LECHE = 1.5;

    private int cafeRestante;
    private int lecheRestante;
    private int vasosRestante;
    private double monedero;

    public Maquina() {
        rellenarDepositos();
        monedero = MONEDERO_INICIAL;

    }

    public int getCafeRestante() {
        return cafeRestante;
    }

    public int getLecheRestante() {
        return lecheRestante;
    }

    public int getVasosRestante() {
        return vasosRestante;
    }

    public void rellenarDepositos() {

        cafeRestante = MAX_DEPOS_CAFE;
        lecheRestante = MAX_DEPOS_LECHE;
        vasosRestante = MAX_DEPOS_VASOS;
    }

    public void vaciarMonedero() {
        monedero = 0;
    }

    @Override
    public String toString() {
        return "Los depositos de la máquina de café se encuentran en el siguiente estado:\n Café: " + cafeRestante +
                "\n Leche: " + lecheRestante + "\n Vasos: " + vasosRestante +
                "\n Monedero: " + monedero;
    }
}
