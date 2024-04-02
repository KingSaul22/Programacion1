package Ejer6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca el número de alumnos de la clase");
        int alum = sc.nextInt();
        int i;
        int aprob = 0;
        float nota;

        for (i = 1; i <= alum; i++) {
            System.out.printf("Introduzca la nota del %dº alumno.\n", i);
            nota = sc.nextFloat();

            if (nota >= 5) {
                aprob++;
            }
        }

        float porcAprob =  100 / (float) alum * aprob;
        float porcSusp = 100 - porcAprob;

        //System.out.printf("De los %d alumnos, %d% están aprobados y el otro %d% está suspenso.", alum, porcAprob, 100 - porcAprob);
        System.out.println("De los " + alum + " alumnos, " + porcAprob + "% están aprobados y el otro " + porcSusp + "% está suspenso.");

    }
}
