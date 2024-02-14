import Excepciones.IllegalValueException;

public class Main {
    private static Dado dadoA;
    private static Dado dadoB;
    private static Dado dadoC;

    public static void main(String[] args) {

    }

    private static void generarDadosDefault() {
        //Crear variables final para los dados default(?)
        try {
            dadoA = new Dado(4, 2);
            dadoB = new Dado(12, 1);
            dadoC = new Dado(6, 10);
        } catch (IllegalValueException e) {
            System.out.println(e.getMessage());
        }
    }
}
