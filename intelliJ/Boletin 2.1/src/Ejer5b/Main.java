package Ejer5b;

//import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final int numRandom = 1001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica el tamaño del Array");
        int numArray = sc.nextInt();
        sc.close();
        System.out.println();

        int[] arrayAleatorio = generaArrayAleatorio(numArray);

        for (int elem : arrayAleatorio) {
            System.out.println(elem);
        }
        //System.out.println();

        //Arrays.stream(arrayAleatorio).sorted().forEach(System.out::println);
    }

    public static int[] generaArrayAleatorio(int tamArray) {
        int[] miArray = new int[tamArray];

        for (int elem = 0; elem <= miArray.length - 1; elem++) {
            miArray[elem] = (int) (Math.random() * (numRandom + 1));
        }

        return miArray;
    }
}