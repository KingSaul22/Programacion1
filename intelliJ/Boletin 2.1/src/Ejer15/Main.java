package Ejer15;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int tamArray;
    public static int[] miArray;

    //public static int[] miArrayPrimo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca hasta que número desea examinar si es primo:");
        tamArray = sc.nextInt();
        sc.close();

        generaArray();

        int[] miArrayPrimo = buscaPrimos();
        System.out.println(Arrays.toString(miArrayPrimo));
    }

    public static void generaArray() {
        miArray = new int[tamArray];

        for (int elem = 0; elem < miArray.length; elem++) {
            miArray[elem] = elem + 1;
        }
        //System.out.println(Arrays.toString(miArray));
    }

    public static int[] buscaPrimos() {
        int contPrimos = 0;
        int buscador;

        for (int i = 1; i <= (tamArray + 1) / 2; i++) {
            if (miArray[i] != 0) {
                //contPrimos++;
                buscador = miArray[i] + i;

                while (buscador<tamArray){
                    miArray[buscador] = 0;
                    buscador += miArray[i];
                }
            }
        }
        for (int elem =0; elem< miArray.length;elem++){
            if (miArray[elem] != 0){
                contPrimos++;
            }
        }
        //System.out.println(Arrays.toString(miArray));
        System.out.println(contPrimos);

        int[] arrayPrimos = new int[contPrimos];
        contPrimos = 0;
        for (int elem = 0; elem < miArray.length; elem++) {
            if (miArray[elem] != 0) {
                arrayPrimos[contPrimos] = miArray[elem];
                contPrimos++;
            }
        }
        return arrayPrimos;
    }
}
