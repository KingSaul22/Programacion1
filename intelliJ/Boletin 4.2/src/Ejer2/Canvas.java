package Ejer2;

public class Canvas {
    public static void main(String[] args) {
        Forma[] figuras = new Forma[]{new Circulo(10), new Rectangulo(2, 4), new CirculoMovible(4), new Linea(5.3)};

        dibujaYAnimaFormas(figuras);
    }

    public static void dibujaYAnimaFormas(Forma[] formas) {
        int i = 0;
        for (Forma figura : formas) {
            System.out.println("\nFigura " + i++ + ":");

            if (figura instanceof Dibujable) ((Dibujable) figura).dibujar();
            if (figura instanceof Animable) ((Animable) figura).animar();

            try {
                System.out.println("El area de esta forma es: " + figura.calcularArea());
            } catch (FormaException e) {
                System.out.println(e.getMessage());
                System.err.println(e.getMessage());
            }
        }
    }
}
