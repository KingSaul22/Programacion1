

public class Main {


    public static void main(String[] args) {
        double media = 0;
        int intentos = 20000;
        byte valor;
        for (int j = 0; j < 20; j++) {

            for (int i = 0; i < intentos; i++) {
                valor = (byte) (Math.random() * 3);
                media += valor;
            }
            System.out.println(media / intentos);
            media = 0;
        }
    }


}