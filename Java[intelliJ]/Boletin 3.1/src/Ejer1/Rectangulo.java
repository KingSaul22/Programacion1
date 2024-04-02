package Ejer1;

public class Rectangulo {
    private double longitud = 1, ancho = 1;
    private double area, perimetro;

    protected Rectangulo(double a, double b) {
        setAncho(a);
        setLado(b);
        calcArea();
        calcPerimetro();
    }

    private void setLado(double a) {

        longitud = a;
    }

    private void setAncho(double ancho) {

        this.ancho = ancho;
    }

    private void calcArea() {
        this.area = longitud * ancho;
    }

    private void calcPerimetro() {
        this.perimetro = longitud * 2 + ancho * 2;
    }

    @Override
    public String toString() {
        return "\nEl rectangulo posee una base de " + longitud + "u y una altura de " + ancho
                + "u.\nSu perimetro es de " + perimetro + "u y su area de " + area + "u^2";
    }
}
