package Ejer2;

import java.util.Iterator;
import java.util.LinkedList;


public class ListaGenerica<T extends Comparable<? super T>> {

    private LinkedList<T> lista;

    public ListaGenerica() {
        lista = new LinkedList<T>();
    }

    public void annadirElemento(T elemento) {
        lista.add(elemento);
    }


    /**
     * Método que crea una ListaGenerica a la que se le irá añadiendo los elementos de esta propia lista;
     * desde la posición 0, hasta el elementoBuscado.
     *
     * @param elementoBuscado Elemento generico que marca el fin de la copia (incluido)
     * @return Una copia de una Lista Generica que incluye hasta el elementoBuscado
     */
    public ListaGenerica<T> listaHastaElemento(T elementoBuscado) {
        ListaGenerica<T> nuevaLista = new ListaGenerica<>();

        /*Iterator<T> it = lista.iterator();
        while (it.hasNext()) {
            var ob = it.next();
            nuevaLista.annadirElemento(ob);
            if (ob == elementoBuscado) {
                return nuevaLista;
            }
        }*/

        for (T elem : lista) {
            nuevaLista.annadirElemento(elem);
            if (elem.equals(elementoBuscado)) {
                return nuevaLista;
            }
        }

        return null;
    }

    /**
     * Método que crea una ListaGenerica a la que se le irá añadiendo los elementos de esta propia lista;
     * que sean menores al elementoBuscado
     *
     * @param elementoBuscado Elemento generico que marca el pivote de la copia (excluido)
     * @return Una copia de una Lista Generica que incluye los elementos menores al elementoBuscado
     */
    public ListaGenerica<T> elementosMenores(T elementoBuscado) {
        ListaGenerica<T> nuevaLista = new ListaGenerica<>();

        /*boolean encontrado = false;
        Iterator<T> it = lista.iterator();
        while (it.hasNext()) {
            var ob = it.next();
            if (ob == elementoBuscado) {
                encontrado = true;
            } else if (ob.compareTo(elementoBuscado) < 0) {
                nuevaLista.annadirElemento(ob);
            }
        }

        return encontrado ? nuevaLista : null;*/


        for (T elem : lista) {
            if (elem.compareTo(elementoBuscado) < 0) {
                nuevaLista.annadirElemento(elem);
            }
        }

        return nuevaLista.lista.isEmpty() ? null : nuevaLista;
    }

    @Override
    public String toString() {
        return "ListaGenerica=" + lista;
    }
}
