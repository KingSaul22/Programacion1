package Ejer1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        /*for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0 && i % 13 == 0) {
                System.out.println(i + " es divisible por 7 y 13.");
            } else if (i % 7 == 0) {
                System.out.println(i + " es divisible por 7");
            } else if (i % 13 == 0) {
                System.out.println(i + " es divisible por 13");
            }
        }*/
        Random rnd = new Random();
        int a;
        System.out.println("inicio\n");

        for (int i = 0; i < 10; i++){

            a = rnd.nextInt(10);
            System.out.print(a + " | ");
        }

        System.out.println("\n\nacaba");


        /*
        for (int i = 1; i <= 100; i++) {
            boolean mult7 = i % 7 == 0;
            boolean mult13 = i % 13 == 0;

            if (mult7) {
                if (mult13) {
                    System.out.println(i + " es divisible por 7 y 13.");
                } else {
                    System.out.println(i + " es divisible por 7.");
                }
            } else {
                if (mult13) {
                    System.out.println(i + " es divisible 13.");
                }
            }
        }
        System.out.println("\n\n\n");

        for (int i=0 ;i<3;i++){
            System.out.println(i);
        }*/
    }
}