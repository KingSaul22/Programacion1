package Ejer4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> prueba = new ArrayList<>();
        prueba.add(1);
        prueba.add(2);
        prueba.add(3);
        System.out.println(Arrays.toString(prueba.toArray()));

        System.out.println();
        if (prueba instanceof ArrayList<Integer>) {
            System.out.println(Arrays.toString(reverse((ArrayList) prueba).toArray()));
            System.out.println();
            reverse((ArrayList) prueba).stream().forEach(a -> System.out.println(a));
        }

    }

    private static <T> ArrayList<T> reverse(ArrayList<T> arrayOriginal) {
        ArrayList<T> arrayNuevo = new ArrayList<>(arrayOriginal.size());

        for (int i = arrayOriginal.size() - 1; i >= 0; i--) arrayNuevo.add(arrayOriginal.get(i));

        /*int i = 0;
        for (T elemento : arrayOriginal) {
            arrayNuevo.add(arrayOriginal.get(arrayOriginal.size() - 1 + i--));
        }

        int aux = arrayOriginal.size() - 1;
        Iterator<T> iterador = arrayOriginal.iterator();
        while (iterador.hasNext()) {
            arrayNuevo.set(aux--, iterador.next());
            //arrayNuevo.set(0, iterador.next());
        }*/

        return arrayNuevo;
    }
}
