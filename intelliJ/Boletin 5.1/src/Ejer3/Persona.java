package Ejer3;

import java.util.ArrayList;
import java.util.List;

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
}
