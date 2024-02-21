package Ejer3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensaje {
    private Persona remitente;
    private String text;
    private LocalDateTime fecha;

    public Mensaje(Persona remitente, String text) {
        this.remitente = remitente;
        this.text = text;
        fecha = LocalDateTime.now();
    }

    public Persona getRemitente() {
        return remitente;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm");
        StringBuilder mensaje = new StringBuilder("De: ")
                .append(remitente.getNombre())
                .append(" Texto: ").append(text)
                .append(" Fecha y hora: ").append(fecha.format(format));
        return mensaje.toString();
    }
}
