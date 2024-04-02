package PruebaMatrizChar;

public class Main {
    public static void main(String[] args) {
        char muerte = 0;
        System.out.println(muerte);


        char[][] valorBasico = new char[2][2];
        valorBasico[1][0]='a';
        for (int a = 0; a < valorBasico.length; a++) {
            for (int b = 0; b < valorBasico[0].length; b++) {

                if (valorBasico[a][b] == 0) {
                    System.out.print(valorBasico[a][b]);
                } else {
                    System.out.print("Aqui no hay");
                }
            }
            System.out.println();
        }
    }
}