package Ejer5;

import java.util.*;

public class Diccionario {
    private Map<String, List<String>> diccionario;

    public Diccionario() {
        diccionario = new HashMap<>();
    }

    public void nuevaPalabra(String palabra, String significado) {
        /*List<String> significados = new ArrayList<>();
        if (diccionario.get(palabra) != null) {
            significados = new ArrayList<>(diccionario.get(palabra));
        }

        significados.add(significado);
        diccionario.put(palabra, significados);*/

        if (diccionario.containsKey(palabra)) {
            diccionario.get(palabra).add(significado);
        } else {
            List<String> significados = new ArrayList<>();
            significados.add(significado);
            diccionario.put(palabra, significados);
        }
    }

    public List<String> getSignificadosPalabra(String palabra) throws DiccionarioException {
        List<String> significados = diccionario.get(palabra);
        if (significados == null) {
            throw new DiccionarioException("El diccionario no contiene la palabra " + palabra);
        }
        return significados;
    }

    public void borrarPalabra(String palabra) throws DiccionarioException {
        if (diccionario.remove(palabra) == null)
            throw new DiccionarioException("La palabra introducida no existe en el diccionario");
    }

    public List<String> getPalabrasCadenaLetra(String cadena){
        return diccionario.keySet().stream().filter(a -> a.startsWith(cadena)).sorted().toList();
        //return diccionario.keySet().stream().filter(a -> a.startsWith(cadena)).toList();
    }
}
