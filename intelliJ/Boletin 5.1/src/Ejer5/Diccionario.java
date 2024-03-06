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
        //diccionario.get(palabra).forEach(a -> significados.append("\n  · ").append(a));

        return significados.toString();
    }

    public void borrarPalabra(String palabra) {
        diccionario.remove(palabra);
    }

    public String getPalabrasCadenaLetra(String cadena) {
        String cadenaBase = "Las palabras que comienzan por '" + cadena + "' son las siguientes:";
        StringBuilder palabras = new StringBuilder(cadenaBase);
        Set<String> palabrasDiccionario = diccionario.keySet();

        //palabrasDiccionario.removeIf(s -> !s.contains(cadena));
        Iterator<String> iterador = palabrasDiccionario.iterator();
        while (iterador.hasNext()) {
            if (!iterador.next().contains(cadena)) {
                iterador.remove();
            }
        }
        new ArrayList<>(palabrasDiccionario).stream().sorted().forEach(a -> palabras.append("\n  · ").append(a));


        if (palabras.toString().equals(cadenaBase)) {
            return "No hay palabras que comienzen por '" + cadena + "'";
        }

        return palabras.toString();
    }
}
