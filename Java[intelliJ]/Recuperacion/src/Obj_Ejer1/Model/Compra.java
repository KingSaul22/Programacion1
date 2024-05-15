package Obj_Ejer1.Model;

import java.time.LocalDateTime;

public class Compra {
    private static int contCompras = 1;
    private int id;
    private Cliente cliente;
    private Mascota mascota;
    private LocalDateTime fecha;

    public Compra(Cliente cliente, Mascota mascota) {
        this.cliente = cliente;
        this.mascota = mascota;
        this.id = contCompras++;
        this.fecha = LocalDateTime.now();
    }
}
