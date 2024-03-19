package colecciones.ejercicio2;

import java.util.LinkedList;


public class ListaGenerica<T> {

	private LinkedList<T> lista;

	public ListaGenerica() {
		lista = new LinkedList<T>();
	}

	public void annadirElemento(T elemento) {
		lista.add(elemento);
	}

	public ListaGenerica<T> listaHastaElemento( T elementoBuscado) {
		
	}


	

	@Override
	public String toString() {
		return "ListaGenerica=" + lista ;
	}
	
	
	
}
