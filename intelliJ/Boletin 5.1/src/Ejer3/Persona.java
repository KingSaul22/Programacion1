package Ejer3;

import java.util.*;
import java.util.stream.Stream;

public abstract class Persona {
    private String nombre;
    private List<Mensaje> bandejaEntrada;

    public Persona(String nombre) {
        this.nombre = nombre;
        bandejaEntrada = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void sendMessage(Persona receptor, String mensaje) throws MensajeException {
        receptor.bandejaEntrada.add(new Mensaje(this, mensaje));
    }

    public String leerMensajes() {
        StringBuilder mensajes = new StringBuilder();
        for (int i = 0; i < bandejaEntrada.size(); i++) {
            mensajes.append("Mensaje ").append(i + 1).append(": ").append(bandejaEntrada.get(i)).append("\n");
        }

        return mensajes.toString();
    }

    public String leerMensajesOrdenados() {
        List<Mensaje> bandejaOrdenada = new ArrayList<>(bandejaEntrada);
        bandejaOrdenada.sort(null);

        StringBuilder mensajes = new StringBuilder();
        for (int i = 0; i < bandejaOrdenada.size(); i++) {
            mensajes.append("Mensaje ").append(i + 1).append(": ").append(bandejaOrdenada.get(i)).append("\n");
        }

        return mensajes.toString();
    }

    public String leerMensajesOrdenadosAlfabeti() {
        List<Mensaje> bandejaOrdenada = new ArrayList<>(bandejaEntrada);
        /*Comparator<Mensaje> alfabComparator = new Comparator<Mensaje>() {
            @Override
            public int compare(Mensaje o1, Mensaje o2) {
                return o1.getRemitente().getNombre().compareTo(o2.getRemitente().getNombre());
            }
        };
        bandejaOrdenada.sort(alfabComparator);*/

        //Collections.sort(bandejaOrdenada, (a, b)->{return a.getRemitente().getNombre().compareTo(b.getRemitente().getNombre());});
        bandejaOrdenada.sort((a, b) -> a.getRemitente().getNombre().compareTo(b.getRemitente().getNombre()));
        //bandejaOrdenada.sort(Comparator.comparing(a -> a.getRemitente().getNombre()));

        StringBuilder mensajes = new StringBuilder();
        for (int i = 0; i < bandejaOrdenada.size(); i++) {
            mensajes.append("Mensaje ").append(i + 1).append(": ").append(bandejaOrdenada.get(i)).append("\n");
        }

        return mensajes.toString();
    }

    public void borrarMensaje(int numero) throws MensajeException {
        try {
            bandejaEntrada.remove(numero - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new MensajeException("No existe ese mensaje");
        }
    }

    public String filtrarMensajePorFrase(String frase) throws MensajeException {
        StringBuilder mensajes = new StringBuilder();

        //bandejaEntrada.stream().filter(m -> m.getText().contains(frase)).forEach(m -> mensajes.append("\n").append(m));

        //bandejaEntrada.stream().map(m -> m.getText())
        bandejaEntrada.stream().map(m -> m.toString())
                .filter(m -> m.contains(frase))
                .forEach(m -> mensajes.append("\n").append(m));

        if (mensajes.isEmpty()) throw new MensajeException("No existen mensajes con esa frase");
        return mensajes.toString();
    }


    public String filtrarMensajePorFraseSinFlujo(String frase) throws MensajeException {
        StringBuilder mensajes = new StringBuilder();

        for (int i = 0; i < bandejaEntrada.size(); i++) {
            if (bandejaEntrada.get(i).getText().contains(frase)){
                mensajes.append("Mensaje ").append(i + 1).append(": ").append(bandejaEntrada.get(i)).append("\n");
            }
        }

        if (mensajes.isEmpty()) throw new MensajeException("No existen mensajes con esa frase");
        return mensajes.toString();
    }
}
