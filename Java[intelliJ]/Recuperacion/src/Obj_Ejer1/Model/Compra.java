package Obj_Ejer1.Model;

import java.time.LocalDateTime;

public class Compra {
    private static int contCompras = 1;
    private int id;
    private Cliente cliente;
    private Mascota mascota;
    private LocalDateTime fecha_compra;
    private LocalDateTime fecha_devo;

    public Compra(Cliente cliente, Mascota mascota) {
        this.cliente = cliente;
        this.mascota = mascota;
        this.id = contCompras++;
        this.fecha_compra = LocalDateTime.now();
        this.fecha_devo = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public LocalDateTime getFecha_devo() {
        return fecha_devo;
    }

    public void setFecha_devo(LocalDateTime fecha_devo) {
        this.fecha_devo = fecha_devo;
    }
}
