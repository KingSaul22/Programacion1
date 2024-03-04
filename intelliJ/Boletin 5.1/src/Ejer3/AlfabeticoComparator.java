package Ejer3;

import java.util.Comparator;

public class AlfabeticoComparator implements Comparator<Mensaje> {
    @Override
    public int compare(Mensaje o1, Mensaje o2) {
        return o1.getRemitente().getNombre().compareTo(o2.getRemitente().getNombre());
    }
}
