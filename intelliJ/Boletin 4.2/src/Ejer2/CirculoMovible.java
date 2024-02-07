package Ejer2;

public class CirculoMovible extends Forma implements Animable, Dibujable {
    private double radio;

    public CirculoMovible(double radio) {
        this.radio = radio;
    }

    @Override
    public void animar() {
        System.out.println("Animando circulo");
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando circulo");
    }

    @Override
    public double calcularArea() {
        return 2 * Math.PI * radio;
    }
}
