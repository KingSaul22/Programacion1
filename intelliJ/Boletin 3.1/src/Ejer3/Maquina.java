package Ejer3;

public class Maquina {

    private static final int MAX_DEPOS_CAFE = 100;
    private static final int MAX_DEPOS_LECHE = 50;
    private static final int MAX_DEPOS_VASOS = 150;
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
}
