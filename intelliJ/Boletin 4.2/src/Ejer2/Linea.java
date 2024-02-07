package Ejer2;

public class Linea extends Forma{
    private double distancia;

    public Linea(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public double calcularArea() throws FormaException{
        throw new FormaException("La linea no puede representar su area.");
    }
}
