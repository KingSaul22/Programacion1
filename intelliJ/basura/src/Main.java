import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //OPERADORES ARITMETICOS:

        /*int numeroA = 5;
        int numeroB = 7;
        //Suma de dos números:
        int suma = numeroA + numeroB;
        System.out.printf("%d + %d = %d\n", numeroA, numeroB, suma);
        //Resta de dos numeros:
        int resta = suma - numeroA;
        System.out.printf("%d - %d = %d\n", suma, numeroA, resta);
        //Multiplicación de dos números:
        int producto = resta * numeroB;
        System.out.printf("%d * %d = %d\n", resta, numeroB, producto);
        //División de dos números:
        int division = producto / numeroA;
        System.out.printf("%d / %d = %d\n", producto, numeroA, division);
        //Recoger el resto de una división usando el módulo:
        int resto = producto % numeroA;
        System.out.printf("%d %s %d = %d\n", producto, "%", numeroA, resto);*/



        int contar = 0;
        for (int j = 0; j<1000;j++){
            for (int i = 0; i < 2073600; i++) {
                if (Math.random() * 100 < 3) {
                    //System.out.println("fallo");
                    contar++;
                }
            }
        }
        System.out.println(contar/1000);
        //[62206, 62210]

        int contarb = 0;
        for (int j = 0; j<1000;j++){
            for (int i = 0; i < 2073600; i++) {
                if (Math.random() * 100 <= 3) {
                    //System.out.println("fallo");
                    contarb++;
                }
            }
        }
        System.out.println(contarb/1000);
        //[62198, 62208]
    }
}