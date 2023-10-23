package PruebaA;

public class Main {
    public static void main(String[] args) {
        int[] miArray = new int[5];
        int[] miArray2 = {1, 2, 3, 4, 5};
        int j = 0;

        /*for (int i : miArray2) {
            System.out.println(i);
        }*/

        /*for (int i = 0; i < miArray2.length; i++) {
            System.out.println(miArray2[i]);
        }*/
        /*for (int i = miArray2.length - 1; i >= 0; i--) {
            miArray[j] = miArray2[i];
            j++;
        }*/
        for (int i = miArray2.length - 1; i >= 0; i--) {
            miArray[miArray.length - 1 - i] = miArray2[i];
        }
        for (int elem : miArray) {
            System.out.println(elem);
        }

    }
}
