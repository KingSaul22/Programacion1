public class Main {
    private static int numCaras = 4;
    private static int minValorCara = 2;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) System.out.println(lanzar());
    }

    public static int lanzar() {
        return (int) (Math.random() * numCaras + minValorCara);
    }
}