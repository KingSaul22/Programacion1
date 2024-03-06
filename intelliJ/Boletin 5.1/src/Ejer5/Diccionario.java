package Ejer5;

import java.util.*;

public class Diccionario {
    private Map<String, List<String>> diccionario;

    public Diccionario() {
        diccionario = new HashMap<>();
    }

    public void nuevaPalabra(String palabra, String significado) {
        List<String> significados = new ArrayList<>();
        if (diccionario.get(palabra) != null) {
            significados = new ArrayList<>(diccionario.get(palabra));
        }

        significados.add(significado);
        diccionario.put(palabra, significados);
    }

    public String buscarPalabra(String palabra) throws DiccionarioException {
        if (!diccionario.containsKey(palabra)) {
            throw new DiccionarioException("El diccionario no contiene la palabra " + palabra);
        }

        StringBuilder significados = new StringBuilder("Significados de " + palabra + ":");
        diccionario.get(palabra).stream().forEach(a -> significados.append("\n  · ").append(a));

        return significados.toString();
    }

    public void borrarPalabra(String palabra) {
        diccionario.remove(palabra);
    }

    public String getPalabrasCadenaLetra(String cadena) {
        Set<String> palabras = diccionario.keySet();

        //palabras.removeIf(s -> !s.contains(cadena));
        Iterator<String> iterador = palabras.iterator();
        while (iterador.hasNext()) {
            if (!iterador.next().contains(cadena)) {
                iterador.remove();
            }
        }

        return palabras.toString();
    }
}
