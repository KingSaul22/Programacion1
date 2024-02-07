package Ejer2;

public class Rectangulo extends Forma implements Dibujable {
    private double lado1, lado2;

    public Rectangulo(double lado1, double lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un rectangulo");
    }

    @Override
    public double calcularArea() {
        return lado1 * lado2;
    }
}
