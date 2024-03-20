package Model;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Receta {
    private String nombre;
    private double duracionMin;
    private List<String> pasos;
    private Map<String, Integer> ingredientes;

    public Receta(String nombre, double duracionMin) {
        this.nombre = nombre;
        this.duracionMin = duracionMin;
        this.pasos = new LinkedList<>();
        this.ingredientes = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Map<String, Integer> getIngredientes() {
        return ingredientes;
    }

    public void addPaso(String paso) {
        pasos.add(paso);
    }

    public void addIngrediente(String nombre, int cantidad) {
        Integer cantidadPrevia = ingredientes.putIfAbsent(nombre, cantidad);
        if (cantidadPrevia != null) ingredientes.replace(nombre, cantidadPrevia + cantidad);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n\nInformación sobre la receta '").append(nombre)
                .append("'. (").append(duracionMin).append(" min)")
                .append("\nPasos: ").append(getPasosFormat())
                .append("\nIngredientes: ").append(getIngredientesFormat());

        return sb.toString();
    }

    private String getPasosFormat() {
        if (pasos.isEmpty()) return "**No hay pasos establecidos para esta receta**";

        StringBuilder cadena = new StringBuilder();
        int numPaso = 0;

        for (String paso : pasos) cadena.append("\n  ").append(++numPaso).append(". ").append(paso);

        return cadena.toString();
    }

    private String getIngredientesFormat() {
        if (ingredientes.isEmpty()) return "**No hay ingredientes establecidos para esta receta**";

        StringBuilder cadena = new StringBuilder();
        /*int numIn = 0;

        for (Map.Entry<String, Integer> entrada : ingredientes.entrySet()) {
            cadena.append("\n  ").append(++numIn).append(". ").append(entrada.getKey())
                    .append(". (").append(entrada.getValue()).append(")");
        }*/

        AtomicInteger cont = new AtomicInteger();
        ingredientes.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).forEach(a ->
                cadena.append("\n  ").append(cont.incrementAndGet()).append(". ").append(a.getKey())
                        .append(". (").append(a.getValue()).append(")")
        );

        return cadena.toString();
    }
}
